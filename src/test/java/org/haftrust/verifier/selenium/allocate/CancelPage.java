package org.haftrust.verifier.selenium.allocate;

import org.openqa.selenium.WebDriver;

public class CancelPage {

    private final WebDriver driver;

    public CancelPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("/allocateDevice.htm")
                || !driver.getTitle().equals("HafTrust Verify Verifier - Cancel Verification Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }
}
