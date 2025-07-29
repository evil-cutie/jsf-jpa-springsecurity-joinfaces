package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.repository.ListingRepositoryInterface;
import com.pawfectbuddy.service.impl.UserServiceImpl;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
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
public class ListingController {

    @Autowired
    private ListingRepositoryInterface listingRepository;
    @Autowired
    private LoginBean loginBean;
    @Autowired
    private UserServiceImpl userService;
    private UploadedFile file;
    private Listing newListing = new Listing();
    private String imagePath;
    private final String FILE_PATH = "src/main/resources/META-INF/resources/images/";

    public void createListing() {
        newListing.setActive(true);
        newListing.setImage(imagePath);
        newListing.setUser(userService.findByUsername(loginBean.getUsername()));
        newListing.setUsername(loginBean.getUsername());
        listingRepository.save(newListing);
    }

    // upload image for a new listing
    public void upload() {
        if (file != null) {
            try {
                imagePath = FILE_PATH + generateUniqueFileName();
                File newFile = new File(imagePath);
                copyFile(newFile);
            } catch (IOException ex) {
                ex.printStackTrace();
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
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                is.close();
                os.close();
            }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
