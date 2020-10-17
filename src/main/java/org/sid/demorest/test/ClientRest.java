package org.sid.demorest.test;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.sid.demorest.entities.Compte;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

public class ClientRest {
    public static void main(String[] args) throws IOException {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:8080").build();
        WebResource service=client.resource(uri);
        WebResource resource=service.path("banque").path("comptes");

        Compte cp = new Compte();
        cp.solde = 9999;
        cp.dateCreation= new Date();
        ObjectMapper mapper = new ObjectMapper();
        ClientResponse resp1=resource
                .accept("application/json").type("application/json")
                .post(ClientResponse.class,mapper.writeValueAsString(cp));

        System.out.println("status Code: "+resp1.getStatus());
        String corpsReponse = resp1.getEntity(String.class);
        System.out.println("Corps Réponse:"+corpsReponse);
        Compte cp1 = mapper.readValue(corpsReponse, Compte.class);
        System.out.println("Code"+cp1.code);
        System.out.println("Solde"+cp1.solde);
        System.out.println("Date Création"+cp1.dateCreation);

        String resp2 = resource.get(String.class);

        System.out.println(resp2);

        Compte[] comptes = mapper.readValue(resp2, Compte[].class);
        for(Compte c:comptes){
            System.out.println("----------------------------");
            System.out.println("Code"+cp1.code);
            System.out.println("Solde"+cp1.solde);
            System.out.println("Date Création"+cp1.dateCreation);
        }

        String resp3=resource.path("/4").get(String.class);
        System.out.println(resp3);
        Compte compte=mapper.readValue(resp3, Compte.class);
        System.out.println("--------------------------------------");
        System.out.println("Code"+cp1.code);
        System.out.println("Solde"+cp1.solde);
        System.out.println("Date Création"+cp1.dateCreation);

    }
}
