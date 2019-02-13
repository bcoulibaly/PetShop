package com.ben.project.PetShop;

import javax.persistence.JoinColumn;

public class AnimalDTO {

    private int id;

    private String name;

    private int große;

    Client owner;

    public AnimalDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroße() {
        return große;
    }

    public void setGroße(int große) {
        this.große = große;
    }

    @JoinColumn(name = "id")
    public Client getOwner() {
        return this.owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
