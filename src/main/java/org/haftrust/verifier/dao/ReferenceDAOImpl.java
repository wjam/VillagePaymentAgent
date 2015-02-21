/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Reference;
import org.haftrust.verifier.model.Verifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class ReferenceDAOImpl extends HibernateDaoSupport implements ReferenceDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ReferenceDAOImpl.class);

    public Reference saveReference(Reference reference) {
        try {
            if (reference.getId() < 1) {
                getHibernateTemplate().save(reference);
                LOG.debug("------------------------ reference saved");
                LOG.debug("------------------------ reference save id: {}", reference.getId());
            } else {
                getHibernateTemplate().saveOrUpdate(reference);
                LOG.debug("------------------------ reference saved or updated");
                LOG.debug("------------------------ reference save id: {}", reference.getId());
            }
        } catch (NullPointerException exc) {
            getHibernateTemplate().save(reference);
            LOG.debug("------------------------ reference saved NullPointerException");
            LOG.debug("------------------------ reference save id: {}", reference.getId());
        }

        return reference;
    }

    public List<Reference> getReferences(Verifier ver, String employeeType) {
        Object[] param = {ver, employeeType};
        List l = getHibernateTemplate().find("from Reference r where r.verifier=? and r.employeeType=?", param);
        List<Reference> referenceList = new ArrayList<Reference>();
        LOG.debug("reference list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Reference reference = (Reference) l.get(i);
                referenceList.add(reference);
            }
        }

        return referenceList;
    }
}
