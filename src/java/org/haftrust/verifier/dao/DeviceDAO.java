/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.Device;

/**
 *
 * @author Miroslav
 */
public interface DeviceDAO {

    public List<Device> getDevicesByAllocation(String allocation);

    public void saveDevice(Device device);
}
