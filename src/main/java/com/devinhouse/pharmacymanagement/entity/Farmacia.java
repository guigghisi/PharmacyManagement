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
    @Column(name = "razao_social")
    private String razaoSocial;
    @NotNull(message = "O CNPJ da farmacia não pode estar vazio")
    private String cnpj;
    @NotNull(message = "O nome fantasia da farmacia não pode estar vazio")
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @NotNull(message = "O email da farmacia não pode estar vazio")
    private String email;
    private String telefone;
    @NotNull(message = "O número de celular da farmacia não pode estar vazio")
    private String celular;
    //TODO conectar
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
