package com.pawfectbuddy.service;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.model.entity.User;

import java.util.List;

public interface ListingServiceInterface {
    Listing createListing(Listing listing);
    Listing findByListingId(Long id);
    List<Listing> findByUserId(Long userId);
    List<Listing> getListings();
    void delete(Listing listing);
    void updateDescription(Listing listing, String description);
    void updateStatus(Listing listing, boolean adopted);
    void updateLocation(Listing listing, String location);
    void updateName(Listing listing, String name);
}
