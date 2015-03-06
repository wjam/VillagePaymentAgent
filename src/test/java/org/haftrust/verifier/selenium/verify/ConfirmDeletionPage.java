package org.haftrust.verifier.selenium.verify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmDeletionPage {

    private final WebDriver driver;

    @FindBy(css = "textarea[name='verifierVerificationComment']")
    private WebElement deletionComment;

    @FindBy(css = "input[name='_target3']")
    private WebElement backButton;

    @FindBy(css = "input[name='_finish']")
    private WebElement deleteButton;

    public ConfirmDeletionPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("/verifyVerifier.htm")
                || !driver.getTitle().equals("HafTrust Verify Verifier Delete Application Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public ConfirmDeletionPage comment(final String text) {
        deletionComment.sendKeys(text);
        return this;
    }

    public VerifyVerifierDetailsPage back() {
        backButton.click();
        return PageFactory.initElements(driver, VerifyVerifierDetailsPage.class);
    }

    public DeletionConfirmedPage delete() {
        deleteButton.click();
        return PageFactory.initElements(driver, DeletionConfirmedPage.class);
    }

}
