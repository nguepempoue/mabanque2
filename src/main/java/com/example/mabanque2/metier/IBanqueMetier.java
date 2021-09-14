package com.example.mabanque2.metier;

import com.example.mabanque2.entities.Compte;
import com.example.mabanque2.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
    public Compte consulterCompte(String codeCpte);
    public void verser(String codeCpte, double montant);
    public void retirer(String codeCpte, double montant);
    public void vierement(String codeCpte1, String codeCopte2, double montant);
    public Page<Operation> listOperation(String codeCpte, int page, int size);
}
