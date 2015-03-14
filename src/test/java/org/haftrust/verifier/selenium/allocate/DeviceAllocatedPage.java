package org.haftrust.verifier.selenium.allocate;

import org.openqa.selenium.WebDriver;

public class DeviceAllocatedPage {

    private final WebDriver driver;

    public DeviceAllocatedPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("/allocateDevice.htm")
                || !driver.getTitle().equals("HafTrust Allocate Mobile Device - Confirmation Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }
}
