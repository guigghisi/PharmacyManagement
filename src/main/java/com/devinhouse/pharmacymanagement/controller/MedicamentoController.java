package com.devinhouse.pharmacymanagement.controller;

import com.devinhouse.pharmacymanagement.entity.dto.MedicamentoDto;
import com.devinhouse.pharmacymanagement.service.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicamentoDto cadastraMedicamento(@RequestBody MedicamentoDto medicamentoDto) {
        var medicamento = medicamentoDto.transformarEmEntidade();
        var medicamentoSalvo = medicamentoService.criarNovoMedicamento(medicamento);

        return medicamentoDto.transformarEmDto(medicamentoSalvo);
    }


    @PutMapping("/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public MedicamentoDto atualizarMedicamento(@PathVariable(value = "codigoMedicamento") Long codigoMedicamento, @RequestBody MedicamentoDto medicamentoDto) {
        var medicamentoAtualizado = medicamentoService.atualizarMedicamento(codigoMedicamento, medicamentoDto.transformarEmEntidade());
        return medicamentoDto.transformarEmDto(medicamentoAtualizado);
    }

    @GetMapping("/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public MedicamentoDto consulta(@PathVariable(value = "codigoMedicamento") Long codigoMedicamento) {
        var medicamentos = medicamentoService.buscarPeloId(codigoMedicamento);
        var medicamentoDto = new MedicamentoDto();
        return medicamentoDto.transformarEmDto(medicamentos);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicamentoDto> consulta() {
        var medicamentos = medicamentoService.buscarTodos();
        var medicamentoDto = new MedicamentoDto();
        return medicamentoDto.trasnformarEmListaDeDtos(medicamentos);
    }

    @DeleteMapping("/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluirMedicamento(@PathVariable(value = "codigoMedicamento") Long codigoMedicamento) {
        medicamentoService.excluirMedicamento(codigoMedicamento);
    }
}
