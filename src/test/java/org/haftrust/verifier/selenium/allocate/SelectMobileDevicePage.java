package org.haftrust.verifier.selenium.allocate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectMobileDevicePage {

    private final WebDriver driver;

    @FindBy(id = "imei")
    private WebElement deviceSelection;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "input[name='_target2']")
    private WebElement backButton;

    @FindBy(css = "input[name='_target4']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_finish']")
    private WebElement allocateButton;


    public SelectMobileDevicePage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("/allocateDevice.htm")
                || !driver.getTitle().equals("HafTrust Allocate Mobile Device - Select Mobile Device Page")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public SelectMobileDevicePage selectMobile(final String mobile) {
        new Select(deviceSelection).selectByVisibleText(mobile);

        return this;
    }

    public SelectMobileDevicePage reset() {
        resetButton.click();
        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();
        return PageFactory.initElements(driver, CancelPage.class);
    }

    public SelectVerifierPage back() {
        cancelButton.click();
        return PageFactory.initElements(driver, SelectVerifierPage.class);
    }

    public DeviceAllocatedPage allocate() {
        allocateButton.click();
        return PageFactory.initElements(driver, DeviceAllocatedPage.class);
    }

}
