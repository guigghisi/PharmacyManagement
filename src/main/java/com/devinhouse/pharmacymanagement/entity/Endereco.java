package com.devinhouse.pharmacymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O CEP não pode estar vazio")
    private String cep;
    @NotEmpty(message = "O logradouro/endereco não pode estar vazio")
    private String logradouro;
    @NotNull(message = "O número não pode estar vazio")
    private Integer numero;
    @NotEmpty(message = "O bairro não pode estar vazio")
    private String bairro;
    @NotEmpty(message = "A cidade não pode estar vazia")
    private String cidade;
    @NotEmpty(message = "O estado não pode estar vazio")
    private String estado;
    private String complemento;
    @NotEmpty(message = "A latitude não pode estar vazia")
    private String latitude;
    @NotEmpty(message = "A longitude não pode estar vazia")
    private String longitude;
}
