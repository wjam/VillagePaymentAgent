/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.StaticData;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class StaticDataDAOImpl extends HibernateDaoSupport implements StaticDataDAO {

    public StaticData getDeviceAllocation(String description) {
        Object[] param = {"device allocation", description};
        List l = getHibernateTemplate().find("from StaticData s where s.type=? and s.description=?", param);
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data interview status list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList.get(0);
    }

    public StaticData getInterviewStatus(String description) {
        Object[] param = {"interview status", description};
        List l = getHibernateTemplate().find("from StaticData s where s.type=? and s.description=?", param);
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data interview status list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList.get(0);
    }

    public StaticData getVerificationStatus(String description) {
        Object[] param = {"verification status", description};
        List l = getHibernateTemplate().find("from StaticData s where s.type=? and s.description=?", param);
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data verification status list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList.get(0);
    }

    public StaticData getEmploymentStatus(String description) {
        Object[] param = {"employment status", description};
        List l = getHibernateTemplate().find("from StaticData s where s.type=? and s.description=?", param);
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data employment status list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList.get(0);
    }

    public StaticData getEmployeeType(String description) {
        Object[] param = {"employee type", description};
        List l = getHibernateTemplate().find("from StaticData s where s.type=? and s.description=?", param);
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data employee type list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList.get(0);
    }

    public List<StaticData> getVerificationStatusTypes() {
        List l = getHibernateTemplate().find("from StaticData s where s.type=?", "verification status");
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data gender list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList;
    }

    public List<StaticData> getGenders() {
        List l = getHibernateTemplate().find("from StaticData s where s.type=?", "gender");
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data gender list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList;
    }

    public List<StaticData> getEducationLevels() {
        List l = getHibernateTemplate().find("from StaticData s where s.type=?", "education level");
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data education level list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList;
    }

    public List<StaticData> getEducationTypes() {
        List l = getHibernateTemplate().find("from StaticData s where s.type=?", "education type");
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data education type list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList;
    }

    public List<StaticData> getIdentityDocumentTypes() {
        List l = getHibernateTemplate().find("from StaticData s where s.type=?", "identity document type");
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data identity document type list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList;
    }

    public List<StaticData> getTitles() {
        List l = getHibernateTemplate().find("from StaticData s where s.type=?", "title");
        List<StaticData> staticDataList = new ArrayList<StaticData>();
        System.out.println("static data title list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                StaticData staticData = (StaticData) l.get(i);
                staticDataList.add(staticData);
            }
        }
        return staticDataList;
    }
}
