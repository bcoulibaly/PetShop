package com.ben.project.PetShop;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KundeService {

    private KundenRepository kundenRepo;

    public KundeService(KundenRepository kundenRepo) {
        this.setKudnenRepo(kundenRepo);
    }

    public ArrayList<Kunde> getAllKunde() {
        return (ArrayList<Kunde>) kundenRepo.findAll();
    }

    @Autowired
    public void setKudnenRepo(KundenRepository kundenRepo) {
        this.kundenRepo = kundenRepo;
    }

    public Kunde getKundeById(int kundeId) throws Exception {
        Kunde kunde = kundenRepo.getOne(kundeId);
        if (kunde != null) {
            return kunde;
        } else {
            return null;
        }
    }

    public Kunde addKunde(int id, String name, String anschrift) {

        Kunde kunde = new Kunde();
        kunde.setkNr(id);
        kunde.setkName(name);
        kunde.setkAnschrift(anschrift);

        kundenRepo.save(kunde);
        if (kundenRepo.findAll().contains(kunde)) {
            return kunde;
        } else {
            return null;
        }
    }
}
