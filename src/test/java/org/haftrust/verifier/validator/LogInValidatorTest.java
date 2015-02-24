package org.haftrust.verifier.validator;

import org.haftrust.verifier.model.Verifier;
import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.RegisterVerifierBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author mgrindei
 */
public class LogInValidatorTest {
    private static final String EMAIL = "john@yahoo.com";
    private static final String PASSWORD = "password";

    private RegisterVerifierBean bean;
    private Errors errors;
    private LogInValidator classToTest;
    private VerifierService verifierServiceMock;

    @Before
    public void setup() {
        bean = createValidLogin();
        errors = new BeanPropertyBindingResult(bean, "registerVerifierBean");
        classToTest = new LogInValidator();
        verifierServiceMock = mock(VerifierService.class);
    }

    private RegisterVerifierBean createValidLogin() {
        RegisterVerifierBean registerVerifierBean = new RegisterVerifierBean();
        registerVerifierBean.setEmail(EMAIL);
        registerVerifierBean.setPassword(PASSWORD);
        return registerVerifierBean;
    }

    @Test(expected = Exception.class)
    public void givenLoginWithNullEmail_whenValidate_thenInvalidObject() {
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
    public void givenLoginWithNullPassword_whenValidate_thenInvalidObject() {
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

    @Test
    public void givenLoginWithIncorrectEmailOrPassword_whenValidate_thenInvalidObject() {
        when(verifierServiceMock.isVerifier(EMAIL, PASSWORD)).thenReturn(Collections.<Verifier>emptyList());
        classToTest.setVerifierService(verifierServiceMock);
        classToTest.validate(bean, errors);
        assertError("email", "The Email or Password entered is incorrect");
    }

    @Test
    public void givenValidLogin_whenValidate_thenNoErrors(){
        ArrayList<Verifier> verifiers = new ArrayList<>();
        verifiers.add(new Verifier());
        when(verifierServiceMock.isVerifier(EMAIL, PASSWORD)).thenReturn(verifiers);
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