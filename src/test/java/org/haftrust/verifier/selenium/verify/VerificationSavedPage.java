package org.haftrust.verifier.selenium.verify;

import org.openqa.selenium.WebDriver;

public class VerificationSavedPage {

    public VerificationSavedPage(final WebDriver driver) {
        if (!driver.getCurrentUrl().endsWith("/verifyVerifier.htm")
                || !driver.getTitle().equals("HafTrust Verify Verifier Save Confirmation Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }
}
