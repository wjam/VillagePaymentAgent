package org.haftrust.verifier.validator;

import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.PreRegisterVerifierBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author mgrindei
 */
public class PreRegisterVerifierValidatorTest {
    private static final String VALID_EMAIL = "john@yahoo.com";
    private static final String VALID_PASSWORD = "password1";
    private static final String EMAIL_TOO_SHORT = "a@b.c";
    private static final String EMAIL_TOO_LONG = "stefaniahelenacristinaluisajuananorma@yahoo.co.uk";
    private static final String EMAIL_WITHOUT_DOT = "john@yahoocom";
    private static final String EMAIL_WITHOUT_AT = "johnyahoo.com";
    private static final String PASSWORD_TOO_SHORT = "pass1";
    private static final String PASSWORD_TOO_LONG = "oneverylongpassword11";
    private static final String PASSWORD_WITHOUT_DIGITS = "password";
    private static final String NOT_MATCHING_REPASSWORD = "repassword";

    private PreRegisterVerifierBean bean;
    private Errors errors;
    private PreRegisterVerifierValidator classToTest;
    private VerifierService verifierServiceMock;

    @Before
    public void setup() {
        bean = createValidPreRegisterVerifier();
        errors = new BeanPropertyBindingResult(bean, "registerVerifierBean");
        classToTest = new PreRegisterVerifierValidator();
        verifierServiceMock = mock(VerifierService.class);
    }

    private PreRegisterVerifierBean createValidPreRegisterVerifier() {
        PreRegisterVerifierBean preRegisterVerifierBean = new PreRegisterVerifierBean();
        preRegisterVerifierBean.setEmail(VALID_EMAIL);
        preRegisterVerifierBean.setPassword(VALID_PASSWORD);
        preRegisterVerifierBean.setRepassword(VALID_PASSWORD);
        return preRegisterVerifierBean;
    }

    @Test(expected = Exception.class)
    public void givenNullEmail_whenValidate_thenInvalidObject() {
        bean.setEmail(null);
        try {
            classToTest.validate(bean, errors);
            fail("Exception should have been thrown!");
        } catch (Exception e) {
            assertEquals(1, errors.getErrorCount());
            assertEquals("email", errors.getFieldError().getField());
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void givenNullPassword_whenValidate_thenInvalidObject() {
        bean.setPassword(null);
        try {
            classToTest.validate(bean, errors);
            fail("Exception should have been thrown!");
        } catch (Exception e) {
            assertEquals(1, errors.getErrorCount());
            assertEquals("password", errors.getFieldError().getField());
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void givenNullRepassword_whenValidate_thenInvalidObject() {
        bean.setRepassword(null);
        try {
            classToTest.validate(bean, errors);
            fail("Exception should have been thrown!");
        } catch (Exception e) {
            assertEquals(1, errors.getErrorCount());
            assertEquals("repassword", errors.getFieldError().getField());
            throw e;
        }
    }

    @Test
    public void givenEmailTooShort_whenValidate_thenInvalidObject(){
        bean.setEmail(EMAIL_TOO_SHORT);
        when(verifierServiceMock.checkEmail(EMAIL_TOO_SHORT)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("email", "at least 6 characters long");
    }

    @Test
    public void givenEmailTooLong_whenValidate_thenInvalidObject(){
        bean.setEmail(EMAIL_TOO_LONG);
        when(verifierServiceMock.checkEmail(EMAIL_TOO_LONG)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("email", "up to 45 characters long");
    }

    @Test
    public void givenEmailWithoutDot_whenValidate_thenInvalidObject(){
        bean.setEmail(EMAIL_WITHOUT_DOT);
        when(verifierServiceMock.checkEmail(EMAIL_WITHOUT_DOT)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("email", "required '.'");
    }

    @Test
    public void givenEmailWithoutAt_whenValidate_thenInvalidObject(){
        bean.setEmail(EMAIL_WITHOUT_AT);
        when(verifierServiceMock.checkEmail(EMAIL_WITHOUT_AT)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("email", "required '@'");
    }

    @Test
    public void givenEmailInUse_whenValidate_thenInvalidObject(){
        when(verifierServiceMock.checkEmail(VALID_EMAIL)).thenReturn(true);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("email", "Email already in use");
    }

    @Test
    public void givenPasswordTooShort_whenValidate_thenInvalidObject(){
        bean.setPassword(PASSWORD_TOO_SHORT);
        bean.setRepassword(PASSWORD_TOO_SHORT);
        when(verifierServiceMock.checkEmail(VALID_EMAIL)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("password", "at least 6 characters");
    }

    @Test
    public void givenPasswordTooLong_whenValidate_thenInvalidObject(){
        bean.setPassword(PASSWORD_TOO_LONG);
        bean.setRepassword(PASSWORD_TOO_LONG);
        when(verifierServiceMock.checkEmail(VALID_EMAIL)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("password", "up to 20 characters");
    }

    @Test
    public void givenPasswordWithoutDigits_whenValidate_thenInvalidObject(){
        bean.setPassword(PASSWORD_WITHOUT_DIGITS);
        bean.setRepassword(PASSWORD_WITHOUT_DIGITS);
        when(verifierServiceMock.checkEmail(VALID_EMAIL)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("password", "at least one digit");
    }

    @Test
    public void givenNonMatchingRepassword_whenValidate_thenInvalidObject(){
        bean.setRepassword(NOT_MATCHING_REPASSWORD);
        when(verifierServiceMock.checkEmail(VALID_EMAIL)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("repassword", "Re-Password is required to match Password");
    }

    @Test
    public void givenValidData_whenValidate_thenNoErrors(){
        when(verifierServiceMock.checkEmail(VALID_EMAIL)).thenReturn(false);
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertEquals(0, errors.getErrorCount());
    }

    private void assertError(String field, String errorMessage) {
        assertEquals(1, errors.getErrorCount());
        assertEquals(field, errors.getFieldError().getField());
        assertThat(errors.getFieldError().getDefaultMessage(), containsString(errorMessage));
    }
}