/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Bank;
import org.haftrust.verifier.model.Verifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class BankDAOImpl extends HibernateDaoSupport implements BankDAO {

    public List<Bank> getBankByAccountNumber(String account) {
        List<Bank> bankList = new ArrayList<Bank>();

        List l = getHibernateTemplate().find("from Bank b where b.accountNumber=?", account);

        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Bank b = new Bank();
                b = (Bank) l.get(i);
                bankList.add(b);
            }
        }

        return bankList;
    }

    public Bank saveBank(Bank bank) {
        getHibernateTemplate().saveOrUpdate(bank);
        System.out.println("------------------------ bank saved");
        System.out.println("------------------------ bank save id: " + bank.getAccountNumber());

        return bank;
    }

    public Bank getBank(Verifier ver, String employeeType) {
        Object[] param = {ver, employeeType};
        List l = getHibernateTemplate().find("from Bank b where b.verifier=? and b.employeeType=?", param);
        List<Bank> bankList = new ArrayList<Bank>();
        System.out.println("bank list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Bank bank = (Bank) l.get(i);
                bankList.add(bank);
            }
        }

        if (bankList.isEmpty()) {
            return null;
        } else {
            return bankList.get(0);
        }
    }
}
