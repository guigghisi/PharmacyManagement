package com.devinhouse.pharmacymanagement.repository;

import com.devinhouse.pharmacymanagement.entity.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
}
