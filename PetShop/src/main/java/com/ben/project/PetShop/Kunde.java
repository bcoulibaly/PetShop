package com.ben.project.PetShop;


public class Kunde {
   
    private String kName;
    private int kNr;
    private String kAnschrift;
    
    Kunde(String name, int kundeNr, String anschrift){
        this.kName = name;
        this.kNr = kundeNr;
        this.kAnschrift = anschrift;
    }
    
    public String getkName() {
        return kName;
    }
    public void setkName(String kName) {
        this.kName = kName;
    }
    public int getkNr() {
        return kNr;
    }
    public void setkNr(int kNr) {
        this.kNr = kNr;
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
            if ((this.kNr == ((Kunde) obj).kNr) && ((this.kName == ((Kunde) obj).kName) && (this.kAnschrift== ((Kunde) obj).kAnschrift))) {
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
        return this.kNr;
    }
}
