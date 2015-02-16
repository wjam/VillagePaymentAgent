/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.Bank;
import org.haftrust.verifier.model.Verifier;

/**
 *
 * @author Miroslav
 */
public interface BankDAO
{
    public Bank getBank(Verifier ver, String employeeType);
    public Bank saveBank(Bank bank);
    public List<Bank> getBankByAccountNumber(String account);
}
