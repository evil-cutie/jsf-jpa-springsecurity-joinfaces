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
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Component(value = "userMB") //spring managed bean
@ViewScoped //need for ajax
public class UserController implements Serializable {

    @Autowired
    private UserServiceInterface userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepositoryInterface roleRepository;
    private User user;
    private User registrationUser = new User();
    private List<User> users;

    public List<User> getUsers() {
        users = userService.findAll();
        return users;
    }

    public void register() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(2L).get());
        registrationUser.setActive(true);
        registrationUser.setPassword(passwordEncoder.encode(registrationUser.getPassword()));
        registrationUser.setRoles(roles);
        userService.createUser(registrationUser);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User saved successfully"));
    }

    public void save() {
        if (user.getUserId() == null) {
            userService.createUser(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User saved successfully"));
        }
        else {
            userService.updateUser(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User updated successfully"));
        }
        newUser();
        PrimeFaces.current().ajax().update("form:messages");
    }

    public void newUser() {
        user = new User();
    }

    public void delete() {
        if (user.getUserId() != null) userService.deleteUser(user);
    }
}