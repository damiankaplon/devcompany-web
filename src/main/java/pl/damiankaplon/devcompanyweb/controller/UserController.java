package pl.damiankaplon.devcompanyweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.damiankaplon.devcompanyweb.model.Client;
import pl.damiankaplon.devcompanyweb.model.Sale;
import pl.damiankaplon.devcompanyweb.service.ClientService;
import pl.damiankaplon.devcompanyweb.service.SaleService;
import pl.damiankaplon.devcompanyweb.service.exception.NoClientsFound;
import pl.damiankaplon.devcompanyweb.service.exception.NotSpecifiedReqArgs;

import java.security.Principal;

@Controller
public class UserController {

    private final ClientService clientService;
    private final SaleService saleService;

    public UserController(ClientService clientService, SaleService saleService) {
        this.clientService = clientService;
        this.saleService = saleService;
    }

    @GetMapping("/")
    public String defaultView(Principal principal, Model model) {
        return home(principal, model);
    }

    @GetMapping("/list-invoices")
    public String listInvoices(Principal principal, Model model) throws NoClientsFound, NotSpecifiedReqArgs {
        Client client = (Client) clientService.findByUsername(principal.getName());
        model.addAttribute("invoices", saleService.getSalesByClient(client));
        return "list-invoices";
    }

    @GetMapping("list/details/{id}")
    public String showInvoiceDetails(@PathVariable Long id, Principal principal, Model model) {
        Sale sale = saleService.getSaleById(id);
        model.addAttribute("invoice", sale);
        return "invoice-details";
    }


    @GetMapping("/home")
    public String home(Principal principal, Model model){
        Client client = (Client) clientService.findByUsername(principal.getName());
        model.addAttribute("client", client);
        return "home";
    }
}
