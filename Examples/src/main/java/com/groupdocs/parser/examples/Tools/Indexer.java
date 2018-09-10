package com.groupdocs.parser.examples.Tools;

import com.groupdocs.parser.Extractor;
import com.groupdocs.parser.GroupDocsParserException;
import com.groupdocs.parser.IPasswordProvider;
import com.groupdocs.parser.LoadOptions;
import com.groupdocs.parser.PasswordRequest;
//ExStart:requestPasswordForProtectedDocument_18.9
public class Indexer {
	// A name of the current processed file
	private String currentFileName;

	// Processes the directory
	public void process(java.io.File dir) {
		// Create load options with Password Provider
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPasswordProvider(new PasswordProvider(this));

		// Process the sub-directories
		for (java.io.File file : dir.listFiles()) {
			if (file.isDirectory()) {
				// Process files in the directory
				process(file);
			} else {
				// Set the name of the current processed file
				currentFileName = file.getName();

				try {
					// Extract a text from the file
					String text = Extractor.DEFAULT.extractText(file.getPath(), loadOptions);
					// Print the length of the file
					System.out.println(
							String.format("%s, length: %d", currentFileName, (text == null ? "" : text).length()));
				} catch (GroupDocsParserException ex) {
					// Print an error message (for example, "Invalid Password")
					System.out.println(ex.getMessage());
				}
			}
		}
	}

	// Provides the ability to request a password from a user
	private class PasswordProvider implements IPasswordProvider {
		private final Indexer owner;

		public PasswordProvider(Indexer owner) {
			this.owner = owner;
		}

		// Requests a password from a user
		public void onPasswordRequest(Object sender, PasswordRequest request) {
			// Print a password request
			System.out.println("Enter password for" + owner.currentFileName + ":");
			java.util.Scanner scanner = new java.util.Scanner(System.in);
			String password = scanner.next();

			// If a user omits a password (entered a blank password)
			if ("" == password) {
				// Mark the request as cancelled
				request.setCancel(true);
			} else {
				// Set the password
				request.setPassword(password);
			}
		}
	}
}
//ExEnd:requestPasswordForProtectedDocument_18.9
