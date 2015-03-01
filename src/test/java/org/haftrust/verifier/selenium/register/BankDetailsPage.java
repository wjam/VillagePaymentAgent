package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankDetailsPage {

    private final WebDriver driver;

    @FindBy(css = "input[name='bankAccountNumber']")
    private WebElement accountNumber;

    @FindBy(css = "input[name='bankName']")
    private WebElement bankName;

    @FindBy(css = "input[name='bankContactNumber']")
    private WebElement bankContactNumber;

    @FindBy(css = "input[name='bankAddress']")
    private WebElement bankAddress;

    @FindBy(css = "input[name='bankSortCode']")
    private WebElement sortCode;

    @FindBy(css = "input[name='bankIban']")
    private WebElement iban;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "input[name='_target9']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target11']")
    private WebElement saveButton;

    @FindBy(css = "input[name='_target5']")
    private WebElement backButton;

    @FindBy(css = "input[name='_target7']")
    private WebElement nextButton;

    public BankDetailsPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Enter your Account Details")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public BankDetailsPage accountNumber(final String text) {
        accountNumber.sendKeys(text);
        return this;
    }

    public String getAccountNumberErrorMessage() {
        return errorMessageForField(accountNumber);
    }

    public BankDetailsPage bankName(final String text) {
        bankName.sendKeys(text);
        return this;
    }

    public String getBankNameErrorMessage() {
        return errorMessageForField(bankName);
    }

    public BankDetailsPage contactNumber(final String text) {
        bankContactNumber.sendKeys(text);
        return this;
    }

    public String getContactNumberErrorMessage() {
        return errorMessageForField(bankContactNumber);
    }

    public BankDetailsPage address(final String text) {
        bankAddress.sendKeys(text);
        return this;
    }

    public String getAddressErrorMessage() {
        return errorMessageForField(bankAddress);
    }

    public BankDetailsPage sortCode(final String text) {
        sortCode.sendKeys(text);
        return this;
    }

    public BankDetailsPage iban(final String text) {
        iban.sendKeys(text);
        return this;
    }

    public String getIBANErrorMessage() {
        return errorMessageForField(iban);
    }

    public BankDetailsPage reset() {
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

    public IdentityDocumentPage back() {
        backButton.click();

        return PageFactory.initElements(driver, IdentityDocumentPage.class);
    }

    public Reference1Page next() {
        nextButton.click();

        return PageFactory.initElements(driver, Reference1Page.class);
    }

    public BankDetailsPage nextExpectingError() {
        nextButton.click();

        return PageFactory.initElements(driver, BankDetailsPage.class);
    }

    private String errorMessageForField(final WebElement element) {
        return element.findElement(By.xpath("../..")).findElement(By.xpath("td[3]")).getText();
    }
}
