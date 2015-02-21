/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.service;

import org.haftrust.verifier.dao.ImageDAO;
import org.haftrust.verifier.model.Image;

/**
 *
 * @author Miroslav
 */
public class ImageServiceImpl implements ImageService {

    private ImageDAO imageDao;

    public ImageDAO getImageDao() {
        return imageDao;
    }

    public void setImageDao(ImageDAO imageDao) {
        this.imageDao = imageDao;
    }

    public Image find(int imageId) {
        return this.imageDao.find(imageId);
    }

}
