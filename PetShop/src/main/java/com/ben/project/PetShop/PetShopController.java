package com.ben.project.PetShop;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetShopController {

    private ControllerService cService;

    @Autowired
    public PetShopController(ControllerService service) {
        this.cService = service;
    }

    @GetMapping("/Animals/{id}")
    public Animals getAnimalsById(@PathVariable int id) {
        for (int j = 0; j < cService.getAnimalList().size(); j++) {
            Animals tmpAnimal = cService.getAnimalList().get(j);
            if (id == tmpAnimal.getId()) {
                return tmpAnimal;
            }
        }
        return null;
    }

    @GetMapping("/Animal/{name}")
    public Animals getAnimalsByName(@PathVariable String name) {
        for (int j = 0; j < cService.getAnimalList().size(); j++) {
            Animals tmpAnimal = cService.getAnimalList().get(j);
            if (name.equals(tmpAnimal.getName())) {
                return tmpAnimal;
            }
        }
        return null;
    }

    @GetMapping("/Animals/")
    public ArrayList<Animals> getAllAnimals() {
        return cService.getAnimalList();
    }

    @PostMapping("/addAnimals")
    public void addAnimal(@RequestBody Animals newAnimal) {
        cService.getAnimalList().add(newAnimal);
    }

    @GetMapping("/Kunde/{name}")
    public Kunde getKundeByName(@PathVariable String name) {
        for (int j = 0; j < cService.getKundeList().size(); j++) {
            Kunde tmpkunde = cService.getKundeList().get(j);
            if (name.equals(tmpkunde.getkName())) {
                return tmpkunde;
            }
        }
        return null;
    }

    @PostMapping("/addKunde")
    public void addKunde(@RequestBody Kunde newKunde) {
        cService.getKundeList().add(newKunde);
    }

    @GetMapping("/")
    public ArrayList<Kunde> getAllKunde() {
        return cService.getKundeList();
    }

    public void shop(Kunde kundeName, String animalName) {
        kundeName.getKundeAnimal().add(getAnimalsByName(animalName));
    }

    public ArrayList<Animals> getKundeAnimals(Kunde kunde) {
        return kunde.getKundeAnimal();
    }

}
