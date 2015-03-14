package org.haftrust.verifier.selenium;

import com.google.common.io.ByteStreams;
import org.openqa.selenium.WebDriver;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public final class SeleniumUtilities {

    private SeleniumUtilities() {
        super();
    }

    public static String password() {
        return "1a" + randomAlphanumeric(18);
    }

    public static String email() {
        return randomAlphanumeric(20) + "@" + randomAlphanumeric(20) + ".com";
    }

    public static String photo() throws IOException {
        return getPhotoResource().getFile().getAbsolutePath();
    }

    public static byte[] photoAsBytes() throws IOException {
        return ByteStreams.toByteArray(getPhotoResource().getInputStream());
    }

    public static String toVerifierText(final String firstName, final String lastName, final LocalDate dateOfBirth) {
        return firstName + " " + lastName + " " + dateOfBirth.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
    }

    public static void registerVerifier(final WebDriver driver, final String firstName, final String lastName, final LocalDate dateOfBirth, final String photoFile) {

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

    private static Resource getPhotoResource() {
        return new DefaultResourceLoader().getResource("/120px-PNG_transparency_demonstration_1.png");
    }
}
