package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.repository.ListingRepositoryInterface;
import com.pawfectbuddy.service.UserServiceInterface;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Component (value="listingMB")
@ViewScoped
public class ListingController implements Serializable {

    @Autowired
    private ListingRepositoryInterface listingRepository;
    @Autowired
    private LoginBean loginBean;
    @Autowired
    private UserServiceInterface userService;
    private UploadedFile file;
    private Listing newListing = new Listing();
    private String imagePath;
    private final String FILE_PATH = "src/main/resources/META-INF/resources/images/";

    public void createListing() {
        uploadImage();
        newListing.setActive(true);
        newListing.setImage(imagePath);
        newListing.setUser(userService.findByUsername(loginBean.getUsername()));
        newListing.setUsername(loginBean.getUsername());
        listingRepository.save(newListing);
    }

    // upload image for a new listing
    public void uploadImage() {
        if (file != null) {
            try {
                System.out.println("Started copying image");
                imagePath = FILE_PATH + generateUniqueFileName();
                File newFile = new File(imagePath);
                copyFile(newFile);
            } catch (IOException ex) {
                System.out.println("Cannot upload image" + ex.getMessage());
            }
        }
    }

    //each uploaded image should have a unique file path
    //all images are stored in images directory
    private String generateUniqueFileName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return "img_" + timestamp + ".png";
    }

    private void copyFile(File dest) throws IOException {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = file.getInputStream();
                os = new FileOutputStream(dest);
                System.out.println("Opened streams");
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                successfulUpload();
            } finally {
                is.close();
                os.close();
            }
    }

    public void successfulUpload() {
        System.out.println("Successfully uploaded image");
        FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
