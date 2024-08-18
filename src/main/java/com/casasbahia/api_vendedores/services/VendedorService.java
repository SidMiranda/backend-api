package com.casasbahia.api_vendedores.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.casasbahia.api_vendedores.models.VendedorModel;
import com.casasbahia.api_vendedores.repositories.VendedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;


@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @ExceptionHandler
    public VendedorModel criarVendedor(VendedorModel vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<VendedorModel> buscarTodos() {
        return vendedorRepository.findAll();
    }

    public Optional<VendedorModel> buscarPorId(Long id) {
        return vendedorRepository.findById(id);
    }

    public VendedorModel atualizarVendedor(VendedorModel vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public void deletarVendedor(Long id) {
        vendedorRepository.deleteById(id);
    }

}
