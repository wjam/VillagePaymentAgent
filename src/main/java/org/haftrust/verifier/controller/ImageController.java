/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import javax.servlet.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import mydao.DaoFactory;
//import mydao.ImageDAO;
//import mymodel.Image;
import org.haftrust.verifier.dao.ImageDAO;
import org.haftrust.verifier.dao.ImageDAOImpl;
import org.haftrust.verifier.dao.VerifierDAO;
import org.haftrust.verifier.model.Image;
import org.haftrust.verifier.service.ImageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Miroslav
 */
public class ImageController extends HttpServlet {

    ImageService imageService;
    ImageDAO imageDao;
    VerifierDAO verifierDao;

    public void init(ServletConfig config) throws ServletException {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[]{"classpath*:applicationContext.xml"});

        //imageDao = (ImageDAO) appContext.getBean("imageDao");
        //verifierDao = (VerifierDAO) appContext.getBean("verifierDao");
        this.imageService = (ImageService) appContext.getBean("imageService");

    }

    public ImageDAO getImageDao() {
        return imageDao;
    }

    public void setImageDao(ImageDAO imageDao) {
        this.imageDao = imageDao;
    }

    public ImageService getImageService() {
        return imageService;
    }

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
    // Constants ----------------------------------------------------------------------------------
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

    // Statics ------------------------------------------------------------------------------------
    //private static ImageDAOImpl imageDAO = new ImageDAOImpl();
    // Actions ------------------------------------------------------------------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("--------------------------------------- image controller doGet method");
        // Get ID from request.
        String imageId = request.getParameter("id");
        Image image = imageDao.find(Integer.parseInt(imageId));
        System.out.println("image = " + image.getPhoto());
        image.getPhoto();
        System.out.println("--------------------------------------- image controller doGet method imageId: " + imageId);
        // Check if ID is supplied to the request.
        if (imageId == null) {
            // Do your thing if the ID is not supplied to the request.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        // Lookup Image by ImageId in database.
        // Do your "SELECT * FROM Image WHERE ImageID" thing.
        //Image image = new Image();
        //image = this.imageService.find(Integer.parseInt(imageId.trim()));
        System.out.println("--------------------------------------- image controller doGet method byets lenght: " + image.getPhoto().length);

        // Check if image is actually retrieved from database.
        if (image == null) {
            // Do your thing if the image does not exist in database.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        // Init servlet response.
        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType("image/gif");
        response.setHeader("Content-Length", String.valueOf(image.getPhoto().length));
        response.setHeader("Content-Disposition", "inline; filename=\"" + "verifierPic" + "\"");

        // Prepare streams.
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            // Open streams.
            //input = new BufferedInputStream(image.getContent(), DEFAULT_BUFFER_SIZE);
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

            // Write file contents to response.
            byte[] buffer = image.getPhoto();//new byte[DEFAULT_BUFFER_SIZE];
            int length = buffer.length;
            //while (length = buffer.length > 0) {
            output.write(buffer, 0, length);
            //}
        } finally {
            // Gently close streams.
            close(output);
            close(input);
        }
    }

    // Helpers (can be refactored to public utility class) ----------------------------------------
    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
        }
    }
}
