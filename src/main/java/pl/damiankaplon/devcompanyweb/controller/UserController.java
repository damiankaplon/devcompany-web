package pl.damiankaplon.devcompanyweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @GetMapping("start")
    public String hello(){
        return "hello";
    }
    @GetMapping("hello")
    public String hello2(){
        return "hello";
    }
}
