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
    private AnimalController animalController;

    public ClientController(ClientService kundeService, AnimalController animalController) {
        this.clientService = kundeService;
        this.animalController = animalController;
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
    public ArrayList<ClientDTO> getAllClient() throws Exception {

        List<Client> clientEntityList = clientService.getAllClient();

        if (clientEntityList != null) {
            ArrayList<ClientDTO> clientDtoList = new ArrayList<ClientDTO>();
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

        Animal animalEntity = convertToAnimalEntity(animalController.getAnimalById(animalDto.getId()));
        ClientDTO clientDto = convertToClientDTO(clientService.addAnimalToClient(id, animalEntity));

        return clientDto;
    }

    public Client convertToClientEntity(ClientDTO clientDTO) {

        Client clientEntity = new Client();
        clientEntity.setId(clientDTO.getId());
        clientEntity.setName(clientDTO.getName());
        clientEntity.setAnschrift(clientDTO.getAnschrift());
        clientEntity.setAnimals(convertToAnimalsList(clientDTO.getAnimals()));

        return clientEntity;
    }

    public ClientDTO convertToClientDTO(Client clientEntity) {

        ClientDTO clientDto = new ClientDTO();
        clientDto.setId(clientEntity.getId());
        clientDto.setName(clientEntity.getName());
        clientDto.setAnschrift(clientEntity.getAnschrift());
        clientDto.setAnimals(convertToAnimalsDTOList(clientEntity.getAnimals(), clientDto.getId()));

        return clientDto;
    }

    public AnimalDTO convertToAnimalDTO(Animal animalEntity, int i) {

        AnimalDTO animalDto = animalController.convertToAnimalDTO(animalEntity);
        animalDto.setOwner(i);

        return animalDto;
    }

    public Animal convertToAnimalEntity(AnimalDTO animalDto) {
        return animalController.convertToAnimalEntity(animalDto);
    }

    public ArrayList<AnimalDTO> convertToAnimalsDTOList(List<Animal> animals, int i) {

        if (animals != null) {
            ArrayList<AnimalDTO> animalFormat = new ArrayList<AnimalDTO>();

            for (Animal animal : animals) {
                animalFormat.add(convertToAnimalDTO(animal, i));
            }
            return animalFormat;
        } else {
            return null;
        }
    }

    public ArrayList<Animal> convertToAnimalsList(List<AnimalDTO> animals) {

        if (animals != null) {
            ArrayList<Animal> animalFormat = new ArrayList<Animal>();

            for (AnimalDTO animal : animals) {
                animalFormat.add(convertToAnimalEntity(animal));
            }
            return animalFormat;
        } else {
            return null;
        }
    }
}
