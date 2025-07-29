package com.pawfectbuddy.controller;

import com.pawfectbuddy.model.entity.Role;
import com.pawfectbuddy.model.entity.User;
import com.pawfectbuddy.repository.RoleRepositoryInterface;
import com.pawfectbuddy.service.UserServiceInterface;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Component(value = "userMB")
@ViewScoped
public class UserController implements Serializable {

    private final long ROLE_USER = 2L;
    @Autowired
    private UserServiceInterface userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepositoryInterface roleRepository;
    private User registrationUser = new User();
    private User user = new User();
    private List<User> users;

    public List<User> getUsers() {
        users = userService.findAll();
        return users;
    }

    public void register() throws IOException {
        if (userService.findByUsername(registrationUser.getUsername()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username Error","This username is already in use"));
        }
        else {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findById(ROLE_USER).get());
            registrationUser.setActive(true);
            registrationUser.setPassword(passwordEncoder.encode(registrationUser.getPassword()));
            registrationUser.setRoles(roles);
            userService.createUser(registrationUser);
            user = registrationUser;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Congrats!","Your account was created successfully"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("/profile.xhtml");
        }
    }

    public void delete() {
        if (user.getUserId() != null) {
            userService.deleteUser(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User deleted successfully"));
        }
    }
}