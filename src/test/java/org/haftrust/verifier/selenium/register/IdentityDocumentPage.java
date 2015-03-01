package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IdentityDocumentPage {

    private final WebDriver driver;

    @FindBy(css = "select[name='identityDocumentType']")
    private WebElement documentTypeSelection;

    @FindBy(css = "input[name='identityDocumentNumber']")
    private WebElement documentNumber;

    @FindBy(css = "input[name='identityDocumentIssueDate']")
    private WebElement documentIssueDate;

    @FindBy(css = "input[name='identityDocumentExpiryDate']")
    private WebElement documentExpiryDate;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "input[name='_target9']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target11']")
    private WebElement saveButton;

    @FindBy(css = "input[name='_target4']")
    private WebElement backButton;

    @FindBy(css = "input[name='_target6']")
    private WebElement nextButton;

    public IdentityDocumentPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Enter your Identity Document Details")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public IdentityDocumentPage selectDocumentType(final String text) {
        new Select(documentTypeSelection).selectByVisibleText(text);

        return this;
    }

    public IdentityDocumentPage documentNumber(final String text) {
        documentNumber.sendKeys(text);
        return this;
    }

    public String getDocumentNumberErrorMessage() {
        return errorMessageForField(documentNumber);
    }

    public IdentityDocumentPage issueDate(final LocalDate date) {
        documentIssueDate.sendKeys(date.format(DateTimeFormatter.ofPattern("d-M-yyyy")));
        return this;
    }

    public String getIssueDateErrorMessage() {
        return errorMessageForField(documentIssueDate);
    }

    public IdentityDocumentPage expiryDate(final LocalDate date) {
        documentExpiryDate.sendKeys(date.format(DateTimeFormatter.ofPattern("d-M-yyyy")));
        return this;
    }

    public String getExpiryDateErrorMessage() {
        return errorMessageForField(documentExpiryDate);
    }

    public IdentityDocumentPage reset() {
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

    public PersonalDetailsPage back() {
        backButton.click();

        return PageFactory.initElements(driver, PersonalDetailsPage.class);
    }

    public BankDetailsPage next() {
        nextButton.click();

        return PageFactory.initElements(driver, BankDetailsPage.class);
    }

    public IdentityDocumentPage nextExpectingError() {
        nextButton.click();

        return PageFactory.initElements(driver, IdentityDocumentPage.class);
    }

    private String errorMessageForField(final WebElement element) {
        return element.findElement(By.xpath("../..")).findElement(By.xpath("td[3]")).getText();
    }

}
