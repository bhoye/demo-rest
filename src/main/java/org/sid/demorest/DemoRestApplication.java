package org.sid.demorest;

import org.sid.demorest.entities.Compte;
import org.sid.demorest.dao.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class DemoRestApplication implements CommandLineRunner {
   // @Autowired
    private CompteRepository compteRepository;
    public static void main(String[] args) {

        SpringApplication.run(DemoRestApplication.class, args);
    }

   // @Override
    public void run(String... args) throws Exception {
        compteRepository.save(new Compte(null,9000,new Date(),"courant"));
        compteRepository.save(new Compte(null,1200,new Date(),"courant"));
        compteRepository.save(new Compte(null,8000,new Date(),"epargne"));
        compteRepository.findAll().forEach(cp->{
            System.out.println(cp.toString());
        });
    }
}
