package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DistrictSelectionPage {

    private final WebDriver driver;

    @FindBy(css = "select[name='idDistrict']")
    private WebElement districtSelection;

    @FindBy(css = "input[name='_cancel']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target2']")
    private WebElement backButton;

    @FindBy(css = "input[name='_target4']")
    private WebElement nextButton;

    public DistrictSelectionPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Select your District")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public DistrictSelectionPage selectDistrict(final String region) {
        new Select(districtSelection).selectByVisibleText(region);

        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();

        return PageFactory.initElements(driver, CancelPage.class);
    }

    public RegionSelectionPage back() {
        backButton.click();

        return PageFactory.initElements(driver, RegionSelectionPage.class);
    }

    public PersonalDetailsPage next() {
        nextButton.click();

        return PageFactory.initElements(driver, PersonalDetailsPage.class);
    }
}
