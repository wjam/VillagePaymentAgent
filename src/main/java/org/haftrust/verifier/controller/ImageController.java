/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.controller;

import org.haftrust.verifier.model.Image;
import org.haftrust.verifier.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Miroslav
 */
@Controller
public class ImageController {

    private static final Logger LOG = LoggerFactory.getLogger(ImageController.class);

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public ResponseEntity<byte[]> doGet(@RequestParam("id") String imageId) {
        LOG.debug("Retrieving image with id: {}", imageId);
        final int id = parseId(imageId);
        if (id <= -1) {
            return new ResponseEntity<>(new byte[0], HttpStatus.BAD_REQUEST);
        }

        final Image image = imageService.find(id);
        LOG.debug("Retrieved image: {}", image);

        if (image == null) {
            return new ResponseEntity<>(new byte[0], HttpStatus.NOT_FOUND);
        }

        LOG.debug("Image size: {}", image.getPhoto().length);
        return new ResponseEntity<>(image.getPhoto(), HttpStatus.OK);

    }

    private int parseId(final String imageId) {
        if (imageId == null) {
            return -1;
        }
        try {
            return Integer.parseInt(imageId);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
