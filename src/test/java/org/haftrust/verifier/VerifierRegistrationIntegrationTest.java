package org.haftrust.verifier;

import org.haftrust.verifier.selenium.HomePage;
import org.haftrust.verifier.selenium.SeleniumUtilities;
import org.haftrust.verifier.selenium.register.BankDetailsPage;
import org.haftrust.verifier.selenium.register.IdentityDocumentPage;
import org.haftrust.verifier.selenium.register.LoginPage;
import org.haftrust.verifier.selenium.register.PersonalDetailsPage;
import org.haftrust.verifier.selenium.register.Reference1Page;
import org.haftrust.verifier.selenium.register.Reference2Page;
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
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertEquals;

@Category(Integration.class)
public class VerifierRegistrationIntegrationTest {

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
    public void shouldFailToLoginWithoutValidAccount() {

        final String emailAddress = SeleniumUtilities.email();
        final String password = randomAlphanumeric(20);

        final LoginPage page = HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submitExpectingError();

        assertEquals("The Email or Password entered is incorrect.", page.getEmailAddressErrorMessage());
    }

    @Test
    public void shouldRequireValidPersonalDetails() {

        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        preregisterVerifier(emailAddress, password);

        final PersonalDetailsPage page = HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .dateOfBirth(LocalDate.now().minusYears(2)).nextExpectingError();

        assertEquals("First Name is required.", page.getFirstNameErrorMessage());
        assertEquals("Last Name is required.", page.getLastNameErrorMessage());
        assertEquals("Telephone Number is required.", page.getTelephoneNumberErrorMessage());
        assertEquals("The Verifier has to be over 23 years old.", page.getDateOfBirthErrorMessage());
        assertEquals("Postcode is required.", page.getPostCodeErrorMessage());
        assertEquals("Photo is required.\nPhoto is required to be an image type.", page.getPhotoErrorMessage());
    }

    @Test
    public void shouldRequireValidIdentityDocumentDetails() throws Exception {

        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        preregisterVerifier(emailAddress, password);

        final IdentityDocumentPage page = HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .firstName(randomAlphanumeric(20)).lastName(randomAlphanumeric(20)).telephoneNumber(randomNumeric(10)).postCode(randomAlphanumeric(10))
                .photo(SeleniumUtilities.photo()).dateOfBirth(LocalDate.now().minusYears(23)).next()
                .issueDate(LocalDate.now().plusDays(1)).expiryDate(LocalDate.now().plusDays(1)).selectDocumentType("Passport").nextExpectingError();

        assertEquals("Number is required.", page.getDocumentNumberErrorMessage());
        assertEquals("The Issue Date has to be before the current date.", page.getIssueDateErrorMessage());
        assertEquals("The Expiry Date has to be at least one year after the Issue Date.", page.getExpiryDateErrorMessage());
    }

    @Test
    public void shouldRequireValidBankDetails() throws Exception {

        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        preregisterVerifier(emailAddress, password);

        final BankDetailsPage page = HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .firstName(randomAlphanumeric(20)).lastName(randomAlphanumeric(20)).telephoneNumber(randomNumeric(10)).postCode(randomAlphanumeric(10))
                .photo(SeleniumUtilities.photo()).dateOfBirth(LocalDate.now().minusYears(23)).next()
                .issueDate(LocalDate.now().minusDays(1)).expiryDate(LocalDate.now().plusYears(1)).selectDocumentType("Passport")
                .documentNumber(randomAlphanumeric(20)).next().nextExpectingError();

        assertEquals("Account Number is required.", page.getAccountNumberErrorMessage());
        assertEquals("Bank Name is required.", page.getBankNameErrorMessage());
        assertEquals("Telephone is required.", page.getContactNumberErrorMessage());
        assertEquals("Bank Address is required.", page.getAddressErrorMessage());
        assertEquals("Bank IBAN is required.", page.getIBANErrorMessage());
    }

    @Test
    public void shouldRequireValidFirstReferenceDetails() throws Exception {

        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        preregisterVerifier(emailAddress, password);

        final Reference1Page page = HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .firstName(randomAlphanumeric(20)).lastName(randomAlphanumeric(20)).telephoneNumber(randomNumeric(10)).postCode(randomAlphanumeric(10))
                .photo(SeleniumUtilities.photo()).dateOfBirth(LocalDate.now().minusYears(23)).next()
                .issueDate(LocalDate.now().minusDays(1)).expiryDate(LocalDate.now().plusYears(1)).selectDocumentType("Passport")
                .documentNumber(randomAlphanumeric(20)).next()
                .accountNumber(randomNumeric(10)).bankName(randomAlphanumeric(20)).contactNumber(randomAlphanumeric(20))
                .address(randomAlphanumeric(20)).iban(randomAlphanumeric(20)).next().nextExpectingError();

        assertEquals("Full Name is required.", page.getNameErrorMessage());
        assertEquals("Organisation Name is required.", page.getOrganisationErrorMessage());
        assertEquals("Designation is required.", page.getDesignationErrorMessage());
        assertEquals("Contact Number is required.", page.getContactNumberErrorMessage());
        assertEquals("Address is required.", page.getAddressErrorMessage());
    }

