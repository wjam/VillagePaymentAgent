/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import java.util.Arrays;
import org.haftrust.verifier.model.Bank;
import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.RegisterVerifierBean;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import static org.mockito.Mockito.*;
import org.springframework.validation.FieldError;

/**
 *
 * @author amarinperez
 */
public class BankValidatorAccountNumberTest {

    private RegisterVerifierBean bean;
    private Errors errors;
    private BankValidator validator;

    @Before
    public void setup() {
        bean = RegisterVerifierBeanBuilder.getValidBean();
        errors = new BeanPropertyBindingResult(bean, "registerVerifierBean");
        validator = new BankValidator();
    }

    @Test
    public void testNonNumericAccountNumber() {
        bean.setBankAccountNumber("33a33333");

        validator.validate(bean, errors);

        assertErrorWithMessage("numeric format");
    }

    @Test
    public void testAccountIsRegistered() {
        VerifierService service = getVerifierServiceWhichAlwaysFindsABank();
        validator.setVerifierService(service);

        validator.validate(bean, errors);

        assertErrorWithMessage("already registered");
    }

    @Test
    public void testAccountNumberTooShort() {
        bean.setBankAccountNumber("123456");
        validator.validate(bean, errors);

        assertErrorWithMessage("less than 7 digits");
    }

    @Test
    public void testAccountNumberTooLong() {
        bean.setBankAccountNumber("12345678901");
        validator.validate(bean, errors);

        assertErrorWithMessage("maximum value");
        assertErrorWithMessage("10 digits");

    }

    private void assertErrorWithMessage(final String errorMessage) {
        assertThat(errors.getErrorCount(), greaterThanOrEqualTo(1));
        FieldError error = errors.getFieldError();
        assertThat(error.getDefaultMessage(), containsString(errorMessage));
    }

    private VerifierService getVerifierServiceWhichAlwaysFindsABank() {
        Bank bank = mock(Bank.class);
        VerifierService service = mock(VerifierService.class);
        when(service.getBanksWhereAccountIsRegistered(anyString())).thenReturn(Arrays.asList(new Bank[]{bank}));
        return service;
    }
}
