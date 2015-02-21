/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.IdentityDocument;
import org.haftrust.verifier.model.Verifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class IdentityDocumentDAOImpl extends HibernateDaoSupport implements IdentityDocumentDAO {

    public IdentityDocument saveIdentityDocument(IdentityDocument identityDocument) {
        try {
            if (identityDocument.getId() < 1) {
                getHibernateTemplate().save(identityDocument);
                System.out.println("------------------------ identity Document saved");
                System.out.println("------------------------ identity Document save id: " + identityDocument.getId());
            } else {
                getHibernateTemplate().saveOrUpdate(identityDocument);
                System.out.println("------------------------ identity Document saved or updated");
                System.out.println("------------------------ identity Document save id: " + identityDocument.getId());
            }
        } catch (NullPointerException exc) {
            getHibernateTemplate().save(identityDocument);
            System.out.println("------------------------ address saved NullPointerException");
            System.out.println("------------------------ address save id: " + identityDocument.getId());
        }

        return identityDocument;
    }

    public IdentityDocument getIdentityDocument(Verifier ver, String employeeType) {
        Object[] param = {ver, employeeType};
        List l = getHibernateTemplate().find("from IdentityDocument i where i.verifier=? and i.employeeType=?", param);
        List<IdentityDocument> identityDocumentList = new ArrayList<IdentityDocument>();
        System.out.println("identity document list size: " + l.size());
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
