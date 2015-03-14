package org.haftrust.verifier.selenium.allocate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectCountryPage {

    private final WebDriver driver;

    @FindBy(css = "select[name='idCountry']")
    private WebElement countrySelection;

    @FindBy(css = "input[name='_target4']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target1']")
    private WebElement nextButton;

    public SelectCountryPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("/allocateDevice.htm")
                || !driver.getTitle().equals("HafTrust Allocate Mobile Device - Select Country Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public SelectCountryPage selectCountry(final String text) {
        new Select(countrySelection).selectByVisibleText(text);
        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();
        return PageFactory.initElements(driver, CancelPage.class);
    }

    public SelectRegionPage next() {
        nextButton.click();
        return PageFactory.initElements(driver, SelectRegionPage.class);
    }

}
