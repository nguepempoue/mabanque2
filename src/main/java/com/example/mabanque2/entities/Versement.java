package com.example.mabanque2.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Optional;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{

    public Versement() {
        super();
    }

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }



}

