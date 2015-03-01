package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Reference2Page {

    private final WebDriver driver;

    @FindBy(css = "select[name='reference2Title']")
    private WebElement titleSelection;

    @FindBy(css = "input[name='reference2FullName']")
    private WebElement fullName;

    @FindBy(css = "input[name='reference2OrganisationName']")
    private WebElement organisationName;

    @FindBy(css = "input[name='reference2Designation']")
    private WebElement designation;

    @FindBy(css = "input[name='reference2ContactNumber']")
    private WebElement contactNumber;

    @FindBy(css = "input[name='reference2Email']")
    private WebElement emailAddress;

    @FindBy(css = "input[name='reference2Address']")
    private WebElement address;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "input[name='_cancel']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target11']")
    private WebElement saveButton;

    @FindBy(css = "input[name='_target7']")
    private WebElement backButton;

    @FindBy(css = "input[name='_finish']")
    private WebElement registerButton;

    public Reference2Page(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Enter your Reference 2 Details")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public Reference2Page selectTitle(final String text) {
        new Select(titleSelection).selectByVisibleText(text);
        return this;
    }

    public Reference2Page name(final String text) {
        fullName.sendKeys(text);
        return this;
    }

    public String getNameErrorMessage() {
        return errorMessageForField(fullName);
    }

    public Reference2Page organisation(final String text) {
        organisationName.sendKeys(text);
        return this;
    }

    public String getOrganisationErrorMessage() {
        return errorMessageForField(organisationName);
    }

    public Reference2Page designation(final String text) {
        designation.sendKeys(text);
        return this;
    }

    public String getDesignationErrorMessage() {
        return errorMessageForField(designation);
    }

    public Reference2Page contactNumber(final String text) {
        contactNumber.sendKeys(text);
        return this;
    }

    public String getContactNumberErrorMessage() {
        return errorMessageForField(contactNumber);
    }

    public Reference2Page emailAddress(final String text) {
        emailAddress.sendKeys(text);
        return this;
    }

    public Reference2Page address(final String text) {
        address.sendKeys(text);
        return this;
    }

    public String getAddressErrorMessage() {
        return errorMessageForField(address);
    }

    public Reference2Page reset() {
        resetButton.click();
        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();

        return PageFactory.initElements(driver, CancelPage.class);
    }

    public SavePage save() {
        saveButton.click();

        return PageFactory.initElements(driver, SavePage.class);
    }

    public Reference1Page back() {
        backButton.click();

        return PageFactory.initElements(driver, Reference1Page.class);
    }

    public void next() {
        registerButton.click();

        // TODO where is this supposed to go to when it doesn't crash?
    }

    public Reference2Page nextExpectingError() {
        registerButton.click();

        return PageFactory.initElements(driver, Reference2Page.class);
    }

    private String errorMessageForField(final WebElement element) {
        return element.findElement(By.xpath("../..")).findElement(By.xpath("td[3]")).getText();
    }
}
