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
    @Column(name = "nome_medicamento")
    private String nomeMedicamento;
    @NotNull(message = "O nome do laboratorio não pode estar vazio")
    @Column(name = "nome_laboratorio")
    private String nomeLaboratorio;
    @NotNull(message = "A dosagem não pode estar vazia")
    @Column(name = "dosagem_medicamento")
    private String dosagemMedicamento;
    @Column(name = "descricao_medicamento")
    private String descricaoMedicamento;
    @NotNull(message = "O preço do medicamento não pode estar vazio")
    @Column(name = "preco_unitario")
    private String precoUnitario;
    @NotNull(message = "O tipo do medicamento não pode estar vazio")
    @Column(name = "tipo_medicamento")
    private String tipoMedicamento;
}
