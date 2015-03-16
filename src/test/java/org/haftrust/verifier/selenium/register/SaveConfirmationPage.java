package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveConfirmationPage {

    public SaveConfirmationPage(WebDriver driver) {
        String errMsg = null;
        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm"))
            errMsg = "Current URL does not end with 'registerVerifier.htm'";

        String resultText = driver.findElement(By.cssSelector("body p")).getText();
        if (!resultText.equals("Verifier Candidate details have been saved successfully"))
            errMsg = String.format("'body p' text is '%s'", resultText);

        if (errMsg != null)
            throw new IllegalStateException(String.format("Incorrect page: %s: %s", errMsg, driver.getCurrentUrl()));
    }
}
