package com.example.mabanque2.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{

    private double taux;

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(String code, Date dateCreation, double solde, Client client, double taux) {
        super(code, dateCreation, solde, client);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}

