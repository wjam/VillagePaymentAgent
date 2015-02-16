/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import org.haftrust.verifier.model.Interview;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class InterviewDAOImpl extends HibernateDaoSupport implements InterviewDAO
{
    public Interview saveInterview(Interview interview)
    {
        try
        {
            if(interview.getId() < 1)
            {
                getHibernateTemplate().save(interview);
                System.out.println("------------------------ interview saved");
                System.out.println("------------------------ interview save id: " + interview.getId());
            }
            else
            {
                getHibernateTemplate().saveOrUpdate(interview);
                System.out.println("------------------------ interview saved or updated");
                System.out.println("------------------------ interview save id: " + interview.getId());
            }
        }catch(NullPointerException exc)
        {
            getHibernateTemplate().save(interview);
            System.out.println("------------------------ interview saved NullPointerException");
            System.out.println("------------------------ interview save id: " + interview.getId());
        }

        return interview;
    }
}
