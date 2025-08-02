package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.repository.ListingRepositoryInterface;
import com.pawfectbuddy.service.AnimalServiceInterface;
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
    private AnimalServiceInterface animalService;
    @Autowired
    private LoginBean loginBean;
    @Autowired
    private UserServiceInterface userService;
    private UploadedFile file;
    private Listing newListing = new Listing();
    private String imagePath;
    private final String NO_IMAGE = "/images/no_image.png";
    private final String FULL_PATH = "src/main/resources/META-INF/resources/images/";

    public void createListing() throws IOException {
        newListing.setActive(true);
        newListing.setImage(uploadImage());
        newListing.setUser(userService.findByUsername(loginBean.getUsername()));
        newListing.setUsername(loginBean.getUsername());
        listingRepository.save(newListing);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Congrats!","Listing was created!"));
        FacesContext.getCurrentInstance().getExternalContext().redirect("/profile.xhtml");
    }

    // upload image for a new listing and return new image path to store in database
    // if no file attached return default no avatar image
    public String uploadImage() {
        if (file != null) {
            try {
                String uniqueName = generateUniqueFileName();
                String shortImagePath = "/images/" + uniqueName;
                imagePath = FULL_PATH + uniqueName;
                File newFile = new File(imagePath);
                copyFile(newFile);
                return shortImagePath;
            } catch (IOException ex) {
                System.out.println("ERROR: image upload failed" + ex.getMessage());
            }
        }
        return NO_IMAGE;
    }

    //each uploaded image should have a unique file path thus file name is generated with timestamp
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
        FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
