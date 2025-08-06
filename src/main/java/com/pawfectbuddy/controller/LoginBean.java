package com.pawfectbuddy.controller;

import jakarta.faces.view.ViewScoped;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/**
 * A Login bean which stores user details after successful login
 * @author Xenia Levit
 */

@Component("loginMB")
@ViewScoped
public class LoginBean implements Serializable {

    public String getUsername() {
        Object userData = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userData instanceof UserDetails) return ((UserDetails) userData).getUsername();
        return userData.toString();
    }

}
