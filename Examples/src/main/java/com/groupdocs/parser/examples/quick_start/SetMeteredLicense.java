// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2023 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.quick_start;

import com.groupdocs.parser.licensing.Metered;

/**
 * This example demonstrates how to set Metered license.
 * Learn more about Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
 **/
public class SetMeteredLicense {
    public static void run() throws Exception {
        String publicKey = "*****";
        String privateKey = "*****";

        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);

        System.out.println("License set successfully.");
    }
}