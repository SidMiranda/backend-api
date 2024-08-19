package com.casasbahia.api_vendedores.controllers;

import com.casasbahia.api_vendedores.models.VendedorModel;
import com.casasbahia.api_vendedores.services.VendedorService;
import com.casasbahia.api_vendedores.services.MatriculaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class VendedorControllerTests {

    @Mock
    private VendedorService vendedorService;

    @Mock
    private MatriculaService matriculaService;

    @Test
    public void testCriarVendedor(){
        VendedorModel vendedor = new VendedorModel();
        vendedor.setId(1L);
        vendedor.setNome("Miguel Miranda");
        vendedor.setCpfOuCnpj("122.436.784-01");
        vendedor.setEmail("miguel.miranda2023@gmail.com");
        vendedor.setTipoContratacao("CLT");
        vendedor.setDataNascimento(LocalDate.of(1985, 5, 15));
        vendedor.setFilialId(1L);
        vendedor.setMatricula("00000001-CLT");

        when(matriculaService.gerarMatricula(any(String.class))).thenReturn("00000001-CLT");
        when(vendedorService.criarVendedor(any(VendedorModel.class))).thenReturn(vendedor);

        VendedorModel result = vendedorService.criarVendedor(vendedor);

        assertEquals("Miguel Miranda", result.getNome());
        assertEquals("122.436.784-01", result.getCpfOuCnpj());
        assertEquals("miguel.miranda2023@gmail.com", result.getEmail());
        assertEquals("00000001-CLT", result.getMatricula());
 
    }
}
