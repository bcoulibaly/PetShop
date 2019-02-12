package com.ben.project.PetShop;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService kundeService) {
        this.clientService = kundeService;
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable int clientId) throws Exception {
        Client client = clientService.getClientById(clientId);
        if (client != null) {
            return client;
        } else {
            throw new Exception("Client was not found");
        }
    }

    @PostMapping()
    public Client addClient(@RequestBody Client client) throws Exception {
        Client tmpClient = clientService.addClient(client);
        if (tmpClient != null) {
            return tmpClient;
        } else {
            throw new Exception("Client cannot be added");
        }
    }

    @GetMapping()
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

}
