package com.med.ani.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.med.ani.entities.Image;
import com.med.ani.entities.Animal;
import com.med.ani.repos.ImageRepository;
import com.med.ani.repos.AnimalRepository;

@Transactional
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    AnimalService animalService;

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public Image uploadImage(MultipartFile file) throws IOException {
        // Using builder pattern for creating Image object
        return imageRepository.save(
            Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .build()
        );
    }

    @Override
    public Image getImageDetails(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        if (dbImage.isPresent()) {
            return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage())
                .build();
        } else {
            throw new IOException("Image not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        if (dbImage.isPresent()) {
            return ResponseEntity.ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image uploadImageForAnimal(MultipartFile file, Long animalId) throws IOException {
        Animal animal = new Animal();
        animal.setId(animalId);
        return imageRepository.save(
            Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .animal(animal)
                .build()
        );
    }

    @Override
    public List<Image> getImagesByAnimal(Long animalId) {
        Animal animal = animalRepository.findById(animalId).orElseThrow(() ->
            new RuntimeException("Animal not found with ID: " + animalId));
        return animal.getImages();
    }
}
