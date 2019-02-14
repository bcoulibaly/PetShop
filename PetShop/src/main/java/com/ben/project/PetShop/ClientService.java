package com.ben.project.PetShop;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> getAllClient() {
        return clientRepo.findAll();
    }

    public Client getClientById(int clientId) throws Exception {
        return clientRepo.findById(clientId).orElse(null);
    }

    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    public Client addAnimalToClient(int idClient, Animal animal) {
        Client tmpClient = clientRepo.findById(idClient).get();
        animal.setOwner(tmpClient);
        tmpClient.getAnimals().add(animal);

        clientRepo.saveAndFlush(tmpClient);
        return tmpClient;
    }
}
