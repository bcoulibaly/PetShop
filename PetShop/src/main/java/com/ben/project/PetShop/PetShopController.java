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

    @GetMapping("/Animal/{name}")
    public Animals getAnimalsByName(@PathVariable String name) throws Exception {
        Animals animal = null;
        for (int j = 0; j < cService.getAnimalList().size(); j++) {
            Animals tmpAnimals = cService.getAnimalList().get(j);
            if (name.equals(tmpAnimals.getName())) {
                animal = tmpAnimals;
            }
        }
        if (animal != null) {
            return animal;
        } else {
            throw new Exception("Tier konnte nicht gefunden werden");
        }
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
    public Kunde getKundeByName(@PathVariable String name) throws Exception {

        Kunde tmpKunde = null;
        for (int j = 0; j < cService.getKundeList().size(); j++) {
            tmpKunde = cService.getKundeList().get(j);
            if (name.equals(tmpKunde.getkName())) {
                break;
            }
        }

        if (tmpKunde != null) {
            return tmpKunde;
        } else {
            throw new Exception("Kunde konnte nicht gefunden werden");
        }
    }

    @PostMapping("/addKunde")
    public void addKunde(@RequestBody Kunde newKunde) {
        cService.getKundeList().add(newKunde);
    }

    @GetMapping("/Kunde")
    public ArrayList<Kunde> getAllKunde() {
        return cService.getKundeList();
    }

    public void shop(@PathVariable String kundeName, String animalName) throws Exception {
        this.getKundeByName(kundeName).getKundeAnimal().add(getAnimalsByName(animalName));
    }

    @GetMapping("/kunde/{kundeName}/animalListe")
    public ArrayList<Animals> getKundeAnimals(String kundeName) throws Exception {
        Kunde tmpKunde = getKundeByName(kundeName);
        if (tmpKunde != null) {
            return tmpKunde.getKundeAnimal();
        } else {
            throw new Exception("Kunde konnte nicht gefunden werden");
        }
    }

}
