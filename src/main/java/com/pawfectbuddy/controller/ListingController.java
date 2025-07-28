package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.repository.ListingRepositoryInterface;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component (value="listingMB")
@ViewScoped
public class ListingController {

    @Autowired
    private ListingRepositoryInterface listingRepository;
    @Autowired
    private LoginBean loginBean;
    private Listing newListing = new Listing();

    public void createListing() {
        newListing.setActive(true);
        newListing.setImage("/images/cat.png");
        newListing.setUsername(loginBean.getUsername());
        listingRepository.save(newListing);
    }
}
