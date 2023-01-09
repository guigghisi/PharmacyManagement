package com.devinhouse.pharmacymanagement.repository;

import com.devinhouse.pharmacymanagement.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
