package com.casasbahia.api_vendedores.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.casasbahia.api_vendedores.models.FilialModel;

import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;

@RestController
public class FilialController {

    @GetMapping("/filiais")
    public List<FilialModel> getFiliais() {
        return Arrays.asList(
            new FilialModel(1L, 
                "Filial 1", 
                "12345678901234", 
                "São Paulo", 
                "SP", 
                "Matriz", 
                true, 
                LocalDate.now(), 
                LocalDate.now()),
            
            new FilialModel(2L, 
                "Filial 2", 
                "12345678901234", 
                "São Paulo", 
                "SP", 
                "Matriz", 
                true, 
                LocalDate.now(), 
                LocalDate.now())
        );
    }
    
}

