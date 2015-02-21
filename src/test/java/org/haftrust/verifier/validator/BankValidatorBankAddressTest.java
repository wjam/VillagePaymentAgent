/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import org.junit.Test;

/**
 *
 * @author amarinperez
 */
public class BankValidatorBankAddressTest extends BankValidatorTestBase {

    @Test
    public void testBankAddressTooLong() {
        bean.setBankAddress("A bank address that is too long for the current validation process, thus failing without remedy. Bank addresses need to be shorter than this.");
        validator.validate(bean, errors);
        assertErrorContainingMessage("up to 100 characters");
    }
}
