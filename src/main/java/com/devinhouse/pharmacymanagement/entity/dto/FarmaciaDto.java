package com.devinhouse.pharmacymanagement.entity.dto;

import com.devinhouse.pharmacymanagement.entity.Endereco;
import com.devinhouse.pharmacymanagement.entity.Farmacia;
import com.devinhouse.pharmacymanagement.exception.NenhumaFarmaciaException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FarmaciaDto {
    private Long id;
    private String razao_social;
    private String cnpj;
    private String nome_fantasia;
    private String email;
    private String telefone;
    private String celular;
    private Endereco endereco;

    public Farmacia transformarEmEntidade() {
        var farmacia = new Farmacia();
        farmacia.setRazaoSocial(this.razao_social);
        farmacia.setCnpj(this.cnpj);
        farmacia.setNomeFantasia(this.nome_fantasia);
        farmacia.setEmail(this.email);
        farmacia.setTelefone(this.telefone);
        farmacia.setCelular(this.celular);
        farmacia.setEndereco(this.endereco);
        return farmacia;
    }

    public FarmaciaDto transformaEmDto(Farmacia farmaciaSalva) {
        var farmaciaDto = new FarmaciaDto();
        farmaciaDto.setId(farmaciaSalva.getId());
        farmaciaDto.setRazao_social(farmaciaSalva.getRazaoSocial());
        farmaciaDto.setCnpj(farmaciaSalva.getCnpj());
        farmaciaDto.setNome_fantasia(farmaciaSalva.getNomeFantasia());
        farmaciaDto.setEmail(farmaciaSalva.getEmail());
        farmaciaDto.setTelefone(farmaciaSalva.getTelefone());
        farmaciaDto.setCelular(farmaciaSalva.getCelular());
        farmaciaDto.setEndereco(farmaciaSalva.getEndereco());
        return farmaciaDto;
    }

    public List<FarmaciaDto> transformarEmListaDeDtos(List<Farmacia> farmacias) {
        if (farmacias.isEmpty()) {
            throw new NenhumaFarmaciaException();
        }

        return farmacias.stream().map(this::transformaEmDto).collect(Collectors.toList());
    }
}
