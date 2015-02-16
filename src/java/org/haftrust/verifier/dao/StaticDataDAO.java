/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.StaticData;

/**
 *
 * @author Miroslav
 */
public interface StaticDataDAO
{
    public StaticData getEmploymentStatus(String description);
    public StaticData getEmployeeType(String description);
    public List<StaticData> getGenders();
    public List<StaticData> getEducationLevels();
    public List<StaticData> getEducationTypes();
    public List<StaticData> getIdentityDocumentTypes();
    public List<StaticData> getTitles();
    public StaticData getVerificationStatus(String description);
    public List<StaticData> getVerificationStatusTypes();
    public StaticData getInterviewStatus(String description);
    public StaticData getDeviceAllocation(String description);
}
