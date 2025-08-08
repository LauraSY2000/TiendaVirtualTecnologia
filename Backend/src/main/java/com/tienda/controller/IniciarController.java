package com.tienda.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IniciarController {

    @GetMapping("/")
    public String mostrarLogin() {
        return "login.html"; // Spring busca esto en /resources/static/
    }
}