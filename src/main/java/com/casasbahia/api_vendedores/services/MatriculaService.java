package com.casasbahia.api_vendedores.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MatriculaService {

    // private static final String[] SUFIXOS = {"OUT", "CLT", "PJ"};
    private final Random random = new Random();

    public String gerarMatricula(String tipoContratacao) {

        // Gerar um número sequencial aleatório
        int numeroSequencial= random.nextInt(100000000); 

        // String sufixo= SUFIXOS[random.nextInt(SUFIXOS.length)];
        return String.format("%08d-%s", numeroSequencial, tipoContratacao);
    }
}

