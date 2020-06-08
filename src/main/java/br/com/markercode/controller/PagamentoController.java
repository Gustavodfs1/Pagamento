package br.com.markercode.controller;
import java.util.List;
import br.com.markercode.model.Pagamento;
import br.com.markercode.service.PagamentoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/pagamento/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "pagamento ", description = "Operations on pagamento  resource.")
public class PagamentoController {


     @Inject
     PagamentoService pagamentoService;

    @GET
    @Operation(summary = "Listar todos os pagamentos ")
    public List<Pagamento> get() {
        return Pagamento.listAll();
    }

    @POST
    @Path("processar-pagamento/{id}/{valor}/")
    @Transactional
    @APIResponse(responseCode = "201",
            description = "pagamento created",
            content = @Content(schema = @Schema(implementation = Pagamento.class)))
    @APIResponse(responseCode = "406", description = "Invalid data")
    @APIResponse(responseCode = "409", description = "pagamento already exists")
    @Operation(summary = "Create new pagamento ")
    public Response create(@PathParam("id") Long idCliente, @PathParam("valor") Double valorCompra ) {


        pagamentoService.pagamento(idCliente, valorCompra);


        return Response.ok().status(Status.CREATED).build();
    }

    
}