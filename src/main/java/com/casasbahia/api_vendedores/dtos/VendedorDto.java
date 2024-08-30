package com.casasbahia.api_vendedores.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VendedorDto(@NotBlank String matricula, @NotNull String nome, String cpfOuCnpj, 
                          String email, String tipoContratacao, Long filialId) {

}
