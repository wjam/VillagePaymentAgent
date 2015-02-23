package org.haftrust.verifier.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifierPreRegistrationPage {

    private final WebDriver driver;

    @FindBy(css = "input[name='email']")
    private WebElement emailAddressField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(css = "input[name='repassword']")
    private WebElement repeatedPasswordField;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public VerifierPreRegistrationPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("preregisterverifier.htm")
                && driver.findElement(By.cssSelector("body h1")).getText().equals("Verifier Pre-Registration")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public VerifierPreRegistrationPage enterEmail(final String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
        return this;
    }

    public VerifierPreRegistrationPage enterPassword(final String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public VerifierPreRegistrationPage renterPassword(final String password) {
        repeatedPasswordField.sendKeys(password);
        return this;
    }

    public String getEmailAddressErrorMessage() {
        return errorMessageForField(emailAddressField);
    }

    public String getReenteredPasswordErrorMessage() {
        return errorMessageForField(repeatedPasswordField);
    }

    public VerifierPreRegistrationPage reset() {
        resetButton.click();
        return this;
    }

    public VerifierPreRegistrationConfirmationPage submit() {
        submitButton.click();
        return PageFactory.initElements(driver, VerifierPreRegistrationConfirmationPage.class);
    }

    public VerifierPreRegistrationPage submitExpectingFailure() {
        submitButton.click();
        return PageFactory.initElements(driver, VerifierPreRegistrationPage.class);
    }

    private String errorMessageForField(final WebElement element) {
        return element.findElement(By.xpath("../..")).findElement(By.xpath("td[3]")).getText();
    }
}
