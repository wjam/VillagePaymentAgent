/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Fom;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class FomDAOImpl extends HibernateDaoSupport implements FomDAO {

    public List<Fom> getFom() {

        List l = getHibernateTemplate().find("from Fom");
        List<Fom> fomList = new ArrayList<Fom>();

        System.out.println("fom list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Fom fom = (Fom) l.get(i);
                fomList.add(fom);
            }
        }

        return fomList;
    }
}
