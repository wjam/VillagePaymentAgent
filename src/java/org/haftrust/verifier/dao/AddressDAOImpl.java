/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Address;
import org.haftrust.verifier.model.Country;
import org.haftrust.verifier.model.Region;
import org.haftrust.verifier.model.Verifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class AddressDAOImpl extends HibernateDaoSupport implements AddressDAO
{
    public Address saveAddress(Address address)
    {
        try
        {
            if(address.getId() < 1)
            {
                getHibernateTemplate().save(address);
                System.out.println("------------------------ address saved");
                System.out.println("------------------------ address save id: " + address.getId());
            }
            else
            {
                getHibernateTemplate().saveOrUpdate(address);
                System.out.println("------------------------ address saved or updated");
                System.out.println("------------------------ address save id: " + address.getId());
            }
        }catch(NullPointerException exc)
        {
            getHibernateTemplate().save(address);
            System.out.println("------------------------ address saved NullPointerException");
            System.out.println("------------------------ address save id: " + address.getId());
        }

        return address;
    }

    public List<Address> getAddressByCountryAndRegion(Country country, Region region, String employeeType)
    {
        Object[] param = {country, region, employeeType};
        List l = getHibernateTemplate().find("from Address a where a.country=? and a.region=? and a.employeeType=?", param);
        List<Address> addressList = new ArrayList<Address>();

        System.out.println("address list size: " + l.size());
        if(l.size() > 0)
        {
            for (int i = 0; i < l.size(); i++)
            {
                Address address = (Address)l.get(i);
                addressList.add(address);
            }
        }

        return addressList;
    }
    public Address getAddress(Verifier ver, String employeeType)
    {
        Object[] param = {ver, employeeType};
        List l = getHibernateTemplate().find("from Address a where a.verifier=? and a.employeeType=?", param);
        List<Address> addressList = new ArrayList<Address>();
        System.out.println("address list size: " + l.size());
        if(l.size() > 0)
        {
            for (int i = 0; i < l.size(); i++)
            {
                Address address = (Address)l.get(i);
                addressList.add(address);
            }
        }

        if(addressList.isEmpty())
        {
            return null;
        }
        else
        {
            return addressList.get(0) ;
        }
    }
}
