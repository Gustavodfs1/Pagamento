package br.com.markercode.restclient;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


import br.com.markercode.model.DadoPagamento;

@RegisterRestClient(configKey="cliente-api")
public interface ClienteRestClient {



    @GET
    @Path("/dados-pagamento-cliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
     DadoPagamento buscarDados(@PathParam("id") Long id);
    
}