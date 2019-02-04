package com.ben.project.PetShop;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ControllerService {

    private ArrayList<Animals> animalList;
    private ArrayList<Kunde> kundeList;

    public ControllerService() {
        this.animalList = new ArrayList<>();
        this.kundeList = new ArrayList<>();
    }

    public ArrayList<Kunde> getKundeList() {
        return kundeList;
    }

    public void setKundeList(ArrayList<Kunde> kundeList) {
        this.kundeList = kundeList;
    }

    public ArrayList<Animals> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<Animals> animalList) {
        this.animalList = animalList;
    }

}
