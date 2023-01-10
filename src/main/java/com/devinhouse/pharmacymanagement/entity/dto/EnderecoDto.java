package com.devinhouse.pharmacymanagement.entity.dto;

import com.devinhouse.pharmacymanagement.entity.Endereco;
import com.devinhouse.pharmacymanagement.exception.NenhumEnderecoException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class EnderecoDto {
    private Long id;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String latitude;
    private String longitude;

    public Endereco transformarEmEntidade() {
        var endereco = new Endereco();

        endereco.setBairro(this.bairro);
        endereco.setCep(this.cep);
        endereco.setCidade(this.cidade);
        endereco.setComplemento(this.complemento);
        endereco.setEstado(this.estado);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setLatitude(this.latitude);
        endereco.setLongitude(this.longitude);

        return endereco;

    }

    public EnderecoDto transformarEmDto(Endereco enderecoSalvo) {
        var enderecoDto = new EnderecoDto();
        enderecoDto.setId(enderecoSalvo.getId());
        enderecoDto.setBairro(enderecoSalvo.getBairro());
        enderecoDto.setCep(enderecoSalvo.getCep());
        enderecoDto.setCidade(enderecoSalvo.getCidade());
        enderecoDto.setComplemento(enderecoSalvo.getComplemento());
        enderecoDto.setEstado(enderecoSalvo.getEstado());
        enderecoDto.setLogradouro(enderecoSalvo.getLogradouro());
        enderecoDto.setNumero(enderecoSalvo.getNumero());
        enderecoDto.setLatitude(enderecoSalvo.getLatitude());
        enderecoDto.setLongitude(enderecoSalvo.getLongitude());

        return enderecoDto;
    }

    public List<EnderecoDto> transformarEmListaDeDto(List<Endereco> enderecos) {
        if (enderecos.isEmpty()) {
            throw new NenhumEnderecoException();
        }
        return enderecos.stream().map(this::transformarEmDto).collect(Collectors.toList());
    }
}
