package br.com.markercode.model;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
@Table(name="tb_pagamento")
public class Pagamento extends PanacheEntity {

     @Column(nullable = true)
    public Double valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dado_pagamento")
    public DadoPagamento dadosPagamento;
    
    
     @Temporal(TemporalType.TIMESTAMP)
     @Column(nullable = true,name = "data")
    public Date data;
    

}
