package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.entity.Medicamento;
import com.devinhouse.pharmacymanagement.exception.MedicamentoNaoEncontradoException;
import com.devinhouse.pharmacymanagement.exception.NenhumMedicamentoException;
import com.devinhouse.pharmacymanagement.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {
    private final MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repository) {
        this.repository = repository;
    }

    public Medicamento criarNovoMedicamento(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public Medicamento atualizarMedicamento(Long codigoMedicamento, Medicamento medicamento) {
        var medicamentoAntigo = repository.findById(codigoMedicamento).orElseThrow(MedicamentoNaoEncontradoException::new);

        medicamentoAntigo.setDescricao_medicamento(medicamento.getDescricao_medicamento());
        medicamentoAntigo.setNome_medicamento(medicamento.getNome_medicamento());
        medicamentoAntigo.setDosagem_medicamento(medicamento.getDosagem_medicamento());
        medicamentoAntigo.setTipo_medicamento(medicamento.getTipo_medicamento());
        return repository.save(medicamentoAntigo);
    }

    public List<Medicamento> buscarTodos() {
        if (repository.findAll().isEmpty()) {
            throw new NenhumMedicamentoException();
        }
        return repository.findAll();
    }

    public Medicamento buscarPeloId(Long codigoMedicamento) {
        return repository.findById(codigoMedicamento).orElseThrow(MedicamentoNaoEncontradoException::new);
    }

    public void excluirMedicamento(Long codigoMedicamento) {
        var medicamento = repository.findById(codigoMedicamento).orElseThrow(MedicamentoNaoEncontradoException::new);
        repository.delete(medicamento);
    }
}
