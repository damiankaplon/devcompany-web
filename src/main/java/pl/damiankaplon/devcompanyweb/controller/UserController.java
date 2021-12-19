package pl.damiankaplon.devcompanyweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.damiankaplon.devcompanyweb.model.Client;
import pl.damiankaplon.devcompanyweb.service.ClientService;

import java.security.Principal;

@Controller
public class UserController {

    private final ClientService clientService;

    public UserController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String defaultView(Principal principal, Model model) {
        return home(principal, model);
    }

    @GetMapping("/home")
    public String home(Principal principal, Model model){
        Client client = (Client) clientService.findByUsername(principal.getName());
        model.addAttribute("client", client);
        return "home";
    }
}
