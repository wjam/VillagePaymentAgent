/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import org.haftrust.verifier.model.Interview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class InterviewDAOImpl extends HibernateDaoSupport implements InterviewDAO {

    private static final Logger LOG = LoggerFactory.getLogger(InterviewDAOImpl.class);

    public Interview saveInterview(Interview interview) {
        try {
            if (interview.getId() < 1) {
                getHibernateTemplate().save(interview);
                LOG.debug("------------------------ interview saved");
                LOG.debug("------------------------ interview save id: {}", interview.getId());
            } else {
                getHibernateTemplate().saveOrUpdate(interview);
                LOG.debug("------------------------ interview saved or updated");
                LOG.debug("------------------------ interview save id: {}", interview.getId());
            }
        } catch (NullPointerException exc) {
            getHibernateTemplate().save(interview);
            LOG.debug("------------------------ interview saved NullPointerException");
            LOG.debug("------------------------ interview save id: {}", interview.getId());
        }

        return interview;
    }
}
