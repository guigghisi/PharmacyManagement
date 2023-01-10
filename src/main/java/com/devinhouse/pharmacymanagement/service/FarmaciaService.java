package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.entity.Farmacia;
import com.devinhouse.pharmacymanagement.exception.FarmaciaNaoEncontradaException;
import com.devinhouse.pharmacymanagement.exception.NenhumaFarmaciaException;
import com.devinhouse.pharmacymanagement.repository.FarmaciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaService {
    private final FarmaciaRepository repository;

    public FarmaciaService(FarmaciaRepository repository) {
        this.repository = repository;
    }

    public Farmacia criarNovaFarmacia(Farmacia farmacia) {
        return repository.save(farmacia);
    }

    public Farmacia atualizarFarmacia(Long codigoFarmacia, Farmacia farmacia) {
        var farmaciaAntiga = repository.findById(codigoFarmacia).orElseThrow(FarmaciaNaoEncontradaException::new);

        farmaciaAntiga.setRazaoSocial(farmacia.getRazaoSocial());
        farmaciaAntiga.setEndereco(farmacia.getEndereco());
        farmaciaAntiga.setCnpj(farmacia.getCnpj());
        farmaciaAntiga.setNomeFantasia(farmacia.getNomeFantasia());
        farmaciaAntiga.setEmail(farmacia.getEmail());
        farmaciaAntiga.setTelefone(farmacia.getTelefone());
        farmaciaAntiga.setCelular(farmacia.getCelular());
        farmaciaAntiga.setEndereco(farmacia.getEndereco());
        return repository.save(farmaciaAntiga);
    }

    public List<Farmacia> buscarTodas() {
        if (repository.findAll().isEmpty()) {
            throw new NenhumaFarmaciaException();
        }
        return repository.findAll();
    }

    public Farmacia bucarPeloId(Long codigoFarmacia) {
        return repository.findById(codigoFarmacia).orElseThrow(FarmaciaNaoEncontradaException::new);
    }

    public void excluirFarmacia(Long codigoFarmacia) {
        var farmacia = repository.findById(codigoFarmacia).orElseThrow(FarmaciaNaoEncontradaException::new);
        repository.delete(farmacia);
    }
}
