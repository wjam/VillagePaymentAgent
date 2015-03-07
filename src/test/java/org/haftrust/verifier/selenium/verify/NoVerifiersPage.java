package org.haftrust.verifier.selenium.verify;

import org.openqa.selenium.WebDriver;

public class NoVerifiersPage {

    public NoVerifiersPage(final WebDriver driver) {
        if (!driver.getCurrentUrl().endsWith("/noVerifierForVerification.htm")
                || !driver.getTitle().equals("HafTrust Verify Verifier - No Verifiers found page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }
}
