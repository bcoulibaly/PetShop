package com.ben.project.PetShop;

import org.springframework.stereotype.Component;

@Component
public class Animals {

    private int id;
    private String name;
    private int große;

    public Animals(int id, String name, int große) {
        this.id = id;
        this.name = name;
        this.große = große;
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
}
