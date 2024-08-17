package com.casasbahia.api_vendedores.repositories;

import com.casasbahia.api_vendedores.models.VendedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel, Long> {

}
