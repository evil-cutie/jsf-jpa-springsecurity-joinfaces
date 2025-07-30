package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.service.ListingServiceInterface;
import com.pawfectbuddy.service.UserServiceInterface;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.List;

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
    private List<Listing> listings;
    private List<Listing> listingsOfUser;
    private Listing listing;

    public List<Listing> getListings() {
        listings = listingService.getListings();
        return listings;
    }

    public List<Listing> getListingsOfUser() {
        Long userId = userService.findByUsername(loginBean.getUsername()).getUserId();
        listingsOfUser = listingService.findByUserId(userId);
        return listingsOfUser;
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

    public void showPhoneNumber() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contact me via: ", listing.getPhone());
        System.out.println("Pressed on command button");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}