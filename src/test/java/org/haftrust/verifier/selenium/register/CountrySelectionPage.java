package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CountrySelectionPage {

    private final WebDriver driver;

    @FindBy(css = "select[name='idCountry']")
    private WebElement countrySelection;

    @FindBy(css = "input[name='_cancel']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target2']")
    private WebElement nextButton;

    public CountrySelectionPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Select your Country")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public CountrySelectionPage selectCountry(final String country) {
        new Select(countrySelection).selectByVisibleText(country);

        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();

        return PageFactory.initElements(driver, CancelPage.class);
    }

    public RegionSelectionPage next() {
        nextButton.click();

        return PageFactory.initElements(driver, RegionSelectionPage.class);
    }
}
