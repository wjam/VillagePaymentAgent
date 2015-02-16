/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.Country;
import org.haftrust.verifier.model.Region;

/**
 *
 * @author Miroslav
 */
public interface RegionDAO
{
    public List<Region> getRegions(Country c);
}
