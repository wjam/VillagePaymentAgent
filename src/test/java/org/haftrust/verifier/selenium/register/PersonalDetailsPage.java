package org.haftrust.verifier.selenium.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonalDetailsPage {

    private final WebDriver driver;

    @FindBy(css = "input[name='firstName']")
    private WebElement firstName;

    @FindBy(css = "input[name='middleName']")
    private WebElement middleName;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastName;

    @FindBy(css = "input[name='telephoneNumber']")
    private WebElement telephoneNumber;

    @FindBy(css = "input[name='gender']")
    private WebElement genderSelection;

    @FindBy(css = "input[name='dob']")
    private WebElement dateOfBirth;

    @FindBy(css = "select[name='educationLevel']")
    private WebElement educationLevelSelection;

    @FindBy(css = "select[name='educationType']")
    private WebElement educationTypeSelection;

    @FindBy(css = "input[name='street']")
    private WebElement street;

    @FindBy(css = "input[name='village']")
    private WebElement village;

    @FindBy(css = "input[name='postcode']")
    private WebElement postCode;

    @FindBy(css = "input[name='town']")
    private WebElement town;

    @FindBy(css = "input[name='city']")
    private WebElement city;

    @FindBy(css = "input[name='file']")
    private WebElement photo;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "input[name='_cancel']")
    private WebElement cancelButton;

    @FindBy(css = "input[name='_target11']")
    private WebElement saveButton;

    @FindBy(css = "input[name='_target3']")
    private WebElement backButton;

    @FindBy(css = "input[name='_target5']")
    private WebElement nextButton;

    public PersonalDetailsPage(final WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().endsWith("registerVerifier.htm")
                || !driver.findElement(By.cssSelector("body p")).getText().equals("Input your Personal Details")) {
            throw new IllegalStateException("Incorrect page " + driver.getCurrentUrl());
        }
    }

    public PersonalDetailsPage firstName(final String name) {
        firstName.sendKeys(name);
        return this;
    }

    public String getFirstNameErrorMessage() {
        return errorMessageForField(firstName);
    }

    public PersonalDetailsPage middleName(final String name) {
        middleName.sendKeys(name);
        return this;
    }

    public PersonalDetailsPage lastName(final String name) {
        lastName.sendKeys(name);
        return this;
    }

    public String getLastNameErrorMessage() {
        return errorMessageForField(lastName);
    }

    public PersonalDetailsPage telephoneNumber(final String number) {
        telephoneNumber.sendKeys(number);
        return this;
    }

    public String getTelephoneNumberErrorMessage() {
        return errorMessageForField(telephoneNumber);
    }

    public PersonalDetailsPage selectGender(final String gender) {
        new Select(genderSelection).selectByVisibleText(gender);
        return this;
    }

    public PersonalDetailsPage dateOfBirth(final LocalDate dob) {
        dateOfBirth.sendKeys(dob.format(DateTimeFormatter.ofPattern("d-M-yyyy")));
        return this;
    }

    public String getDateOfBirthErrorMessage() {
        return errorMessageForField(dateOfBirth);
    }

    public PersonalDetailsPage educationLevel(final String level) {
        new Select(educationLevelSelection).selectByVisibleText(level);
        return this;
    }

    public PersonalDetailsPage educationType(final String type) {
        new Select(educationTypeSelection).selectByVisibleText(type);
        return this;
    }

    public PersonalDetailsPage street(final String text) {
        street.sendKeys(text);
        return this;
    }

    public PersonalDetailsPage village(final String text) {
        village.sendKeys(text);
        return this;
    }

    public PersonalDetailsPage postCode(final String text) {
        postCode.sendKeys(text);
        return this;
    }

    public String getPostCodeErrorMessage() {
        return errorMessageForField(postCode);
    }

    public PersonalDetailsPage town(final String text) {
        town.sendKeys(text);
        return this;
    }

    public PersonalDetailsPage city(final String text) {
        city.sendKeys(text);
        return this;
    }

    public PersonalDetailsPage photo(final String text) {
        photo.sendKeys(text);
        return this;
    }

    public String getPhotoErrorMessage() {
        return errorMessageForField(photo);
    }

    public PersonalDetailsPage reset() {
        resetButton.click();
        return this;
    }

    public CancelPage cancel() {
        cancelButton.click();

        return PageFactory.initElements(driver, CancelPage.class);
    }

    public SavePage save() {
        saveButton.click();

        return PageFactory.initElements(driver, SavePage.class);
    }

    public DistrictSelectionPage back() {
        backButton.click();

        return PageFactory.initElements(driver, DistrictSelectionPage.class);
    }

    public IdentityDocumentPage next() {
        nextButton.click();

        return PageFactory.initElements(driver, IdentityDocumentPage.class);
    }

    public PersonalDetailsPage nextExpectingError() {
        nextButton.click();

        return PageFactory.initElements(driver, PersonalDetailsPage.class);
    }

    private String errorMessageForField(final WebElement element) {
        return element.findElement(By.xpath("../..")).findElement(By.xpath("td[3]")).getText();
    }

}
