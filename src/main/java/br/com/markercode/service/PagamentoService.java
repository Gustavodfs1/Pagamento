package br.com.markercode.service;

import java.util.Date;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.markercode.model.Pagamento;
import br.com.markercode.restclient.ClienteRestClient;

@RequestScoped
public class PagamentoService{

    @RestClient
    @Inject
    ClienteRestClient clienteRestClient;

    @Traced
    @Transactional
    public void pagamento(Long idCliente, Double valorCompra){

        System.out.println("chegou aye aqui");
        var dados = clienteRestClient.buscarDados(idCliente);
        System.out.println("chegou ateeeee auqi");

       

        var pagamento = new Pagamento();
        pagamento.valor = valorCompra;
        pagamento.data = new Date();
        pagamento.dadosPagamento = dados;

        System.out.println(pagamento.data);
        pagamento.persist();
        

    }
}







