package com.ben.project.PetShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetShopController {

    private List<Animals> listAnimals = new ArrayList<>(Arrays.asList(new Animals(1, "Bijou", 25), new Animals(2, "Milou", 60), new Animals(3, "Ragou", 70)));
    private List<Kunde> listKunde = new ArrayList<>(Arrays.asList(new Kunde("Marina", 12, "Helvetik Straße 45"), new Kunde("Milou", 60, "Buschhöhe 2"), new Kunde("Ragou", 70,"Horn Lehe 78")));
    
    @GetMapping("/Animals/{id}")
    public Animals getAnimalsById(@PathVariable int id) {
        for (int j = 0; j < listAnimals.size(); j++) {
            if (id == listAnimals.get(j).getId()) {
                return listAnimals.get(j);
            }
        }
        return null;
    }

    @GetMapping("/Animals/")
    public List<Animals> getAllAnimals() {
        return listAnimals;
    }

    @PostMapping("/Animals/{id}/{change}")
    public Animals changeAnimalId(@PathVariable int id, @PathVariable int change) {
        for (int i = 0; i < listAnimals.size(); i++) {
            Animals animals = listAnimals.get(i);
            if (id == animals.getId()) {
                animals.setId(change);
                return animals;
            }
        }
        return null;
    }

    @PostMapping("/addAnimals")
    public void addAnimal(@RequestBody Animals newAnimal) {
        listAnimals.add(newAnimal);
    }
    
    @GetMapping("/Kunde/{name}")
    public Kunde getKundeByName(@PathVariable String name) {
        for (int j = 0; j < listKunde.size(); j++) {
            if (name.equals(listKunde.get(j).getkName())) {
                return listKunde.get(j);
            }
        }
        return null;
    }
    
    @PostMapping("/addKunde/")
    public void addKunde(@RequestBody Kunde newKunde) {
        listKunde.add(newKunde);
    }
}
