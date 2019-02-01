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
}
