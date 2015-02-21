/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Country;
import org.haftrust.verifier.model.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class RegionDAOImpl extends HibernateDaoSupport implements RegionDAO {

    private static final Logger LOG = LoggerFactory.getLogger(RegionDAOImpl.class);

    public List<Region> getRegions(Country c) {
        List l = getHibernateTemplate().find("from Region r where r.country=?", c);
        List<Region> regionList = new ArrayList<Region>();
        LOG.debug("region list size: {}", l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Region region = (Region) l.get(i);
                regionList.add(region);
            }
        }
        return regionList;
    }
}
