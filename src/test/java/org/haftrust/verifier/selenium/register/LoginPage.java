package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(css = "input[name='email']")
    private WebElement emailAddressField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css= "input[type='submit']")
    private WebElement submitButton;

    public LoginPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Enter your LogIn details")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public LoginPage enterEmail(final String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
        return this;
    }

    public LoginPage enterPassword(final String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public String getEmailAddressErrorMessage() {
        return errorMessageForField(emailAddressField);
    }

    public String getPasswordErrorMessage() {
        return errorMessageForField(passwordField);
    }

    public LoginPage reset() {
        resetButton.click();
        return this;
    }

    public CountrySelectionPage submit() {
        submitButton.click();
        return PageFactory.initElements(driver, CountrySelectionPage.class);
    }

    public LoginPage submitExpectingError() {
        submitButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    private String errorMessageForField(final WebElement element) {
        return element.findElement(By.xpath("../..")).findElement(By.xpath("td[3]")).getText();
    }
}
