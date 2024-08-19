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
    @NotNull(message = "O campo nome é obrigatório") 
    private String nome;

    @Column 
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    @NotNull(message = "O campo cpfOuCnpj é obrigatório") 
    private String cpfOuCnpj;

    @Column(nullable = false, unique = true)
    @NotNull(message = "O campo email é obrigatório") 
    @Email 
    private String email;

    @Column(nullable = false)
    @NotNull(message = "O campo tipo de contratacao é obrigatório")
    private String tipoContratacao;

    @Column(nullable = false)
    @NotNull(message = "O campo filialId é obrigatório")
    private Long filialId;  
    
    @Transient
    private FilialModel filial;

}
