/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.IdentityDocument;
import org.haftrust.verifier.model.Verifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class IdentityDocumentDAOImpl extends HibernateDaoSupport implements IdentityDocumentDAO {

    private static final Logger LOG = LoggerFactory.getLogger(IdentityDocumentDAOImpl.class);

    public IdentityDocument saveIdentityDocument(IdentityDocument identityDocument) {
        try {
            if (identityDocument.getId() < 1) {
                getHibernateTemplate().save(identityDocument);
                LOG.debug("------------------------ identity Document saved");
                LOG.debug("------------------------ identity Document save id: {}", identityDocument.getId());
            } else {
                getHibernateTemplate().saveOrUpdate(identityDocument);
                LOG.debug("------------------------ identity Document saved or updated");
                LOG.debug("------------------------ identity Document save id: {}", identityDocument.getId());
            }
        } catch (NullPointerException exc) {
            getHibernateTemplate().save(identityDocument);
            LOG.debug("------------------------ address saved NullPointerException");
            LOG.debug("------------------------ address save id: {}", identityDocument.getId());
        }

        return identityDocument;
    }

    public IdentityDocument getIdentityDocument(Verifier ver, String employeeType) {
        Object[] param = {ver, employeeType};
        List l = getHibernateTemplate().find("from IdentityDocument i where i.verifier=? and i.employeeType=?", param);
        List<IdentityDocument> identityDocumentList = new ArrayList<IdentityDocument>();
        LOG.debug("identity document list size: {}", l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                IdentityDocument id = (IdentityDocument) l.get(i);
                identityDocumentList.add(id);
            }
        }

        if (identityDocumentList.isEmpty()) {
            return null;
        } else {
            return identityDocumentList.get(0);
        }
    }
}
