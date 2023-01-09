package com.devinhouse.pharmacymanagement.repository;

import com.devinhouse.pharmacymanagement.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
