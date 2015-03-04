package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavePage {

    private final WebDriver driver;

    @FindBy(css = "input[name='_target4']")
    private WebElement noButton;

    @FindBy(css = "input[name='_target8']")
    private WebElement yesButton;

    public SavePage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Are you sure?")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public SaveConfirmationPage yes() {
        yesButton.click();

        return PageFactory.initElements(driver, SaveConfirmationPage.class);
    }

    public void no() {
        // TODO this will go back to the page you were just on
        noButton.click();
    }
}
