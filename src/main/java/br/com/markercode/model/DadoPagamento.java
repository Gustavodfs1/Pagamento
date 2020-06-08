package br.com.markercode.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="tb_dado_pagamento")
public class DadoPagamento extends PanacheEntity {
    
     @Column(nullable = true)
    public String numCartao;

     @Column(nullable = true)
    public String cvcCartao;

     @Column(nullable = true)
    public String nomeCartao;

     @Column(nullable = true)
    public String validadeCartao;
}