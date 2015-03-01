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
public class BankValidatorContactNumberTest extends BankValidatorTestBase {
    @Test
    public void testContactNumberTooLong()
    {
        bean.setBankContactNumber("09218409218484091284092180942180921");
        validate();
        assertErrorContainingMessage("up to 25 characters");
    }
    
}
