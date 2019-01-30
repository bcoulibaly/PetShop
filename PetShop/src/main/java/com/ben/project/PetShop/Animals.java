package com.ben.project.PetShop;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Animals {

    private int id;
    private String name;
    private int große;

    private List<Animals> listAnimals = Arrays.asList(new Animals(1, "Bijou", 25), new Animals(2, "Milou", 60), new Animals(3, "Ragou", 70));

    public Animals(int id, String name, int große) {
        this.id = id;
        this.name = name;
        this.große = große;
    }

    public Animals() {
        // TODO Auto-generated constructor stub
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

    @GetMapping
    public String getAnimalsById(@Value(value = "id") int id) {
        for (int j = 0; j < listAnimals.size(); j++) {
            if (id == listAnimals.get(j).getId()) {
                return listAnimals.get(j).getName();
            }
        }
        return null;
    }
}
