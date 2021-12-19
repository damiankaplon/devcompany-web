package pl.damiankaplon.devcompanyweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
public class UserController {
    @GetMapping("/home")
    public String login(){
        return "home";
    }
}