    @Test
    public void shouldRequireValidSecondReferenceDetails() throws Exception {

        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        preregisterVerifier(emailAddress, password);

        final Reference2Page page = HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .firstName(randomAlphanumeric(20)).lastName(randomAlphanumeric(20)).telephoneNumber(randomNumeric(10)).postCode(randomAlphanumeric(10))
                .photo(SeleniumUtilities.photo()).dateOfBirth(LocalDate.now().minusYears(23)).next()
                .issueDate(LocalDate.now().minusDays(1)).expiryDate(LocalDate.now().plusYears(1)).selectDocumentType("Passport")
                .documentNumber(randomAlphanumeric(20)).next()
                .accountNumber(randomNumeric(10)).bankName(randomAlphanumeric(20)).contactNumber(randomAlphanumeric(20))
                .address(randomAlphanumeric(20)).iban(randomAlphanumeric(20)).next()
                .name(randomAlphanumeric(20)).organisation(randomAlphanumeric(20)).designation(randomAlphanumeric(20))
                .contactNumber(randomAlphanumeric(20)).emailAddress(SeleniumUtilities.email()).address(randomAlphanumeric(20)).next()
                .nextExpectingError();

        assertEquals("Full Name is required.", page.getNameErrorMessage());
        assertEquals("Organisation Name is required.", page.getOrganisationErrorMessage());
        assertEquals("Designation is required.", page.getDesignationErrorMessage());
        assertEquals("Contact Number is required.", page.getContactNumberErrorMessage());
        assertEquals("Address is required.", page.getAddressErrorMessage());
    }

    @Test
    public void shouldSuccessfullyRegisterVerifier() throws Exception {

        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        preregisterVerifier(emailAddress, password);

        HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .firstName(randomAlphanumeric(20)).lastName(randomAlphanumeric(20)).telephoneNumber(randomNumeric(10)).postCode(randomAlphanumeric(10))
                .photo(SeleniumUtilities.photo()).dateOfBirth(LocalDate.now().minusYears(23)).next()
                .issueDate(LocalDate.now().minusDays(1)).expiryDate(LocalDate.now().plusYears(1)).selectDocumentType("Passport")
                .documentNumber(randomAlphanumeric(20)).next()
                .accountNumber(randomNumeric(10)).bankName(randomAlphanumeric(20)).contactNumber(randomAlphanumeric(20))
                .address(randomAlphanumeric(20)).iban(randomAlphanumeric(20)).next()
                .name(randomAlphanumeric(20)).organisation(randomAlphanumeric(20)).designation(randomAlphanumeric(20))
                .contactNumber(randomAlphanumeric(20)).emailAddress(SeleniumUtilities.email()).address(randomAlphanumeric(20)).next()
                .name(randomAlphanumeric(20)).organisation(randomAlphanumeric(20)).designation(randomAlphanumeric(20))
                .contactNumber(randomAlphanumeric(20)).emailAddress(SeleniumUtilities.email()).address(randomAlphanumeric(20)).next();
    }

    @Test
    public void shouldSuccessfullyRegisterVerifierWhenSavingPartWayThroughThenCompleting() throws Exception {

        final String emailAddress = SeleniumUtilities.email();
        final String password = SeleniumUtilities.password();

        preregisterVerifier(emailAddress, password);

        HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .firstName(randomAlphanumeric(20)).lastName(randomAlphanumeric(20)).telephoneNumber(randomNumeric(10)).postCode(randomAlphanumeric(10))
                .photo(SeleniumUtilities.photo()).dateOfBirth(LocalDate.now().minusYears(23)).save().yes();

        HomePage.navigateTo(driver).goToRegisterVerifier().enterEmail(emailAddress).enterPassword(password).submit()
                .selectCountry("Uganda").next()
                .selectRegion("Central").next()
                .selectDistrict("Greenwich").next()
                .photo(SeleniumUtilities.photo()).next()
                .issueDate(LocalDate.now().minusDays(1)).expiryDate(LocalDate.now().plusYears(1)).selectDocumentType("Passport")
                .documentNumber(randomAlphanumeric(20)).next()
                .accountNumber(randomNumeric(10)).bankName(randomAlphanumeric(20)).contactNumber(randomAlphanumeric(20))
                .address(randomAlphanumeric(20)).iban(randomAlphanumeric(20)).next()
                .name(randomAlphanumeric(20)).organisation(randomAlphanumeric(20)).designation(randomAlphanumeric(20))
                .contactNumber(randomAlphanumeric(20)).emailAddress(SeleniumUtilities.email()).address(randomAlphanumeric(20)).next()
                .name(randomAlphanumeric(20)).organisation(randomAlphanumeric(20)).designation(randomAlphanumeric(20))
                .contactNumber(randomAlphanumeric(20)).emailAddress(SeleniumUtilities.email()).address(randomAlphanumeric(20)).next();
    }

    private void preregisterVerifier(final String emailAddress, final String password) {
        HomePage.navigateTo(driver).goToPreRegisterVerifier().enterEmail(emailAddress).enterPassword(password).renterPassword(password).submit();
    }

}
