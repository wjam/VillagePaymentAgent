package org.haftrust.verifier.selenium.allocate;

import org.openqa.selenium.WebDriver;

public class NoVerifiersPage {

    public NoVerifiersPage(final WebDriver driver) {
        if (!driver.getCurrentUrl().endsWith("/noVerifierFound.htm")
                || !driver.getTitle().equals("HafTrust Allocate Mobile Device - No Verifiers found")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }
}
