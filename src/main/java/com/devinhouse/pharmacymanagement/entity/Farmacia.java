package com.devinhouse.pharmacymanagement.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message = "A razão social da farmacia não pode estar vazia")
    @Column(name = "razao_social")
    private String razaoSocial;
    @NotEmpty(message = "O CNPJ da farmacia não pode estar vazio")
    private String cnpj;
    @NotEmpty(message = "O nome fantasia da farmacia não pode estar vazio")
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @NotEmpty(message = "O email da farmacia não pode estar vazio")
    private String email;
    private String telefone;
    @NotEmpty(message = "O número de celular da farmacia não pode estar vazio")
    private String celular;
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
