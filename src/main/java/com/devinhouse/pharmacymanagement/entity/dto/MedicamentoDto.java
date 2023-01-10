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
        medicamento.setNomeMedicamento(nome_medicamento);
        medicamento.setNomeLaboratorio(nome_laboratorio);
        medicamento.setDosagemMedicamento(dosagem_medicamento);
        medicamento.setDescricaoMedicamento(descricao_medicamento);
        medicamento.setPrecoUnitario(preco_unitario);
        medicamento.setTipoMedicamento(tipo_medicamento);
        return medicamento;
    }

    public MedicamentoDto transformarEmDto(Medicamento medicamentoSalvo) {
        var medicamentoDto = new MedicamentoDto();
        medicamentoDto.setId(medicamentoSalvo.getId());
        medicamentoDto.setNome_medicamento(medicamentoSalvo.getNomeMedicamento());
        medicamentoDto.setNome_laboratorio(medicamentoSalvo.getNomeLaboratorio());
        medicamentoDto.setDosagem_medicamento(medicamentoSalvo.getDosagemMedicamento());
        medicamentoDto.setDescricao_medicamento(medicamentoSalvo.getDescricaoMedicamento());
        medicamentoDto.setPreco_unitario(medicamentoSalvo.getPrecoUnitario());
        medicamentoDto.setTipo_medicamento(medicamentoSalvo.getTipoMedicamento());
        return medicamentoDto;
    }

    public List<MedicamentoDto> trasnformarEmListaDeDtos(List<Medicamento> medicamentos) {
        if (medicamentos.isEmpty()) {
            throw new NenhumMedicamentoException();
        }
        return medicamentos.stream().map(this::transformarEmDto).collect(Collectors.toList());
    }
}

