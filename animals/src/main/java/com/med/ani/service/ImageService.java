package com.med.ani.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.med.ani.entities.Image;

public interface ImageService {

    // Upload an image
    Image uploadImage(MultipartFile file) throws IOException;

    // Get image details by ID
    Image getImageDetails(Long id) throws IOException;

    // Get the image as a byte array response
    ResponseEntity<byte[]> getImage(Long id) throws IOException;

    // Delete image by ID
    void deleteImage(Long id);

    // Upload an image associated with an animal
    Image uploadImageForAnimal(MultipartFile file, Long animalId) throws IOException;

    // Get all images associated with a specific animal
    List<Image> getImagesByAnimal(Long animalId);
}
