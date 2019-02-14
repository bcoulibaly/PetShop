package com.ben.project.PetShop;

import java.util.List;

public class ClientDTO {

    private int id;

    private String name;

    private String anschrift;

    private List<AnimalDTO> animals;

    ClientDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String kName) {
        this.name = kName;
    }

    public int getId() {
        return id;
    }

    public void setId(int kId) {
        this.id = kId;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String kAnschrift) {
        this.anschrift = kAnschrift;
    }

    public List<AnimalDTO> getAnimals() {
        return this.animals;
    }

    public void setAnimals(List<AnimalDTO> animals) {
        this.animals = animals;
    }
}
