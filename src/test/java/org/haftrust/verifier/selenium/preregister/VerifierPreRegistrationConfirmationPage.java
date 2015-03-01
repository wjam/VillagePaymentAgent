package org.haftrust.verifier.selenium.preregister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifierPreRegistrationConfirmationPage {

    private final WebDriver driver;

    @FindBy(xpath = "//tr[1]/td[2]")
    private WebElement idElement;

    @FindBy(xpath = "//tr[2]/td[2]")
    private WebElement emailAddressElement;

    public VerifierPreRegistrationConfirmationPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("preregisterverifier.htm")
                || !driver.findElement(By.cssSelector("body h1")).getText().equals("Verifier Pre-Registration Confirmation")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public String getDisplayedId() {
        return idElement.getText();
    }

    public String getDisplayedEmailAddress() {
        return emailAddressElement.getText();
    }

}
