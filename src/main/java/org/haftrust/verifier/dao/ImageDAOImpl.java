/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Image;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Miroslav
 */
public class ImageDAOImpl extends HibernateDaoSupport implements ImageDAO {

    public Image find(int imageId) {
        List l = getHibernateTemplate().find("from Image i where i.id=?", imageId);
        List<Image> imageList = new ArrayList<Image>();

        System.out.println("image list size: " + l.size());
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Image image = (Image) l.get(i);
                imageList.add(image);
            }
        }

        return imageList.get(0);
    }

    public Image saveImage(Image image) {
        try {
            if (image.getId() < 1) {
                getHibernateTemplate().save(image);
                System.out.println("------------------------ image saved");
                System.out.println("------------------------ image save id: " + image.getId());
            } else {
                getHibernateTemplate().saveOrUpdate(image);
                System.out.println("------------------------ image saved or updated");
                System.out.println("------------------------ image save id: " + image.getId());
            }
        } catch (NullPointerException exc) {
            getHibernateTemplate().save(image);
            System.out.println("------------------------ image saved NullPointerException");
            System.out.println("------------------------ image save id: " + image.getId());
        }

        return image;
    }
}
