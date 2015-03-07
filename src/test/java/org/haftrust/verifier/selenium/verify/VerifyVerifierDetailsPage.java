package org.haftrust.verifier.selenium.verify;

import com.google.common.io.ByteStreams;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class VerifyVerifierDetailsPage {

    private final WebDriver driver;

    @FindBy(css = "select[name='verifierVerificationStatus']")
    private WebElement verificationStatusSelection;

    @FindBy(css = "textarea[name='verifierVerificationComment']")
    private WebElement verificationComment;

    @FindBy(css = "select[name='addressVerificationStatus']")
    private WebElement addressVerificationStatusSelection;

    @FindBy(css = "textarea[name='addressVerificationComment']")
    private WebElement addressVerificationComment;

    @FindBy(css = "img")
    private WebElement photoImage;

    @FindBy(css = "select[name='fileVerificationStatus']")
    private WebElement fileVerificationStatusSelection;

    @FindBy(css = "textarea[name='fileVerificationComment']")
    private WebElement fileVerificationComment;

    @FindBy(css = "select[name='identityDocumentVerificationStatus']")
    private WebElement identityDocumentVerificationStatusSelection;

    @FindBy(css = "textarea[name='identityDocumentVerificationComment']")
    private WebElement identityDocumentVerificationComment;

    @FindBy(css = "select[name='bankVerificationStatus']")
    private WebElement bankVerificationStatusSelection;

    @FindBy(css = "textarea[name='bankVerificationComment']")
    private WebElement bankVerificationComment;

    @FindBy(css = "select[name='reference1VerificationStatus']")
    private WebElement reference1VerificationStatusSelection;

    @FindBy(css = "textarea[name='reference1VerificationComment']")
    private WebElement reference1VerificationComment;

    @FindBy(css = "select[name='reference2VerificationStatus']")
    private WebElement reference2VerificationStatusSelection;

    @FindBy(css = "textarea[name='reference2VerificationComment']")
    private WebElement reference2VerificationComment;

    @FindBy(css = "select[name='idFom']")
    private WebElement fieldOperativeManagerSelection;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "input[name='_target4']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target5']")
    private WebElement deleteButton;

    @FindBy(css = "input[name='_target2']")
    private WebElement backButton;

    @FindBy(css = "input[name='_finish']")
    private WebElement verifyButton;

    public VerifyVerifierDetailsPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("/verifyVerifier.htm")
                || !driver.getTitle().equals("HafTrust Verify Verifier Details Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public VerifyVerifierDetailsPage selectVerificationStatus(final String text) {
        new Select(verificationStatusSelection).selectByVisibleText(text);
        return this;
    }

    public VerifyVerifierDetailsPage verificationComment(final String text) {
        verificationComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage selectAddressVerificationStatus(final String text) {
        new Select(addressVerificationStatusSelection).selectByVisibleText(text);
        return this;
    }

    public VerifyVerifierDetailsPage addressVerificationComment(final String text) {
        addressVerificationComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage selectFileVerificationStatus(final String text) {
        new Select(fileVerificationStatusSelection).selectByVisibleText(text);
        return this;
    }

    public VerifyVerifierDetailsPage fileVerificationComment(final String text) {
        fileVerificationComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage selectIdentityDocumentVerificationStatus(final String text) {
        new Select(identityDocumentVerificationStatusSelection).selectByVisibleText(text);
        return this;
    }

    public VerifyVerifierDetailsPage identityDocumentVerificationComment(final String text) {
        identityDocumentVerificationComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage selectBankVerificationStatus(final String text) {
        new Select(bankVerificationStatusSelection).selectByVisibleText(text);
        return this;
    }

    public VerifyVerifierDetailsPage bankVerificationComment(final String text) {
        bankVerificationComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage selectReference1VerificationStatus(final String text) {
        new Select(reference1VerificationStatusSelection).selectByVisibleText(text);
        return this;
    }

    public VerifyVerifierDetailsPage reference1VerificationComment(final String text) {
        reference1VerificationComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage selectReference2VerificationStatus(final String text) {
        new Select(reference2VerificationStatusSelection).selectByVisibleText(text);
        return this;
    }

    public VerifyVerifierDetailsPage reference2VerificationComment(final String text) {
        reference2VerificationComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage selectFieldOperativeManager(final String text) {
        new Select(fieldOperativeManagerSelection).selectByVisibleText(text);
        return this;
    }

    public byte[] getPhoto() throws IOException {

        try (final CloseableHttpClient client = HttpClientBuilder.create().build()) {
            final CloseableHttpResponse image = client.execute(new HttpGet(photoImage.getAttribute("src")));

            assertThat(image.getStatusLine().getStatusCode(), allOf(greaterThanOrEqualTo(200), lessThan(300)));

            try (final InputStream content = image.getEntity().getContent()) {
                return ByteStreams.toByteArray(content);
            }
        }

    }

    public CancelPage cancel() {
        cancelButton.click();
        return PageFactory.initElements(driver, CancelPage.class);
    }

    public ConfirmDeletionPage delete() {
        deleteButton.click();
        return PageFactory.initElements(driver, ConfirmDeletionPage.class);
    }

    public SelectVerifierPage back() {
        backButton.click();
        return PageFactory.initElements(driver, SelectVerifierPage.class);
    }

    public VerificationSavedPage verifyExpectingSaved() {
        verifyButton.click();
        return PageFactory.initElements(driver, VerificationSavedPage.class);
    }

    public VerifierVerifiedPage verifyExpectingVerified() {
        verifyButton.click();
        return PageFactory.initElements(driver, VerifierVerifiedPage.class);
    }

}
