package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Image;
import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The ImageService class handles image-related operations.
 * It provides methods for storing and retrieving images.
 */
@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final Path rootLocation;

    // Base URL for accessing uploaded files from the client
    @Value("${server.host.url}")
    private String serverHostUrl;

    @Value("${file.storage-location}")
    private String uploadRelativePath;

    /**
     * Constructs an ImageService with the provided ImageRepository and initializes the storage path.
     *
     * @param imageRepository The repository for managing image data.
     * @throws IOException If the upload directory cannot be created.
     */
    public ImageService(ImageRepository imageRepository) throws IOException {
        this.imageRepository = imageRepository;

        // Provide a fallback in case uploadRelativePath is null or empty
        if (uploadRelativePath == null || uploadRelativePath.isEmpty()) {
            uploadRelativePath = "uploads/";
        }

        this.rootLocation = Paths.get(System.getProperty("user.dir"), uploadRelativePath).toAbsolutePath().normalize();

        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new IOException("Could not create the storage directory at the root: " + rootLocation, e);
        }
    }

    /**
     * Stores a list of images in the file system and associates them with a request.
     * Returns a list of Image entities with public URLs for accessing the images.
     *
     * @param images       The list of images to store.
     * @param savedRequest The request to associate the images with.
     * @return A list of Image entities representing the stored images.
     * @throws IOException If an error occurs while storing the images.
     */
    public List<Image> storeImages(List<MultipartFile> images, Request savedRequest) throws IOException {
        List<Image> imageEntities = new ArrayList<>();
        for (MultipartFile imageFile : images) {
            // Store the image and get the public URL
            String publicUrl = saveImageToFileSystem(imageFile);

            // Create Image entity
            Image image = new Image();
            image.setImagePath(publicUrl);  // Store public URL in Image entity
            image.setRequest(savedRequest);
            imageEntities.add(image);
        }

        imageRepository.saveAll(imageEntities);
        return imageEntities;
    }

    /**
     * Saves an image to the file system and returns the public URL to access the image.
     *
     * @param file The image file to save.
     * @return The public URL to access the saved image.
     * @throws IOException If an error occurs while saving the image.
     */
    private String saveImageToFileSystem(MultipartFile file) throws IOException {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path targetLocation = rootLocation.resolve(fileName);
            file.transferTo(targetLocation.toFile());

            // Return the public URL of the file
            return serverHostUrl + "/uploads/" + fileName;  // Public URL that clients can use
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
