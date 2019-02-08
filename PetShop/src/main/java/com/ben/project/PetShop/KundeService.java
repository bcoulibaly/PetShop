package com.ben.project.PetShop;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KundeService {
    
    private KundenRepository kundenRepo;
    private ArrayList<Kunde> listAllKunde;

    public KundeService() {
            
    }

    public ArrayList<Kunde> getAllKunde() {
        return (ArrayList<Kunde>) kundenRepo.findAll();
    }

    @Autowired
    public void setKudnenRepo(KundenRepository kundeRepo) {
        this.kundenRepo = kundeRepo;
    }
    
    public ArrayList<Kunde> getListAllKunde() {
        return listAllKunde;
    }

    public void setListAllKunde(ArrayList<Kunde> listAllKunde) {
        this.listAllKunde = listAllKunde;
    }
    
    public Kunde getKundeById(int kundeId) throws Exception {
        Kunde kunde = null;
        for (int i = 0; i < listAllKunde.size(); i++) {
            kunde = listAllKunde.get(i);
            if (kundeId == kunde.getkNr()) {
                return kunde;
            }
        }
        if (kunde != null) {
            return kunde;
        }
        else throw new Exception("Kunde nicht gefunden !!!") ;
    }
    
    public String addKunde(int id, String name, String anschrift) {
        Kunde kunde = new Kunde();
        kunde.setkNr(id);
        kunde.setkName(name);
        kunde.setkAnschrift(anschrift);
        
        listAllKunde.add(kunde);
        kundenRepo.saveAndFlush(kunde);
        
        if (kundenRepo.findAll().contains(kunde)) {
            return "SUCCESS";
        }
        else return "FAILED"; 
    }
}
