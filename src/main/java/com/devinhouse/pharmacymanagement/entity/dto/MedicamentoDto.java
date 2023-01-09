package com.devinhouse.pharmacymanagement.entity.dto;

import com.devinhouse.pharmacymanagement.entity.Medicamento;
import com.devinhouse.pharmacymanagement.exception.NenhumMedicamentoException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MedicamentoDto {

    private Long id;
    private String nome_medicamento;
    private String nome_laboratorio;
    private String dosagem_medicamento;
    private String descricao_medicamento;
    private String preco_unitario;
    private String tipo_medicamento;

    public Medicamento transformarEmEntidade() {
        var medicamento = new Medicamento();
        //TODO MOSTRAR ID NO JSON
        medicamento.setNome_medicamento(nome_medicamento);
        medicamento.setNome_laboratorio(nome_laboratorio);
        medicamento.setDosagem_medicamento(dosagem_medicamento);
        medicamento.setDescricao_medicamento(descricao_medicamento);
        medicamento.setPreco_unitario(preco_unitario);
        medicamento.setTipo_medicamento(tipo_medicamento);
        return medicamento;
    }

    public MedicamentoDto transformarEmDto(Medicamento medicamentoSalvo) {
        var medicamentoDto = new MedicamentoDto();
        medicamentoDto.setId(medicamentoSalvo.getId());
        medicamentoDto.setNome_medicamento(medicamentoSalvo.getNome_medicamento());
        medicamentoDto.setNome_laboratorio(medicamentoSalvo.getNome_laboratorio());
        medicamentoDto.setDosagem_medicamento(medicamentoSalvo.getDosagem_medicamento());
        medicamentoDto.setDescricao_medicamento(medicamentoSalvo.getDescricao_medicamento());
        medicamentoDto.setPreco_unitario(medicamentoSalvo.getPreco_unitario());
        medicamentoDto.setTipo_medicamento(medicamentoSalvo.getTipo_medicamento());
        return medicamentoDto;
    }

    public List<MedicamentoDto> trasnformarEmListaDeDtos(List<Medicamento> medicamentos) {
        if (medicamentos.isEmpty()) {
            throw new NenhumMedicamentoException();
        }
        return medicamentos.stream().map(this::transformarEmDto).collect(Collectors.toList());
    }
}

