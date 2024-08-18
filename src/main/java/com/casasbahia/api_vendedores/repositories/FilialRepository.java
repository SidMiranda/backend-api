package com.casasbahia.api_vendedores.repositories;

import com.casasbahia.api_vendedores.models.FilialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRepository extends JpaRepository<FilialModel, Long> {

}
