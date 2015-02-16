/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.District;
import org.haftrust.verifier.model.Region;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class DistrictDAOImpl extends HibernateDaoSupport implements DistrictDAO
{
    public List<District> getDistricts(Region r)
    {
        List l = getHibernateTemplate().find("from District d where d.region=?", r);
        List<District> districtList = new ArrayList<District>();
        System.out.println("district list size: " + l.size());
        if(l.size() > 0)
        {
            for (int i = 0; i < l.size(); i++)
            {
                District district = (District)l.get(i);
                districtList.add(district);
            }
        }
        return districtList;
    }

    public District getDistricts(District d)
    {
        List l = getHibernateTemplate().find("from District d where d.id=?", d);
        List<District> districtList = new ArrayList<District>();
        System.out.println("district list size: " + l.size());
        if(l.size() > 0)
        {
            for (int i = 0; i < l.size(); i++)
            {
                District district = (District)l.get(i);
                districtList.add(district);
            }
        }
        return districtList.get(0);
    }
}
