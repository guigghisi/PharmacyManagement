package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    //TODO restTemplate
}
