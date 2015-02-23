/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import org.haftrust.verifier.view.RegisterVerifierBean;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.validation.FieldError;

/**
 *
 * @author amarinperez
 */
public class BankValidatorRequiredFieldsTest extends BankValidatorTestBase {

    @Test
    public void testBankAccountNumber() {
        bean.setBankAccountNumber(null);
        validateWithMissingField(bean, "bankAccountNumber");
    }

    @Test
    public void testBankName() {
        bean.setBankName(null);
        validateWithMissingField(bean, "bankName");
    }

    @Test
    public void testBankContactNumber() {
        bean.setBankContactNumber(null);
        validateWithMissingField(bean, "bankContactNumber");
    }

    @Test
    public void testBankAddress() {
        bean.setBankAddress(null);
        validateWithMissingField(bean, "bankAddress");
    }

    @Test
    public void testBankIban() {
        bean.setBankIban(null);
        validateWithMissingField(bean, "bankIban");
    }

    private void validateWithMissingField(RegisterVerifierBean bean, String field) {
        try {
            validator.validate(bean, errors);
        } catch (Exception e) {
            assertEquals(1, errors.getErrorCount());
            FieldError fieldError = errors.getFieldError();
            assertEquals(field, fieldError.getField());
        }
    }
}
