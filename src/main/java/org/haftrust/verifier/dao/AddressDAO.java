/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.Address;
import org.haftrust.verifier.model.Country;
import org.haftrust.verifier.model.Region;
import org.haftrust.verifier.model.Verifier;

/**
 *
 * @author Miroslav
 */
public interface AddressDAO {

    public Address getAddress(Verifier ver, String employeeType);

    public Address saveAddress(Address address);

    public List<Address> getAddressByCountryAndRegion(Country country, Region region, String employeeType);
}
