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
@Table(name = "farmacias")
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "A razão social da farmacia não pode estar vazia")
    private String razao_social;
    @NotNull(message = "O CNPJ da farmacia não pode estar vazio")
    private String cnpj;
    @NotNull(message = "O nome fantasia da farmacia não pode estar vazio")
    private String nome_fantasia;
    @NotNull(message = "O email da farmacia não pode estar vazio")
    private String email;
    private String telefone;
    @NotNull(message = "O número de celular da farmacia não pode estar vazio")
    private String celular;
    //TODO conectar
   /* @NotNull
    @OneToMany(mappedBy = "farmacias")
    private Endereco id_endereco;*/
}
