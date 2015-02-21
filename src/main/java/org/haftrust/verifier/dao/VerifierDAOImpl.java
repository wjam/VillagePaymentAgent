/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Address;
import org.haftrust.verifier.model.Verifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class VerifierDAOImpl extends HibernateDaoSupport implements VerifierDAO {

    private static final Logger LOG = LoggerFactory.getLogger(VerifierDAOImpl.class);

    public boolean getVerifierByEmail(String email) {
        List l = getHibernateTemplate().find("from Verifier v where v.email=?", email);

        LOG.debug("verifier email list size: ", l.size());
        if (l.size() > 0) {
            return true;
        }

        return false;
    }

    public Verifier setVerifier(Verifier verifier) {
        try {
            if (verifier.getId() < 1) {
                getHibernateTemplate().save(verifier);
                LOG.debug("------------------------ verifier saved");
                LOG.debug("------------------------ verifier save id: {}", verifier.getId());
            } else {
                getHibernateTemplate().saveOrUpdate(verifier);
                LOG.debug("------------------------ verifier saved or updated");
                LOG.debug("------------------------ verifier save id: {}", verifier.getId());
            }
        } catch (NullPointerException exc) {
            getHibernateTemplate().save(verifier);
            LOG.debug("------------------------ verifier saved NullPointerException");
            LOG.debug("------------------------ verifier save id: {}", verifier.getId());
        }

        return verifier;
    }

    public List<Verifier> getVerifierbyAddress(Address address, String status) {
        Object[] param = {address, status};
        List l = getHibernateTemplate().find("from Verifier v where v.address=? and v.status=?", param);
        List<Verifier> verifierList = new ArrayList<Verifier>();
        LOG.debug("verifier list size: {}", l.size());
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
        LOG.debug("verifier list size: {}", l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Verifier v = (Verifier) l.get(i);
                verifierList.add(v);
            }
        }
        return verifierList;
    }
}
