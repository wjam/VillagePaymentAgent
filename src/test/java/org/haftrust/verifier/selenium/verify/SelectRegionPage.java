package org.haftrust.verifier.selenium.verify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectRegionPage {

    private final WebDriver driver;

    @FindBy(css = "select[name='idRegion']")
    private WebElement regionSelection;

    @FindBy(css = "input[name='_target4']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target0']")
    private WebElement backButton;

    @FindBy(css = "input[name='_target2']")
    private WebElement searchButton;

    public SelectRegionPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("/verifyVerifier.htm")
                || !driver.getTitle().equals("HafTrust Verify Verifier Select Region Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public SelectRegionPage selectRegion(final String text) {
        new Select(regionSelection).selectByVisibleText(text);
        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();
        return PageFactory.initElements(driver, CancelPage.class);
    }

    public SelectCountryPage back() {
        cancelButton.click();
        return PageFactory.initElements(driver, SelectCountryPage.class);
    }

    public NoVerifiersPage searchExpectingNoResults() {
        searchButton.click();
        return PageFactory.initElements(driver, NoVerifiersPage.class);
    }

    public SelectVerifierPage search() {
        searchButton.click();
        return PageFactory.initElements(driver, SelectVerifierPage.class);
    }

}
