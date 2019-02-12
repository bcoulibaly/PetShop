package com.ben.project.PetShop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Animal")
public class Animal {

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Größe")
    private int große;

    public Animal() {
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

    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null) {
            return false;
        } else if (this.getClass() == obj.getClass()) {
            if ((this.id == ((Animal) obj).id) && ((this.name == ((Animal) obj).name) && (this.große == ((Animal) obj).große))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hc = 17;
        int hashMultiplier = 59;
        hc = hc * hashMultiplier + ((this == null) ? 0 : this.id);
        return hc;
    }
}
