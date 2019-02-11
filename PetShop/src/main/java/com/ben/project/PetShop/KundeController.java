package com.ben.project.PetShop;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kunde")
public class KundeController<ControllerService> {

    private KundeService kundeService;

    @Autowired
    public KundeController( KundeService kundeService) {
        this.setKundeService();
    }
    
    public void setKundeService() {
        this.kundeService = new KundeService();
    }


    @GetMapping("/{id}")
    public Kunde getKundeByName(@PathVariable int kundeId) throws Exception {
        return kundeService.getKundeById(kundeId);
    }
    
    @PostMapping("/addKunde")
    public String addKunde(@RequestBody Kunde newKunde, int id, String name, String anschrift) {
        return kundeService.addKunde(id, name, anschrift);
    }
    
    @GetMapping("/getallkunde")
    public ArrayList<Kunde> getAllKunde() {
        return kundeService.getAllKunde();
    }
    
//    @GetMapping("/kunde/{kundeName}/animalListe")
//    public ArrayList<Animals> getKundeAnimals(String kundeName) throws Exception {
//        Kunde tmpKunde = getKundeByName(kundeName);
//        if (tmpKunde != null) {
//            return tmpKunde.getKundeAnimal();
//        } else {
//            throw new Exception("Kunde konnte nicht gefunden werden");
//        }
//    }




//    @GetMapping("/Animal/{name}")
//    public Animals getAnimalsByName(@PathVariable String name) throws Exception {
//        Animals animal = null;
//        for (int j = 0; j < cService.getAnimalList().size(); j++) {
//            Animals tmpAnimals = cService.getAnimalList().get(j);
//            if (name.equals(tmpAnimals.getName())) {
//                animal = tmpAnimals;
//            }
//        }
//        if (animal != null) {
//            return animal;
//        } else {
//            throw new Exception("Tier konnte nicht gefunden werden");
//        }
//    }

//    @GetMapping("/Animals/")
//    public ArrayList<Animals> getAllAnimals() {
//        return cService.getAnimalList();
//    }
//
//    @PostMapping("/addAnimals")
//    public void addAnimal(@RequestBody Animals newAnimal) {
//        cService.getAnimalList().add(newAnimal);
//    }


}
