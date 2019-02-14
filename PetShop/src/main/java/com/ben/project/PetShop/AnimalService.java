package com.ben.project.PetShop;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimalById(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal addAnimal(Animal animalToBeAdd) {
        if (!animalRepository.findAll().contains(animalToBeAdd)) {
            return animalRepository.save(animalToBeAdd);
        } else {
            return animalToBeAdd;
        }
    }
}
