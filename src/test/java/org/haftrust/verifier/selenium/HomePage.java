package org.haftrust.verifier.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(linkText = "Pre-Register Verifier")
    private WebElement preRegisterVerifierLink;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
    }

    public VerifierPreRegistrationPage goToPreRegisterVerifier() {
        preRegisterVerifierLink.click();
        return PageFactory.initElements(driver, VerifierPreRegistrationPage.class);
    }

    public static HomePage navigateTo(final WebDriver driver) {
        driver.get("http://localhost:" + System.getProperty("jetty.port", "8080") + "/");
        return PageFactory.initElements(driver, HomePage.class);
    }

}
