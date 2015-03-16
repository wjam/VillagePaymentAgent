package org.haftrust.verifier;

import org.haftrust.verifier.selenium.HomePage;
import org.haftrust.verifier.selenium.SeleniumUtilities;
import org.haftrust.verifier.selenium.verify.SelectRegionPage;
import org.haftrust.verifier.selenium.verify.SelectVerifierPage;
import org.haftrust.verifier.selenium.verify.VerifyVerifierDetailsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

@Category(Integration.class)
public class VerifyVerifierIntegrationTest {

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
    public void shouldShowNoVerifierPageIfNoVerifiersFound() throws Exception {
        HomePage.navigateTo(driver).goToVerifyVerifier().selectCountry("Tanzania").next().selectRegion("Blue").searchExpectingNoResults();
    }

    @Test
    public void shouldRemoveVerifierWhenDeletingVerifier() throws Exception {
        final String firstName = randomAlphanumeric(20);
        final String lastName = randomAlphanumeric(20);
        final LocalDate dateOfBirth = LocalDate.now().minusYears(25);

        SeleniumUtilities.registerVerifier(driver, firstName, lastName, dateOfBirth, SeleniumUtilities.photo());
        final String verifierText = SeleniumUtilities.toVerifierText(firstName, lastName, dateOfBirth);

        final SelectVerifierPage selectVerifierPage = HomePage.navigateTo(driver).goToVerifyVerifier()
                .selectCountry("Uganda").next().selectRegion("Central").search();

        final boolean expectVerifiers = selectVerifierPage.verifiers().size() > 1;

        selectVerifierPage.selectVerifier(verifierText).next()
                .delete()
                .delete();

        final SelectRegionPage regionPage = HomePage.navigateTo(driver).goToVerifyVerifier()
                .selectCountry("Uganda").next().selectRegion("Central");

        if (expectVerifiers) {
            assertThat(regionPage.search().verifiers(), not(hasItem(verifierText)));
        } else {
            regionPage.searchExpectingNoResults();
        }
    }

    @Test
    public void shouldSaveVerifierWhenPartialDetailsAreFilledOut() throws Exception {

        final String firstName = randomAlphanumeric(20);
        final String lastName = randomAlphanumeric(20);
        final LocalDate dateOfBirth = LocalDate.now().minusYears(25);

        SeleniumUtilities.registerVerifier(driver, firstName, lastName, dateOfBirth, SeleniumUtilities.photo());

        final VerifyVerifierDetailsPage detailsPage = HomePage.navigateTo(driver).goToVerifyVerifier()
                .selectCountry("Uganda").next().selectRegion("Central").search()
                .selectVerifier(SeleniumUtilities.toVerifierText(firstName, lastName, dateOfBirth)).next();

        assertArrayEquals(SeleniumUtilities.photoAsBytes(), detailsPage.getPhoto());

        detailsPage.selectBankVerificationStatus("Verified").selectFileVerificationStatus("Verified")
                .selectIdentityDocumentVerificationStatus("Verified").selectReference1VerificationStatus("Verified").selectReference2VerificationStatus("Verified")
                .selectVerificationStatus("Verified").verifyExpectingSaved();
    }

    @Test
    public void shouldVerifyVerifierWithFullDetails() throws Exception {
        final String firstName = randomAlphanumeric(20);
        final String lastName = randomAlphanumeric(20);
        final LocalDate dateOfBirth = LocalDate.now().minusYears(25);

        SeleniumUtilities.registerVerifier(driver, firstName, lastName, dateOfBirth, SeleniumUtilities.photo());

        final VerifyVerifierDetailsPage detailsPage = HomePage.navigateTo(driver).goToVerifyVerifier()
                .selectCountry("Uganda").next().selectRegion("Central").search()
                .selectVerifier(SeleniumUtilities.toVerifierText(firstName, lastName, dateOfBirth)).next();

        assertArrayEquals(SeleniumUtilities.photoAsBytes(), detailsPage.getPhoto());

        detailsPage.selectAddressVerificationStatus("Verified").selectBankVerificationStatus("Verified").selectFileVerificationStatus("Verified")
                .selectIdentityDocumentVerificationStatus("Verified").selectReference1VerificationStatus("Verified").selectReference2VerificationStatus("Verified")
                .selectVerificationStatus("Verified").verifyExpectingVerified();
    }

}
