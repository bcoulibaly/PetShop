package com.ben.project.PetShop;

public class AnimalDTO {

    private int id;

    private String name;

    private int große;

    private int owner_Id;

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

    public int getOwner() {
        return this.owner_Id;
    }

    public void setOwner(int owner_Id) {
        this.owner_Id = owner_Id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + große;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + owner_Id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AnimalDTO other = (AnimalDTO) obj;
        if (große != other.große) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (owner_Id != other.owner_Id) {
            return false;
        }
        return true;
    }

}
