package com.devinhouse.pharmacymanagement.controller;

import com.devinhouse.pharmacymanagement.entity.Medicamento;
import com.devinhouse.pharmacymanagement.entity.dto.MedicamentoDto;
import com.devinhouse.pharmacymanagement.service.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicamentoDto cadastraMedicamento(@RequestBody MedicamentoDto medicamentoDto) {
        Medicamento medicamento = medicamentoDto.transformarEmEntidade();
        Medicamento medicamentoSalvo = medicamentoService.criarNovoMedicamento(medicamento);

        return medicamentoDto.transformarEmDto(medicamentoSalvo);
    }


    @PutMapping("/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public MedicamentoDto atualizarMedicamento(@PathVariable(value = "codigoMedicamento") Long codigoMedicamento, @RequestBody MedicamentoDto medicamentoDto) {
        Medicamento medicamentoAtualizado = medicamentoService.atualizarMedicamento(codigoMedicamento, medicamentoDto.transformarEmEntidade());
        return medicamentoDto.transformarEmDto(medicamentoAtualizado);
    }

    @GetMapping("/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public MedicamentoDto consulta(@PathVariable(value = "codigoMedicamento") Long codigoMedicamento) {
        Medicamento medicamentos = medicamentoService.buscarPeloId(codigoMedicamento);
        MedicamentoDto medicamentoDto = new MedicamentoDto();
        return medicamentoDto.transformarEmDto(medicamentos);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicamentoDto> consulta() {
        List<Medicamento> medicamentos = medicamentoService.buscarTodos();
        MedicamentoDto medicamentoDto = new MedicamentoDto();
        return medicamentoDto.trasnformarEmListaDeDtos(medicamentos);
    }

    @DeleteMapping("/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluirMedicamento(@PathVariable(value = "codigoMedicamento") Long codigoMedicamento) {
        medicamentoService.excluirMedicamento(codigoMedicamento);
    }
}
