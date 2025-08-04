package com.pawfectbuddy.controller;

import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@Getter
@Setter
@Controller (value="home")
public class HomeController implements Serializable {

    @GetMapping("/")
    public String home() {
        return "index.xhtml";
    }

}