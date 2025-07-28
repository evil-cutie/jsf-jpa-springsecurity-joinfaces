package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.repository.ListingRepositoryInterface;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component (value="listingMB")
public class ListingController {

    @Autowired
    private ListingRepositoryInterface listingRepository;
    private Listing newListing = new Listing();

    public void createListing() {
        newListing.setActive(true);
        newListing.setImage("/images/cat.png");
        listingRepository.save(newListing);
    }
}
