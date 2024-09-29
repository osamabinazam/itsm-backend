package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Image;
import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The ImageService class is responsible for handling image-related operations.
 * It provides methods for storing and retrieving images.
 * The class is annotated with @Service to indicate that it is a service class.
 */
@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final Path rootLocation;

    /**
     * Constructs a new ImageService with the given ImageRepository.
     *
     * @param imageRepository The ImageRepository to use for image operations.
     * @throws IOException If an error occurs while creating the storage directory.
     */
    public ImageService(ImageRepository imageRepository) throws IOException {
        this.imageRepository = imageRepository;
        this.rootLocation = Paths.get("uploads").toAbsolutePath().normalize();
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new IOException("Could not create the storage directory at the root.", e);
        }
    }

    /**
     * Stores a list of images in the file system and associates them with a request.
     *
     * @param images       The list of images to store.
     * @param savedRequest The request to associate the images with.
     * @return A list of Image entities representing the stored images.
     * @throws IOException If an error occurs while storing the images.
     */
    public List<Image> storeImages(List<MultipartFile> images, Request savedRequest) throws IOException {
        List<Image> imageEntities = new ArrayList<>();
        for (MultipartFile imageFile : images) {
            String filePath = saveImageToFileSystem(imageFile);
            Image image = new Image();
            image.setImagePath(filePath);
            image.setRequest(savedRequest);
            imageEntities.add(image);
        }
        imageRepository.saveAll(imageEntities);
        return imageEntities;
    }

    /**
     * Saves an image to the file system.
     *
     * @param file The image file to save.
     * @return The path to the saved image.
     * @throws IOException If an error occurs while saving the image.
     */
    private String saveImageToFileSystem(MultipartFile file) throws IOException {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path targetLocation = rootLocation.resolve(fileName);
            file.transferTo(targetLocation.toFile());
            return targetLocation.toString();
        } catch (IOException e) {
            throw new IOException("Could not store file " + file.getOriginalFilename() + ". Please try again!", e);
        }
    }

    /**
     * Retrieves all images associated with a specific request.
     *
     * @param request The request for which to retrieve images.
     * @return A list of Image entities associated with the given request.
     */
    public List<Image> getImagesByRequest(Request request) {
        return imageRepository.findAllByRequest(request);
    }
}
