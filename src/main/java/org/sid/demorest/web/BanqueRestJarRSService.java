package org.sid.demorest.web;

import org.sid.demorest.dao.CompteRepository;
import org.sid.demorest.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
//@Component
@Path("/banque")
public class BanqueRestJarRSService {
    @Autowired
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    }

    @Path("/comptes/{code}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte getCompte(@PathParam(value = "code") Long code){
        return compteRepository.findById(code).get();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }

    @Path("/comptes/{code}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte update(@PathParam(value = "code") Long code,Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{code}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void delete(@PathParam(value = "code") Long code){
        compteRepository.deleteById(code);

    }

}
