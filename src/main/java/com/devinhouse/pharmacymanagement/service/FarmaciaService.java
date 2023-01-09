package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.repository.FarmaciaRepository;
import org.springframework.stereotype.Service;

@Service
public class FarmaciaService {
    private final FarmaciaRepository repository;

    public FarmaciaService(FarmaciaRepository repository) {
        this.repository = repository;
    }
}
