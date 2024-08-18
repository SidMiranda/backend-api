package com.casasbahia.api_vendedores.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "filiais")
public class FilialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    @Column(nullable = false)
    private LocalDate ultimaAtualizacao;
}


