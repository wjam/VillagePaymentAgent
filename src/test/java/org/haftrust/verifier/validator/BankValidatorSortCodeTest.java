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
public class BankValidatorSortCodeTest extends BankValidatorTestBase {

    @Test
    public void testSortCodeTooLong() {
        bean.setBankSortCode("1234567");
        validate();
        assertErrorContainingMessage("up to 6");
    }
    
    @Test
    public void testSortCodeTooShort()
    {
        bean.setBankSortCode("12345");
        validate();
        assertErrorContainingMessage("up to 6");
    }
    
    @Test
    public void testIsNotNumeric()
    {
        bean.setBankSortCode("abcdef");
        validate();
        assertErrorContainingMessage("numeric format");
    }

}
