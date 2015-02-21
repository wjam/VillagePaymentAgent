/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class CountryDAOImpl extends HibernateDaoSupport implements CountryDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CountryDAOImpl.class);

    public List<Country> getCountries() {
        List l = getHibernateTemplate().find("from Country");
        List<Country> countryList = new ArrayList<Country>();
        LOG.debug("country list size: {}", l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Country country = (Country) l.get(i);
                countryList.add(country);
            }
        }
        return countryList;
    }
}
