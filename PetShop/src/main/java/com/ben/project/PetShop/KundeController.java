package com.ben.project.PetShop;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kunde")
public class KundeController {

    private KundeService kundeService;

    @Autowired
    public KundeController(KundeService kundeService) {
        this.setKundeService(kundeService);
    }

    public void setKundeService(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping("/{kundeId}")
    public Kunde getKundeById(@PathVariable int kundeId) throws Exception {
        Kunde kunde = kundeService.getKundeById(kundeId);
        if (kunde != null) {
            return kunde;
        } else {
            throw new Exception("Kunde ist nicht gefunden");
        }
    }

    @PostMapping("/addKunde")
    public Kunde addKunde(int id, String name, String anschrift) throws Exception {
        Kunde kunde = kundeService.addKunde(id, name, anschrift);
        if (kunde != null) {
            return kunde;
        } else {
            throw new Exception("Der kunde konnte nicht hinzugefügt werden");
        }
    }

    @GetMapping("/getallkunde")
    public ArrayList<Kunde> getAllKunde() {
        return kundeService.getAllKunde();
    }

}
