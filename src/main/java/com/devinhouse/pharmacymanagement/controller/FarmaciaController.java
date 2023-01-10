package com.devinhouse.pharmacymanagement.controller;

import com.devinhouse.pharmacymanagement.entity.dto.FarmaciaDto;
import com.devinhouse.pharmacymanagement.service.FarmaciaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    private final FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FarmaciaDto cadastraFarmacia(@RequestBody FarmaciaDto farmaciaDto) {
        var farmacia = farmaciaDto.transformarEmEntidade();
        var farmaciaSalva = farmaciaService.criarNovaFarmacia(farmacia);
        return farmaciaDto.transformaEmDto(farmaciaSalva);
    }

    @PutMapping("/{codigoFarmacia}")
    @ResponseStatus(HttpStatus.OK)
    public FarmaciaDto atualizarFarmacia(@PathVariable(value = "codigoFarmacia") Long codigoFarmacia, @RequestBody FarmaciaDto farmaciaDto) {
        var farmaciaAtualizada = farmaciaService.atualizarFarmacia(codigoFarmacia, farmaciaDto.transformarEmEntidade());
        return farmaciaDto.transformaEmDto(farmaciaAtualizada);
    }

    @GetMapping("/{codigoFarmacia}")
    @ResponseStatus(HttpStatus.OK)
    public FarmaciaDto consulta(@PathVariable(value = "codigoFarmacia") Long codigoFarmacia) {
        var farmacias = farmaciaService.bucarPeloId(codigoFarmacia);
        var farmaciaDto = new FarmaciaDto();
        return farmaciaDto.transformaEmDto(farmacias);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FarmaciaDto> consulta() {
        var farmacias = farmaciaService.buscarTodas();
        var farmaciaDto = new FarmaciaDto();
        return farmaciaDto.transformarEmListaDeDtos(farmacias);
    }

    @DeleteMapping("/{codigoFarmacia}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluirFarmacia(@PathVariable(value = "codigoFarmacia") Long codigoFarmacia) {
        farmaciaService.excluirFarmacia(codigoFarmacia);
    }
}
