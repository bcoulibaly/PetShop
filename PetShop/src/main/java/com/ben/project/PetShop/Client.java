package com.ben.project.PetShop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kunde")
public class Client {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "anschrift")
    private String anschrift;

    Client() {
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

    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null) {
            return false;
        } else if (this.getClass() == obj.getClass()) {
            if ((this.id == ((Client) obj).id) && ((this.name == ((Client) obj).name) && (this.anschrift == ((Client) obj).anschrift))) {
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
        return this.id;
    }
}
