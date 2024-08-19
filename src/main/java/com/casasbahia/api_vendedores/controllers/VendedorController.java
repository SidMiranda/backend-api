package com.casasbahia.api_vendedores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.casasbahia.api_vendedores.models.FilialModel;
import com.casasbahia.api_vendedores.models.VendedorModel;
import com.casasbahia.api_vendedores.services.VendedorService;

import com.casasbahia.api_vendedores.services.MatriculaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private FilialController filialController;  

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<VendedorModel> criarVendedor(@RequestBody VendedorModel vendedor){

        // Gerar a matrícula antes de salvar o vendedor
        vendedor.setMatricula(matriculaService.gerarMatricula(vendedor.getTipoContratacao()));

        try {
            VendedorModel novoVendedor = vendedorService.criarVendedor(vendedor);
            return new ResponseEntity<>(novoVendedor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<VendedorModel>> buscarTodos() {
        
        try {
            List<VendedorModel> vendedores = vendedorService.buscarTodos();
            List<FilialModel> filiais = filialController.getFiliais();
            
            for (VendedorModel vendedor : vendedores) {
                for (FilialModel filial : filiais) {
                    if (vendedor.getFilialId().equals(filial.getId())) {
                        vendedor.setFilial(filial);
                        break;
                    }
                }
            }
        
            return new ResponseEntity<>(vendedores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorModel> buscarPorId(@PathVariable Long id) {
        Optional<VendedorModel> vendedor = vendedorService.buscarPorId(id);
        return vendedor.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorModel> atualizarVendedor(@PathVariable Long id, @RequestBody VendedorModel vendedorAtualizado) {
        vendedorAtualizado.setId(id);
        VendedorModel vendedor = vendedorService.atualizarVendedor(vendedorAtualizado);
        return ResponseEntity.ok(vendedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Long id) {
        vendedorService.deletarVendedor(id);
        return ResponseEntity.noContent().build();
    }

}
