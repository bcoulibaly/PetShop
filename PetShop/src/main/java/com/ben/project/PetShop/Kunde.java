package com.ben.project.PetShop;

import java.util.ArrayList;

import javax.persistence.*;


@Entity
@Table(name = "kunde")
public class Kunde {

    @Id
    @Column(name = "id")
    private int kId;

    @Column(name = "name")
    private String kName;

    @Column(name = "anschrift")
    private String kAnschrift;

    // @Column(name = "Tier")
    private ArrayList<Animals> kundeAnimals;

    Kunde() {
    }

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }

    public int getkNr() {
        return kId;
    }

    public void setkNr(int kId) {
        this.kId = kId;
    }

    public String getkAnschrift() {
        return kAnschrift;
    }

    public void setkAnschrift(String kAnschrift) {
        this.kAnschrift = kAnschrift;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null) {
            return false;
        } else if (this.getClass() == obj.getClass()) {
            if ((this.kId == ((Kunde) obj).kId) && ((this.kName == ((Kunde) obj).kName) && (this.kAnschrift == ((Kunde) obj).kAnschrift))) {
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
        return this.kId;
    }

    public ArrayList<Animals> getKundeAnimal() {
        return kundeAnimals;
    }

    public void setKundeAnimals(ArrayList<Animals> kundeAnimals) {
        this.kundeAnimals = kundeAnimals;
    }
}
