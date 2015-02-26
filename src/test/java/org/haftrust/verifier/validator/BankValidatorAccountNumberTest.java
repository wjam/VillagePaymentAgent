/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import java.util.Arrays;
import org.haftrust.verifier.model.Bank;
import org.haftrust.verifier.service.VerifierService;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author amarinperez
 */
public class BankValidatorAccountNumberTest extends BankValidatorTestBase {

    @Test
    public void testNonNumericAccountNumber() {
        bean.setBankAccountNumber("33a33333");

        validate();

        assertErrorContainingMessage("numeric format");
    }

    @Test
    public void testAccountIsAlreadyRegistered() {
        VerifierService service = getVerifierServiceWhichAlwaysFindsABank();
        validator.setVerifierService(service);

        validate();

        assertErrorContainingMessage("already registered");
    }

    @Test
    public void testAccountNumberTooShort() {
        bean.setBankAccountNumber("123456");
        validate();

        assertErrorContainingMessage("less than 7 digits");
    }

    @Test
    public void testAccountNumberTooLong() {
        bean.setBankAccountNumber("12345678901");
        validate();

        assertErrorContainingMessage("maximum value");
        assertErrorContainingMessage("10 digits");

    }

    private VerifierService getVerifierServiceWhichAlwaysFindsABank() {
        Bank bank = mock(Bank.class);
        VerifierService service = mock(VerifierService.class);
        when(service.getBanksWhereAccountIsRegistered(anyString())).thenReturn(Arrays.asList(new Bank[]{bank}));
        return service;
    }
}
