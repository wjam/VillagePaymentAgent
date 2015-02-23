/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import org.haftrust.verifier.view.RegisterVerifierBean;
import org.junit.Before;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 *
 * @author amarinperez
 */
public class BankValidatorTestBase {

    protected RegisterVerifierBean bean;
    protected Errors errors;
    protected BankValidator validator;

    @Before
    public void setup() {
        bean = RegisterVerifierBeanBuilder.getValidBean();
        errors = new BeanPropertyBindingResult(bean, "registerVerifierBean");
        validator = new BankValidator();
    }

    protected void assertErrorContainingMessage(final String errorMessage) {
        assertThat(errors.getErrorCount(), greaterThanOrEqualTo(1));
        FieldError error = errors.getFieldError();
        assertThat(error.getDefaultMessage(), containsString(errorMessage));
    }
}
