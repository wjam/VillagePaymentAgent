package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegionSelectionPage {

    private final WebDriver driver;

    @FindBy(css = "select[name='idRegion']")
    private WebElement regionSelection;

    @FindBy(css = "input[name='_cancel']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target1']")
    private WebElement backButton;

    @FindBy(css = "input[name='_target3']")
    private WebElement nextButton;

    public RegionSelectionPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Select your Region")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public RegionSelectionPage selectRegion(final String region) {
        new Select(regionSelection).selectByVisibleText(region);

        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();

        return PageFactory.initElements(driver, CancelPage.class);
    }

    public CountrySelectionPage back() {
        backButton.click();

        return PageFactory.initElements(driver, CountrySelectionPage.class);
    }

    public DistrictSelectionPage next() {
        nextButton.click();

        return PageFactory.initElements(driver, DistrictSelectionPage.class);
    }
}
