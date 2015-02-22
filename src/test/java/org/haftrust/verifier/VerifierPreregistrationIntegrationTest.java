package org.haftrust.verifier;

import org.haftrust.verifier.selenium.HomePage;
import org.haftrust.verifier.selenium.VerifierPreRegistrationConfirmationPage;
import org.haftrust.verifier.selenium.VerifierPreRegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Category(Integration.class)
public class VerifierPreregistrationIntegrationTest {

    @Rule
    public final TestRule methodNameLogger = new MethodNameLoggingRule();

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void shouldRegisterVerifierWhenDetailsAreCorrect() {
        final String emailAddress = randomAlphanumeric(20) + "@" + randomAlphanumeric(20) + ".com";
        final String password = "1a" + randomAlphanumeric(18);

        final VerifierPreRegistrationConfirmationPage page = HomePage.navigateTo(driver).goToPreRegisterVerifier()
                .enterEmail(emailAddress).enterPassword(password).renterPassword(password)
                .submit();

        assertEquals(emailAddress, page.getDisplayedEmailAddress());
        assertNotNull(page.getDisplayedId());
    }

    @Test
    public void shouldNotRegisterVerifierDetailsWhenPasswordDoesNotMatch() {
        final String emailAddress = randomAlphanumeric(20) + "@" + randomAlphanumeric(20) + ".com";
        final String password = "1a" + randomAlphanumeric(18);
        final String reenteredPassword = "2a" + randomAlphanumeric(18);

        final VerifierPreRegistrationPage page = HomePage.navigateTo(driver).goToPreRegisterVerifier()
                .enterEmail(emailAddress).enterPassword(password).renterPassword(reenteredPassword)
                .submitExpectingFailure();

        assertEquals("Re-Password is required to match Password.", page.getReenteredPasswordErrorMessage());
    }

    @Test
    public void shouldNotRegisterVerifierDetailsWhenAlreadyRegistered() {

        final String emailAddress = randomAlphanumeric(20) + "@" + randomAlphanumeric(20) + ".com";
        final String password = "1a" + randomAlphanumeric(18);

        HomePage.navigateTo(driver).goToPreRegisterVerifier().enterEmail(emailAddress).enterPassword(password).renterPassword(password).submit();

        final VerifierPreRegistrationPage page = HomePage.navigateTo(driver).goToPreRegisterVerifier()
                .enterEmail(emailAddress).enterPassword(password).renterPassword(password)
                .submitExpectingFailure();

        assertEquals("Email already in use.", page.getEmailAddressErrorMessage());
    }

}
