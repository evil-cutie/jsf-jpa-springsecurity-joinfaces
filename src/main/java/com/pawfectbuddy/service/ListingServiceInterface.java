package com.pawfectbuddy.service;

import com.pawfectbuddy.model.entity.Animal;
import com.pawfectbuddy.model.entity.City;
import com.pawfectbuddy.model.entity.Listing;
import java.util.List;

public interface ListingServiceInterface {
    Listing createListing(Listing listing);

    Listing findByListingId(Long id);

    List<Listing> findByUserId(Long userId);

    List<Listing> getListings();

    List<Listing> getActiveListings();

    List<Listing> getActiveListingsByUserId(Long userId);

    List<Listing> getInactiveListingsByUserId(Long listingId);

    void delete(Listing listing);

    void updateDescription(Listing listing, String description);

    void updateStatus(Listing listing, boolean adopted);

    void updateLocation(Listing listing, City location);

    void updateTitle(Listing listing, String title);

    void updateAnimalType(Listing listing, Animal animal);

}
