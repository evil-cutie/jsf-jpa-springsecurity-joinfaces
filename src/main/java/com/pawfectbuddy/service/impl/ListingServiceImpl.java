package com.pawfectbuddy.service.impl;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.repository.ListingRepositoryInterface;
import com.pawfectbuddy.service.ListingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingServiceInterface {

    @Autowired
    private ListingRepositoryInterface listingRepository;

    @Override
    public Listing createListing(Listing listing) { return listingRepository.save(listing); }

    @Override
    public Listing findByListingId(Long id) { return listingRepository.findById(id).orElse(null); }

    @Override
    public List<Listing> findByUserId(Long userId) { return null; }

    @Override
    public List<Listing> getListings() { return (List<Listing>) listingRepository.findAll(); }

    @Override
    public void delete(Listing listing) { listingRepository.delete(listing); }

    @Override
    public void updateDescription(Listing listing, String description) {
        listing.setDescription(description);
        listingRepository.save(listing);
    }

    @Override
    public void updateStatus(Listing listing, boolean active) {
        listing.setActive(active);
        listingRepository.save(listing);
    }

    @Override
    public void updateLocation(Listing listing, String location) {
        listing.setLocation(location);
        listingRepository.save(listing);
    }

    @Override
    public void updateName(Listing listing, String name) {
        listing.setName(name);
        listingRepository.save(listing);
    }
}
