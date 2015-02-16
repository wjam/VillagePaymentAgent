/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Device;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class DeviceDAOImpl extends HibernateDaoSupport implements DeviceDAO
{
    public void saveDevice(Device device)
    {
        getHibernateTemplate().saveOrUpdate(device);
    }

    public List<Device> getDevicesByAllocation(String allocation)
    {
        List l = getHibernateTemplate().find("from Device d where d.allocation=?", allocation);
        List<Device> deviceList = new ArrayList<Device>();
        System.out.println("device list size: " + l.size());
        if(l.size() > 0)
        {
            for (int i = 0; i < l.size(); i++)
            {
                Device device = (Device)l.get(i);
                deviceList.add(device);
            }
        }
        return deviceList ;
    }
}
