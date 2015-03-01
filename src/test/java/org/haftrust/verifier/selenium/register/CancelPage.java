package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CancelPage {

    private final WebDriver driver;

    public CancelPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body h1")).getText().equals("Verifier Registration - Cancel Confirmation")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }
}
