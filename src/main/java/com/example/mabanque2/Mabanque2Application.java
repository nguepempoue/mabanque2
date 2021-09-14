package com.example.mabanque2;

import com.example.mabanque2.dao.ClientRepository;
import com.example.mabanque2.dao.CompteRepository;
import com.example.mabanque2.dao.OperationRepository;
import com.example.mabanque2.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Mabanque2Application implements CommandLineRunner{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository;

    public static void main(String[] args){
        SpringApplication.run(Mabanque2Application.class, args);
        System.out.println("bonjour le grand julio");
    }

    @Override
    public void run(String... args) throws Exception {
        Client c1 = clientRepository.save(new Client("Tano","tano@tano.com"));
        Client c2 = clientRepository.save(new Client("julio","julio@julio.com"));

        Compte cp1 = compteRepository.save(new CompteCourant("cp1", new Date(), 90000, c1, 6000));
        Compte cp2 = compteRepository.save(new CompteEpargne("cp2", new Date(), 10000, c2, 5.5));

        Operation op1 = operationRepository.save(new Versement(new Date(), 9000, cp1));
        Operation op2 = operationRepository.save(new Versement(new Date(), 6000, cp1));
        Operation op3 = operationRepository.save(new Retrait(new Date(), 6000, cp1));
        Operation op4 = operationRepository.save(new Retrait(new Date(), 9000, cp1));

        Operation op5 = operationRepository.save(new Versement(new Date(),900, cp2 ));
        Operation op6 = operationRepository.save(new Versement(new Date(), 600, cp2));
        Operation op7 = operationRepository.save(new Retrait(new Date(), 600, cp2));
        Operation op8 = operationRepository.save(new Retrait(new Date(), 900, cp2));
    }
}
