package com.devinhouse.pharmacymanagement.entity.dto;

import com.devinhouse.pharmacymanagement.entity.Farmacia;
import com.devinhouse.pharmacymanagement.exception.NenhumaFarmaciaException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FarmaciaDto {

    private String razao_social;
    private String cnpj;
    private String nome_fantasia;
    private String email;
    private String telefone;
    private String celular;

    public Farmacia transformarEmEntidade() {
        var farmacia = new Farmacia();
        farmacia.setRazao_social(this.razao_social);
        farmacia.setCnpj(this.cnpj);
        farmacia.setNome_fantasia(this.nome_fantasia);
        farmacia.setEmail(this.email);
        farmacia.setTelefone(this.telefone);
        farmacia.setCelular(this.celular);

        return farmacia;
    }

    public FarmaciaDto transformaEmDto(Farmacia farmaciaSalva) {
        var farmaciaDto = new FarmaciaDto();
        farmaciaDto.setRazao_social(farmaciaSalva.getRazao_social());
        farmaciaDto.setCnpj(farmaciaSalva.getCnpj());
        farmaciaDto.setNome_fantasia(farmaciaSalva.getNome_fantasia());
        farmaciaDto.setEmail(farmaciaSalva.getEmail());
        farmaciaDto.setTelefone(farmaciaSalva.getTelefone());
        farmaciaDto.setCelular(farmaciaSalva.getCelular());

        return farmaciaDto;
    }

    public List<FarmaciaDto> transformarEmListaDeDtos(List<Farmacia> farmacias) {
        if (farmacias.isEmpty()) {
            throw new NenhumaFarmaciaException();
        }

        return farmacias.stream().map(this::transformaEmDto).collect(Collectors.toList());
    }
}
