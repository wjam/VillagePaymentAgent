package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    public ConfirmationPage(final WebDriver driver) {
        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Registration of the Verifier Candidate has been successful")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

}
