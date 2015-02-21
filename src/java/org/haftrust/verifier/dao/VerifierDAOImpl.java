/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Address;
import org.haftrust.verifier.model.Verifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class VerifierDAOImpl extends HibernateDaoSupport implements VerifierDAO {

    public boolean getVerifierByEmail(String email) {
        List l = getHibernateTemplate().find("from Verifier v where v.email=?", email);

        System.out.println("verifier email list size: " + l.size());
        if (l.size() > 0) {
            return true;
        }

        return false;
    }

    public Verifier setVerifier(Verifier verifier) {
        try {
            if (verifier.getId() < 1) {
                getHibernateTemplate().save(verifier);
                System.out.println("------------------------ verifier saved");
                System.out.println("------------------------ verifier save id: " + verifier.getId());
            } else {
                getHibernateTemplate().saveOrUpdate(verifier);
                System.out.println("------------------------ verifier saved or updated");
                System.out.println("------------------------ verifier save id: " + verifier.getId());
            }
        } catch (NullPointerException exc) {
            getHibernateTemplate().save(verifier);
            System.out.println("------------------------ verifier saved NullPointerException");
            System.out.println("------------------------ verifier save id: " + verifier.getId());
        }

        return verifier;
    }

    public List<Verifier> getVerifierbyAddress(Address address, String status) {
        Object[] param = {address, status};
        List l = getHibernateTemplate().find("from Verifier v where v.address=? and v.status=?", param);
        List<Verifier> verifierList = new ArrayList<Verifier>();
        System.out.println("verifier list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Verifier v = (Verifier) l.get(i);
                verifierList.add(v);
            }
        }

        return verifierList;
    }

    public List<Verifier> getPreRegisteredVerifierByEmailAndPassword(String email, String password, String status) {
        Object[] param = {email, password, status};
        List l = getHibernateTemplate().find("from Verifier v where v.email=? and v.password=? and v.status=?", param);
        List<Verifier> verifierList = new ArrayList<Verifier>();
        System.out.println("verifier list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Verifier v = (Verifier) l.get(i);
                verifierList.add(v);
            }
        }
        return verifierList;
    }
}
