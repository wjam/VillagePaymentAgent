/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.District;
import org.haftrust.verifier.model.Region;

/**
 *
 * @author Miroslav
 */
public interface DistrictDAO
{
    public List<District> getDistricts(Region r);
    public District getDistricts(District d);
}
