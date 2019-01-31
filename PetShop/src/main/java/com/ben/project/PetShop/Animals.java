package com.ben.project.PetShop;

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

    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null) {
            return false;
        } else if (this.getClass() == obj.getClass()) {
            if ((this.id == ((Animals) obj).id) && ((this.name == ((Animals) obj).name) && (this.große == ((Animals) obj).große))) {
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

    public String getAninmals() {
        return "Id = " + this.id + "\rName = " + this.name + "\rGröße = " + this.große;
    }
}
