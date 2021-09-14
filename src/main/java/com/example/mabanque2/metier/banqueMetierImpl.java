package com.example.mabanque2.metier;

import com.example.mabanque2.dao.CompteRepository;
import com.example.mabanque2.dao.OperationRepository;
import com.example.mabanque2.entities.Compte;
import com.example.mabanque2.entities.CompteCourant;
import com.example.mabanque2.entities.Operation;
import com.example.mabanque2.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class banqueMetierImpl implements IBanqueMetier {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Compte consulterCompte(String codeCpte) {
        return compteRepository.findById(codeCpte)
                .orElseThrow(() -> new RuntimeException("Compte Introuvable"));
    }

    @Override
    public void verser(String codeCpte, double montant) {
        Compte cp = consulterCompte(codeCpte);
        double faciliteCaisse = 0;
        if(cp instanceof CompteCourant ){
            faciliteCaisse = (((CompteCourant) cp).getDecouvert());
        }if(cp.getSolde() + faciliteCaisse < montant){
            throw new RuntimeException("Solde insuffisant");
        }
        Versement v = new Versement(new Date(), montant, cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde() + montant);
        compteRepository.save(cp);

    }

    @Override
    public void retirer(String codeCpte, double montant) {

    }

    @Override
    public void vierement(String codeCpte1, String codeCopte2, double montant) {
        retirer(codeCpte1, montant);
        verser(codeCopte2, montant);
    }

    @Override
    public Page<Operation> listOperation(String codeCpte, int page, int size) {
        return operationRepository.listOperation(codeCpte, PageRequest.of(page, size));
    }
}
