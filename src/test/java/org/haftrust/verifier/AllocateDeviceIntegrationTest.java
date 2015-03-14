package org.haftrust.verifier;

import org.haftrust.verifier.selenium.HomePage;
import org.haftrust.verifier.selenium.SeleniumUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

@Category(Integration.class)
public class AllocateDeviceIntegrationTest {

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
    public void shouldAllocateDeviceToVerifier() throws Exception {

        final String firstName = randomAlphanumeric(20);
        final String lastName = randomAlphanumeric(20);
        final LocalDate dateOfBirth = LocalDate.now().minusYears(25);

        registerVerifier(firstName, lastName, dateOfBirth);

        HomePage.navigateTo(driver).goToAllocateMobile()
                .selectCountry("Uganda").next().back().selectCountry("Uganda").next()
                .selectRegion("Central").search()
                .selectVerifier(SeleniumUtilities.toVerifierText(firstName, lastName, dateOfBirth)).next()
                .selectMobile("333").allocate();
    }

    @Test
    public void shouldDisplayNoResultsPageWhenNoVerifiers() {
        HomePage.navigateTo(driver).goToAllocateMobile().selectCountry("Tanzania").next().selectRegion("Blue").searchExpectingNoResults();
    }

    private void registerVerifier(final String firstName, final String lastName, final LocalDate dateOfBirth) throws IOException {
        SeleniumUtilities.registerVerifier(driver, firstName, lastName, dateOfBirth, SeleniumUtilities.photo());

        HomePage.navigateTo(driver).goToVerifyVerifier()
                .selectCountry("Uganda").next()
                .selectRegion("Central").search()
                .selectVerifier(SeleniumUtilities.toVerifierText(firstName, lastName, dateOfBirth)).next()
                .selectAddressVerificationStatus("Verified").selectBankVerificationStatus("Verified").selectFileVerificationStatus("Verified")
                .selectIdentityDocumentVerificationStatus("Verified").selectReference1VerificationStatus("Verified").selectReference2VerificationStatus("Verified")
                .selectVerificationStatus("Verified").verifyExpectingVerified();
    }
}
