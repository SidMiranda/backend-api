package com.casasbahia.api_vendedores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.casasbahia.api_vendedores.models.VendedorModel;
import com.casasbahia.api_vendedores.services.VendedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping 
    public ResponseEntity<VendedorModel> criarVendedor(@RequestBody VendedorModel vendedor) {
        VendedorModel novoVendedor= vendedorService.criarVendedor(vendedor);
        return new ResponseEntity<>(novoVendedor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VendedorModel>> buscarTodos() {
        List<VendedorModel> vendedores = vendedorService.buscarTodos();
        return new ResponseEntity<>(vendedores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorModel> buscarPorId(@PathVariable Long id) {
        Optional<VendedorModel> vendedor = vendedorService.buscarPorId(id);
        return vendedor.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Long id) {
        vendedorService.deletarVendedor(id);
        return ResponseEntity.noContent().build();
    }

}
