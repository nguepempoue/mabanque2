package com.example.mabanque2.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
    private double decouvert;

    public CompteCourant() {
        super();
    }

    public CompteCourant(double decouvert) {
        this.decouvert = decouvert;
    }

    public CompteCourant(String code, Date dateCreation, double solde, Client client, double decouvert) {
        super(code, dateCreation, solde, client);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}

