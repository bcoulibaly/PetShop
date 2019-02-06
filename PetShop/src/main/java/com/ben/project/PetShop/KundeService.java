package com.ben.project.PetShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KundeService {

    private Kunde kunde;

    public KundeService() {
        // TODO Auto-generated constructor stub
    }

    public Kunde getKunde() {
        return kunde;
    }

    @Autowired
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

}
