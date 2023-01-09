package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
    private final MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repository) {
        this.repository = repository;
    }
}
