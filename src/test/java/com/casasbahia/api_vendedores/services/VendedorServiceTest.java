package com.casasbahia.api_vendedores.services;

import com.casasbahia.api_vendedores.models.VendedorModel;
import com.casasbahia.api_vendedores.repositories.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VendedorServiceTest {

    @Mock
    private MatriculaService matriculaService;

    @Mock
    private VendedorRepository vendedorRepository;

    @InjectMocks
    private VendedorService vendedorService;

    public VendedorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarVendedor(){
        VendedorModel vendedor = new VendedorModel();
        vendedor.setNome("Ligia Miranda");
        vendedor.setCpfOuCnpj("172.437.783-09");
        vendedor.setEmail("ligia.miranda2022@example.com.br");
        vendedor.setTipoContratacao("PJ");
        vendedor.setDataNascimento(LocalDate.of(1985, 5, 15));
        vendedor.setFilialId(2L);

        // Mocking MatriculaService
        // when(matriculaService.gerarMatricula("PJ")).thenReturn("12345678-PJ");

        // Mocking VendedorRepository
        when(vendedorRepository.save(any(VendedorModel.class))).thenReturn(vendedor);

        VendedorModel result = vendedorService.criarVendedor(vendedor);

        assertEquals("Ligia Miranda", result.getNome());
        assertEquals("172.437.783-09", result.getCpfOuCnpj());
        assertEquals("ligia.miranda2022@example.com.br", result.getEmail());
        // assertEquals("12345678-PJ", result.getMatricula());
    }

    @Test
    public void testBuscarTodos() {

        VendedorModel vendedor1 = new VendedorModel();
        vendedor1.setId(1L);
        vendedor1.setNome("Miguel Miranda");
        vendedor1.setCpfOuCnpj("122.436.784-01");
        vendedor1.setEmail("miguel.miranda2023@example.com.br");
        vendedor1.setTipoContratacao("CLT");
        vendedor1.setDataNascimento(LocalDate.of(1985, 5, 15));
        vendedor1.setFilialId(1L);

        VendedorModel vendedor2 = new VendedorModel();
        vendedor2.setId(2L);
        vendedor2.setNome("Outro Vendedor");
        vendedor2.setCpfOuCnpj("987.654.321-00");
        vendedor2.setEmail("outro.vendedor2023@example.com.br");
        vendedor2.setTipoContratacao("PJ");
        vendedor2.setDataNascimento(LocalDate.of(1990, 7, 20));
        vendedor2.setFilialId(2L);

        List<VendedorModel> vendedores = Arrays.asList(vendedor1, vendedor2);

        when(vendedorRepository.findAll()).thenReturn(vendedores);

        List<VendedorModel> result = vendedorService.buscarTodos();

        assertEquals(2, result.size());
        assertEquals("Miguel Miranda", result.get(0).getNome());
        assertEquals("122.436.784-01", result.get(0).getCpfOuCnpj());
        assertEquals("miguel.miranda2023@example.com.br", result.get(0).getEmail());
        assertEquals("CLT", result.get(0).getTipoContratacao());
        assertEquals(LocalDate.of(1985, 5, 15), result.get(0).getDataNascimento());
        assertEquals(1L, result.get(0).getFilialId());
    }
}

