package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.service.AnimalServiceInterface;
import com.pawfectbuddy.service.CityServiceInterface;
import com.pawfectbuddy.service.ListingServiceInterface;
import com.pawfectbuddy.service.UserServiceInterface;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A Table View bean which has filter methods for the data which table represents.
 * It has access to User, Listing, Animal, City Services for fetching listings according to user request
 * @author Xenia Levit
 */

@Getter
@Setter
@Component(value="tableMB")
@ViewScoped
public class ListingView implements Serializable {

    @Autowired
    private ListingServiceInterface listingService;
    @Autowired
    private LoginBean loginBean;
    @Autowired
    private UserServiceInterface userService;
    @Autowired
    private AnimalServiceInterface animalService;
    @Autowired
    private CityServiceInterface cityService;
    private boolean active;
    private List<Listing> listings;
    private List<Listing> activeListings;
    private List<Listing> inactiveListings;
    private Listing listing;
    private List<String> animals;
    private List<String> cities;
    private List<String> selectedAnimals = new ArrayList<>();
    private List<String> selectedCities = new ArrayList<>();

    public List<Listing> getListings() {
        listings = listingService.getActiveListings();
        filterListings();
        return listings;
    }

    public List<Listing> getActiveListingsOfUser() {
        Long userId = userService.findByUsername(loginBean.getUsername()).getUserId();
        activeListings = listingService.getActiveListingsByUserId(userId);
        return activeListings;
    }

    public List<String> getAnimals() {
        animals = animalService.getAnimalNames();
        return animals;
    }

    public List<String> getCities() {
        cities = cityService.getCityNames();
        return cities;
    }

    public List<Listing> getInactiveListingsOfUser() {
        Long userId = userService.findByUsername(loginBean.getUsername()).getUserId();
        inactiveListings = listingService.getInactiveListingsByUserId(userId);
        return inactiveListings;
    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        PrimeFaces.current().multiViewState().clearAll(viewId, true, this::showMessage);
    }

    private void showMessage(String clientId) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
    }

    public void showPhoneNumber(Listing listing) {
        FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_INFO,"Hi! Glad you're interested in this adoption :) ",
                                            "Contact me for more details: " + listing.getPhone());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    // marking active = false to indicate that this listing is no longer available
    public void markAsAdopted(Listing listing) {
        listingService.updateStatus(listing, false);
    }

    public void deleteListing(Listing listing) {
        listingService.delete(listing);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Listing deleted"));
    }

    public void filterListings() {
        if(!selectedAnimals.isEmpty()) filterByAnimal(selectedAnimals);
        if(!selectedCities.isEmpty()) filterByCity(selectedCities);
    }

    public void filterByAnimal(List<String> animals) {
        List<Listing> filtered = new ArrayList<Listing>();
        for (String animal : animals) {
            for (Listing listing : listings) {
                if (animal.equals(listing.getAnimal().getType())) filtered.add(listing);
            }
        }
        listings = filtered;
    }

    public void filterByCity(List<String> cities) {
        List<Listing> filtered = new ArrayList<Listing>();
        for (String city : cities) {
            for (Listing listing : listings) {
                if (city.equals(listing.getCity().getName())) filtered.add(listing);
            }
        }
        listings = filtered;
    }

    public void onItemSelect(SelectEvent event) {
        String item = event.getObject().toString();
        if(animals.contains(item)) selectedAnimals.add(item);
        if(cities.contains(item)) selectedCities.add(item);
    }

    public void onItemUnselect(UnselectEvent event) {
        String item = event.getObject().toString();
        selectedAnimals.remove(item);
        selectedCities.remove(item);
    }

}