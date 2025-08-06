package com.pawfectbuddy.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.Serializable;

/**
 * Home Controller for mapping localhost:8080/ to index.xhtml
 * @author Xenia Levit
 */

@Getter
@Setter
@Controller (value="home")
public class HomeController implements Serializable {

    @GetMapping("/")
    public String home() {
        return "index.xhtml";
    }

}