package com.ben.project.PetShop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public AnimalDTO getAnimalById(@PathVariable int id) throws Exception {
        Animal animal = animalService.getAnimalById(id);
        if (animal != null) {
            return convertToAnimalDTO(animal);
        } else {
            throw new Exception("can't find Animal with this id");
        }
    }

    @GetMapping()
    public ArrayList<AnimalDTO> getAllAnimals() throws Exception {

        List<Animal> animalList = animalService.getAllAnimals();

        if (!animalList.isEmpty()) {
            ArrayList<AnimalDTO> animalDto = new ArrayList<AnimalDTO>();
            for (Animal animal : animalService.getAllAnimals()) {
                animalDto.add(convertToAnimalDTO(animal));
            }
            return animalDto;
        } else {
            throw new Exception("There are no Entity of Animal ini the Database");
        }
    }

    @PostMapping()
    public AnimalDTO addAnimal(@RequestBody AnimalDTO animal) throws Exception {
        Animal tmpAnimal = animalService.addAnimal(convertToAnimalEntity(animal));
        if (tmpAnimal != null) {
            return convertToAnimalDTO(tmpAnimal);
        } else {
            throw new Exception("Animal can't be added into the Database");
        }
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
