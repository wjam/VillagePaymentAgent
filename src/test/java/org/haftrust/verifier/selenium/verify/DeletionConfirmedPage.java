package org.haftrust.verifier.selenium.verify;

import org.openqa.selenium.WebDriver;

public class DeletionConfirmedPage {

    public DeletionConfirmedPage(final WebDriver driver) {
        if (!driver.getCurrentUrl().endsWith("/verifyVerifier.htm")
                || !driver.getTitle().equals("HafTrust Verify Verifier - Delete Application Confirmation Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

}
