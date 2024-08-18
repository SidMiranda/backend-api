package com.casasbahia.api_vendedores.controllers;

import com.casasbahia.api_vendedores.models.VendedorModel;
import com.casasbahia.api_vendedores.services.VendedorService;
import com.casasbahia.api_vendedores.services.MatriculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(VendedorController.class)
public class VendedorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VendedorService vendedorService;

    @MockBean
    private MatriculaService matriculaService;

    @InjectMocks
    private VendedorController vendedorController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vendedorController).build();
    }

    @Test
    public void testCriarVendedor()throws Exception {
        VendedorModel vendedor = new VendedorModel();
        vendedor.setId(1L);
        vendedor.setNome("Miguel Miranda");
        vendedor.setCpfOuCnpj("122.436.784-01");
        vendedor.setEmail("miguel.miranda2023@example.com.br");
        vendedor.setTipoContratacao("CLT");
        vendedor.setDataNascimento(LocalDate.of(1985, 5, 15));
        vendedor.setFilialId(1L);
        vendedor.setMatricula("00000001-CLT"); // Supondo que a matrícula gerada seja assim

        when(matriculaService.gerarMatricula(any(String.class))).thenReturn("00000001-CLT");
        when(vendedorService.criarVendedor(any(VendedorModel.class))).thenReturn(vendedor);

        mockMvc.perform(post("/vendedores")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                         "    \"nome\":\"Miguel Miranda\",\n" +
                         "    \"cpfOuCnpj\":\"122.436.784-01\",\n" +
                         "    \"email\":\"miguel.miranda2023@example.com.br\",\n" +
                         "    \"tipoContratacao\":\"CLT\",\n" +
                         "    \"dataNascimento\":\"1985-05-15\",\n" +
                         "    \"filialId\":\"1\"\n" +
                         "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Miguel Miranda"))
                .andExpect(jsonPath("$.cpfOuCnpj").value("122.436.784-01"))
                .andExpect(jsonPath("$.email").value("miguel.miranda2023@example.com.br"))
                .andExpect(jsonPath("$.tipoContratacao").value("CLT"))
                .andExpect(jsonPath("$.dataNascimento").value("1985-05-15"))
                .andExpect(jsonPath("$.filialId").value(1))
                .andExpect(jsonPath("$.matricula").value("00000001-CLT"));
    }
}
