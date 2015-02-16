/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Country;
import org.haftrust.verifier.model.Region;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class RegionDAOImpl extends HibernateDaoSupport implements RegionDAO
{
    public List<Region> getRegions(Country c)
    {
        List l = getHibernateTemplate().find("from Region r where r.country=?", c);
        List<Region> regionList = new ArrayList<Region>();
        System.out.println("region list size: " + l.size());
        if(l.size() > 0)
        {
            for (int i = 0; i < l.size(); i++)
            {
                Region region = (Region)l.get(i);
                regionList.add(region);
            }
        }
        return regionList;
    }
}
