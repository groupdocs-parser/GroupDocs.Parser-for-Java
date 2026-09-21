// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.loading;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This example shows that an email message may refer to resources that are stored outside of
 * the message, and that extracting data from such a message makes the parser download them.
 **/
public class ExternalResourcesInEmailMessages {
    /**
     * The address of a publicly hosted image.
     * This image belongs to this repository, which is distributed under the MIT license
     * (see the LICENSE file in the repository root), therefore it is safe to refer to it here.
     **/
    private static final String ExternalImageUrl =
            "https://raw.githubusercontent.com/groupdocs-parser/GroupDocs.Parser-for-Java/master/"
                    + "Examples/Resources/SampleFiles/installation.png";

    /**
     * The address which is used as a clickable hyperlink in the message body.
     * The parser never requests it; it is here to show the difference between a hyperlink
     * and an external resource.
     **/
    private static final String HyperlinkUrl = "https://products.groupdocs.com/parser/java/";

    public static void run() throws IOException {
        // Create an email message which refers to an image that is stored on a remote server
        String filePath = createEmailMessage();
        System.out.println(String.format("A sample message is created: %s", filePath));
        System.out.println(String.format("Its body refers to an external image: %s", ExternalImageUrl));
        System.out.println(String.format("Its body also contains a clickable hyperlink: %s", HyperlinkUrl));

        // Watch the requests which are sent to remote servers while the message is parsed
        RequestWatcher watcher = RequestWatcher.install();
        try {
            // Extract a plain text; the external image isn't required to build it
            watcher.reset();
            try (Parser parser = new Parser(filePath)) {
                try (TextReader reader = parser.getText()) {
                    reader.readToEnd();
                }
            }

            watcher.print("getText");

            // Extract a formatted text; the message body is laid out as an HTML document,
            // therefore the external image is downloaded
            watcher.reset();
            try (Parser parser = new Parser(filePath)) {
                try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
                    reader.readToEnd();
                }
            }

            watcher.print("getFormattedText");

            // Extract a structure; the external image is downloaded as well.
            // The whole document is built by this call, there is nothing left to read afterwards
            watcher.reset();
            try (Parser parser = new Parser(filePath)) {
                parser.getStructure();
            }

            watcher.print("getStructure");

            // Try to prevent the download with an External Resource Handler.
            // Please note that email messages don't support this handler yet: onLoading isn't
            // called and the image is still downloaded
            Handler handler = new Handler();
            ParserSettings settings = new ParserSettings(handler);

            watcher.reset();
            try (Parser parser = new Parser(filePath, settings)) {
                try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
                    reader.readToEnd();
                }
            }

            watcher.print("getFormattedText with External Resource Handler");
            System.out.println(String.format("    onLoading is called: %s", handler.isCalled()));
        } finally {
            // Stop watching the requests
            watcher.uninstall();
        }

        System.out.println();
        System.out.println("The hyperlink isn't requested: the parser downloads external resources like images");
        System.out.println("and style sheets, but it never follows the links from a message body.");
    }

    /**
     * Creates an email message which refers to an image that is stored on a remote server.
     *
     * @return The path to the created message.
     **/
    private static String createEmailMessage() throws IOException {
        StringBuilder message = new StringBuilder();

        message.append("From: sender@example.com\r\n");
        message.append("To: receiver@example.com\r\n");
        message.append("Subject: A message with an external image\r\n");
        message.append("MIME-Version: 1.0\r\n");
        message.append("Content-Type: text/html; charset=utf-8\r\n");
        message.append("\r\n");
        message.append("<html><body>");
        message.append("<p>This message body refers to an image which is stored on a remote server.</p>");
        message.append("<p><a href=\"" + HyperlinkUrl + "\">This is a clickable hyperlink</a></p>");
        message.append("<p><img src=\"" + ExternalImageUrl + "\" width=\"100\" height=\"100\" /></p>");
        message.append("</body></html>\r\n");

        String filePath = Constants.getOutputFilePath("ExternalResourcesInEmailMessages.eml");
        Files.write(Paths.get(filePath), message.toString().getBytes(StandardCharsets.UTF_8));

        return filePath;
    }

    /**
     * This class provides the ability to control the loading of external resources.
     **/
    private static class Handler extends ExternalResourceHandler {
        private boolean isCalled;

        /**
         * Gets the value that indicates whether the handler is called at least once.
         **/
        public boolean isCalled() {
            return isCalled;
        }

        /**
         * Called before any external resource loads. It allows to skip unnecessary file loading.
         **/
        @Override
        public void onLoading(ExternalResourceLoadingArgs args) {
            isCalled = true;

            // Don't load this resource
            args.setSkipped(true);

            super.onLoading(args);
        }
    }

    /**
     * This class prints the addresses which are requested by the parser.
     * It is a proxy selector which doesn't select any proxy: every request is sent directly to
     * its server, the selector is used to observe the addresses only.
     **/
    private static class RequestWatcher extends ProxySelector {
        private final List<String> addresses = new ArrayList<>();
        private ProxySelector previousSelector;

        /**
         * Starts to watch the requests which are sent by the current process.
         *
         * @return An instance of RequestWatcher class.
         **/
        public static RequestWatcher install() {
            RequestWatcher watcher = new RequestWatcher();

            watcher.previousSelector = ProxySelector.getDefault();
            ProxySelector.setDefault(watcher);

            return watcher;
        }

        /**
         * Stops to watch the requests which are sent by the current process.
         **/
        public void uninstall() {
            ProxySelector.setDefault(previousSelector);
        }

        /**
         * Forgets the addresses which are watched before this call.
         **/
        public void reset() {
            synchronized (addresses) {
                addresses.clear();
            }
        }

        /**
         * Prints the addresses which are requested after the last reset call.
         *
         * @param methodName The name of the method which is called.
         **/
        public void print(String methodName) {
            System.out.println();
            System.out.println(String.format("%s sends the following requests to remote servers:", methodName));

            synchronized (addresses) {
                if (addresses.isEmpty()) {
                    System.out.println("    nothing is requested");
                    return;
                }

                for (String address : addresses) {
                    System.out.println(String.format("    -> %s", address));
                }
            }
        }

        /**
         * Returns the proxies for the requested address.
         *
         * @param uri The address which is requested.
         * @return No proxy: this selector isn't used to send the request.
         **/
        @Override
        public List<Proxy> select(URI uri) {
            add(uri);

            return Collections.singletonList(Proxy.NO_PROXY);
        }

        /**
         * Called when a connection cannot be established; there is no proxy to fall back to.
         **/
        @Override
        public void connectFailed(URI uri, SocketAddress socketAddress, IOException exception) {
            if (previousSelector != null) {
                previousSelector.connectFailed(uri, socketAddress, exception);
            }
        }

        private void add(URI address) {
            String scheme = address.getScheme();

            // A selector is asked about every connection, including the socket which is opened
            // to establish a TLS session. Keep the addresses of the documents only
            if (!"http".equals(scheme) && !"https".equals(scheme)) {
                return;
            }

            String value = address.toString();

            synchronized (addresses) {
                if (!addresses.contains(value)) {
                    addresses.add(value);
                }
            }
        }
    }
}
