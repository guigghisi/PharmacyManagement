package com.devinhouse.pharmacymanagement.controller;

import com.devinhouse.pharmacymanagement.entity.Farmacia;
import com.devinhouse.pharmacymanagement.entity.dto.FarmaciaDto;
import com.devinhouse.pharmacymanagement.service.FarmaciaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {

    private final FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FarmaciaDto cadastraFarmacia(@RequestBody FarmaciaDto farmaciaDto) {
        Farmacia farmacia = farmaciaDto.transformarEmEntidade();
        Farmacia farmaciaSalva = farmaciaService.criarNovaFarmacia(farmacia);
        return farmaciaDto.transformaEmDto(farmaciaSalva);
    }

    @PutMapping("/{codigoFarmacia}")
    @ResponseStatus(HttpStatus.OK)
    public FarmaciaDto atualizarFarmacia(@PathVariable(value = "codigoFarmacia") Long codigoFarmacia, @RequestBody FarmaciaDto farmaciaDto) {
        Farmacia farmaciaAtualizada = farmaciaService.atualizarFarmacia(codigoFarmacia, farmaciaDto.transformarEmEntidade());
        return farmaciaDto.transformaEmDto(farmaciaAtualizada);
    }

    @GetMapping("/{codigoFarmacia}")
    @ResponseStatus(HttpStatus.OK)
    public FarmaciaDto consulta(@PathVariable(value = "codigoFarmacia") Long codigoFarmacia) {
        Farmacia farmacias = farmaciaService.bucarPeloId(codigoFarmacia);
        FarmaciaDto farmaciaDto = new FarmaciaDto();
        return farmaciaDto.transformaEmDto(farmacias);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FarmaciaDto> consulta() {
        List<Farmacia> farmacias = farmaciaService.buscarTodas();
        FarmaciaDto farmaciaDto = new FarmaciaDto();
        return farmaciaDto.transformarEmListaDeDtos(farmacias);
    }

    @DeleteMapping("/{codigoFarmacia}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluirFarmacia(@PathVariable(value = "codigoFarmacia") Long codigoFarmacia) {
        farmaciaService.excluirFarmacia(codigoFarmacia);
    }
}
