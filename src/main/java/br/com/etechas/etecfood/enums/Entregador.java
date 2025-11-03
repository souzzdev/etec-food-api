/* Guilherme Rosseto Valentim
 * Vinicius Kobayashi
 * João Pedro Vieira
 * Lucas de Andrade Moraes
 * Raphael Luis*/
package br.com.etechas.etecfood.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Getter
@Setter

@Entity
@Table(name = "Entregador")

public class Entregador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENT")
    private Long id;

    @Column(name = "TX_NOME_ENT")
    private String nome;

    @Column(name = "TX_TELEFONE_ENT")
    private String telefone;

    @Column(name = "ATIVO")
    private Boolean ativo;
}


