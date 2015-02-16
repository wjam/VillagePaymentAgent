/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import org.haftrust.verifier.model.Image;

/**
 *
 * @author Miroslav
 */
public interface ImageDAO
{
    public Image saveImage(Image image);
    public Image find(int imageId);

}
