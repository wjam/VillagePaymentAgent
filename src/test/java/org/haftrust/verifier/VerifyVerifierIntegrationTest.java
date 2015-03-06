package org.haftrust.verifier;

import org.haftrust.verifier.selenium.HomePage;
import org.haftrust.verifier.selenium.SeleniumUtilities;
import org.haftrust.verifier.selenium.verify.SelectRegionPage;
import org.haftrust.verifier.selenium.verify.SelectVerifierPage;
import org.haftrust.verifier.selenium.verify.VerifyVerifierDetailsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

        registerVerifier(firstName, lastName, dateOfBirth, SeleniumUtilities.photo());
        final String verifierText = toVerifierText(firstName, lastName, dateOfBirth);

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

        registerVerifier(firstName, lastName, dateOfBirth, SeleniumUtilities.photo());

        final VerifyVerifierDetailsPage detailsPage = HomePage.navigateTo(driver).goToVerifyVerifier()
                .selectCountry("Uganda").next().selectRegion("Central").search()
                .selectVerifier(toVerifierText(firstName, lastName, dateOfBirth)).next();

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

        registerVerifier(firstName, lastName, dateOfBirth, SeleniumUtilities.photo());

        final VerifyVerifierDetailsPage detailsPage = HomePage.navigateTo(driver).goToVerifyVerifier()
                .selectCountry("Uganda").next().selectRegion("Central").search()
                .selectVerifier(toVerifierText(firstName, lastName, dateOfBirth)).next();

        assertArrayEquals(SeleniumUtilities.photoAsBytes(), detailsPage.getPhoto());

        detailsPage.selectAddressVerificationStatus("Verified").selectBankVerificationStatus("Verified").selectFileVerificationStatus("Verified")
                .selectIdentityDocumentVerificationStatus("Verified").selectReference1VerificationStatus("Verified").selectReference2VerificationStatus("Verified")
                .selectVerificationStatus("Verified").verifyExpectingVerified();
    }

    private String toVerifierText(final String firstName, final String lastName, final LocalDate dateOfBirth) {
        return firstName + " " + lastName + " " + dateOfBirth.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
    }

    private void registerVerifier(final String firstName, final String lastName, final LocalDate dateOfBirth, final String photoFile) {
        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        HomePage.navigateTo(driver).goToPreRegisterVerifier().enterEmail(emailAddress).enterPassword(password).renterPassword(password).submit();

        HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .firstName(firstName).lastName(lastName).telephoneNumber(randomNumeric(10)).postCode(randomAlphanumeric(10))
                .photo(photoFile).dateOfBirth(dateOfBirth).next()
                .issueDate(LocalDate.now().minusDays(1)).expiryDate(LocalDate.now().plusYears(1)).selectDocumentType("Passport")
                .documentNumber(randomAlphanumeric(20)).next()
                .accountNumber(randomNumeric(10)).bankName(randomAlphanumeric(20)).contactNumber(randomAlphanumeric(20))
                .address(randomAlphanumeric(20)).iban(randomAlphanumeric(20)).next()
                .name(randomAlphanumeric(20)).organisation(randomAlphanumeric(20)).designation(randomAlphanumeric(20))
                .contactNumber(randomAlphanumeric(20)).emailAddress(SeleniumUtilities.email()).address(randomAlphanumeric(20)).next()
                .name(randomAlphanumeric(20)).organisation(randomAlphanumeric(20)).designation(randomAlphanumeric(20))
                .contactNumber(randomAlphanumeric(20)).emailAddress(SeleniumUtilities.email()).address(randomAlphanumeric(20)).next();
    }

}
