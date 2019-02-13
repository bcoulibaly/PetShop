package com.ben.project.PetShop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.BeanUtils;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService kundeService) {
        this.clientService = kundeService;
    }

    @GetMapping("/{clientId}")
    public ClientDTO getClientById(@PathVariable int clientId) throws Exception {
        Client client = clientService.getClientById(clientId);

        ClientDTO clientDto = convertToClientDTO(client);

        if (clientDto != null) {
            return clientDto;
        } else {
            throw new Exception("Client was not found");
        }
    }

    @PostMapping()
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) throws Exception {

        Client clientEntity = convertToClientEntity(clientDTO);
        clientEntity = clientService.addClient(clientEntity);
        if (clientEntity != null) {
            return convertToClientDTO(clientEntity);
        } else {
            throw new Exception("Client cannot be added");
        }
    }

    @GetMapping()
    public List<ClientDTO> getAllClient() throws Exception {

        List<Client> clientEntityList = clientService.getAllClient();

        if (clientEntityList != null) {
            List<ClientDTO> clientDtoList = new ArrayList<ClientDTO>();
            for (Client client : clientEntityList) {
                clientDtoList.add(convertToClientDTO(client));
            }
            return clientDtoList;
        } else {
            throw new Exception(" No Client avaible");
        }
    }

    @PutMapping("/{id}")
    public ClientDTO addAnimalToClient(@PathVariable int id, @RequestBody AnimalDTO animalDto) throws Exception {
        Animal animalEntity = convertToAnimalEntity(animalDto);

        return convertToClientDTO(clientService.addAnimalToClient(id, animalEntity));
    }

    public Client convertToClientEntity(ClientDTO clientDTO) {

        Client clientEntity = new Client();
        clientEntity.setId(clientDTO.getId());
        clientEntity.setName(clientDTO.getName());
        clientEntity.setAnschrift(clientDTO.getAnschrift());
        clientEntity.setAnimals(clientDTO.getAnimals());

        return clientEntity;
    }

    public ClientDTO convertToClientDTO(Client clientEntity) {

        ClientDTO clientDto = new ClientDTO();
        clientDto.setId(clientEntity.getId());
        clientDto.setName(clientEntity.getName());
        clientDto.setAnschrift(clientEntity.getAnschrift());
        clientDto.setAnimals(clientEntity.getAnimals());

        return clientDto;
    }

    public AnimalDTO convertToAnimalDTO(Animal animalEntity) {

        AnimalDTO animalDto = new AnimalDTO();
        animalDto.setId(animalEntity.getId());
        animalDto.setName(animalEntity.getName());
        animalDto.setGroße(animalEntity.getGroße());
        return animalDto;
    }

    public Animal convertToAnimalEntity(AnimalDTO animalDto) {

        Animal animalEntity = new Animal();
        animalEntity.setId(animalDto.getId());
        animalEntity.setName(animalDto.getName());
        animalEntity.setGroße(animalDto.getGroße());
        return animalEntity;
    }

}
