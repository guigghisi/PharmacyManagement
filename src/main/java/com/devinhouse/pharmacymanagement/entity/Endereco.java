package com.devinhouse.pharmacymanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotNull(message = "O CEP não pode estar vazio")
    private String cep;
    @NotNull(message = "O logradouro/endereco não pode estar vazio")
    private String logradouro;
    @NotNull(message = "O número não pode estar vazio")
    private Integer numero;
    @NotNull(message = "O bairro não pode estar vazio")
    private String bairro;
    @NotNull(message = "A cidade não pode estar vazia")
    private String cidade;
    @NotNull(message = "O estado não pode estar vazio")
    private String estado;
    private String complemento;
    @NotNull(message = "A latitude não pode estar vazia")
    private String latitude;
    @NotNull(message = "A longitude não pode estar vazia")
    private String longitude;
}
