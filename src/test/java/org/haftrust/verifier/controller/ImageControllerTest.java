package org.haftrust.verifier.controller;

import org.haftrust.verifier.model.Image;
import org.haftrust.verifier.service.ImageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class ImageControllerTest {
    private final byte[] imageBytes = "test".getBytes();
    private final byte[] emptyArray = new byte[0];

    private ImageService imageService;
    private ImageController imageController;

    @Before
    public void setup() {
        imageService = mock(ImageService.class);
        imageController = new ImageController(imageService);
    }

    @Test
    public void testSuccessfullyGettingImage() {
        Image image = new Image();
        image.setPhoto(imageBytes);
        when(imageService.find(1)).thenReturn(image);

        ResponseEntity<byte[]> actual = imageController.doGet("1");

        Assert.assertArrayEquals(imageBytes, actual.getBody());
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());

        verify(imageService).find(1);
    }

    @Test
    public void testIdNotSuppliedReturnsBadRequest() {
        ResponseEntity<byte[]> actual = imageController.doGet(null);

        Assert.assertArrayEquals(emptyArray, actual.getBody());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());

        verifyZeroInteractions(imageService);
    }

    @Test
    public void testIdInvalidReturnsBadRequest() {
        ResponseEntity<byte[]> actual = imageController.doGet("one");

        Assert.assertArrayEquals(emptyArray, actual.getBody());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());

        verifyZeroInteractions(imageService);
    }

    @Test
    public void testIdNotExistingReturnsNotFound() {
        when(imageService.find(2)).thenReturn(null);

        ResponseEntity<byte[]> actual = imageController.doGet("2");

        Assert.assertArrayEquals(emptyArray, actual.getBody());
        Assert.assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());

        verify(imageService).find(2);
    }
}
