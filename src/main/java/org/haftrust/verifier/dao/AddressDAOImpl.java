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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class AddressDAOImpl extends HibernateDaoSupport implements AddressDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AddressDAOImpl.class);

    public Address saveAddress(Address address) {
        getHibernateTemplate().merge(address);

        return address;
    }

    public List<Address> getAddressByCountryAndRegion(Country country, Region region, String employeeType) {
        Object[] param = {country, region, employeeType};
        List l = getHibernateTemplate().find("from Address a where a.country=? and a.region=? and a.employeeType=?", param);
        List<Address> addressList = new ArrayList<Address>();

        LOG.debug("address list size: {}", l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Address address = (Address) l.get(i);
                addressList.add(address);
            }
        }

        return addressList;
    }

    public Address getAddress(Verifier ver, String employeeType) {
        Object[] param = {ver, employeeType};
        List l = getHibernateTemplate().find("from Address a where a.verifier=? and a.employeeType=?", param);
        List<Address> addressList = new ArrayList<Address>();
        LOG.debug("address list size: {}", l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Address address = (Address) l.get(i);
                addressList.add(address);
            }
        }

        if (addressList.isEmpty()) {
            return null;
        } else {
            return addressList.get(0);
        }
    }
}
