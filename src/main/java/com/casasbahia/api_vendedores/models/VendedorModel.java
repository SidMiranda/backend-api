package com.casasbahia.api_vendedores.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "vendedores")
public class VendedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    @NotNull 
    private String nome;

    @Column 
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    @NotNull 
    private String cpfOuCnpj;

    @Column(nullable = false, unique = true)
    @NotNull 
    @Email 
    private String email;

    // private TipoContratacao tipoContratacao;

}
