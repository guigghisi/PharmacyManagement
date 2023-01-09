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
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome do medicamento não pode estar vazio")
    private String nome_medicamento;
    @NotNull(message = "O nome do laboratorio não pode estar vazio")
    private String nome_laboratorio;
    @NotNull(message = "A dosagem não pode estar vazia")
    private String dosagem_medicamento;
    private String descricao_medicamento;
    @NotNull(message = "O preço do medicamento não pode estar vazio")
    private String preco_unitario;
    @NotNull(message = "O tipo do medicamento não pode estar vazio")
    private String tipo_medicamento;
}
