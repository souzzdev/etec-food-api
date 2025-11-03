/*
NOMES:
    Rafael Martins Nogueira
    Eduardo Borges
    Igor Edgar
    Renato Luiz
    Marcos Ferreira
    Gustavo Rodrigues
 */

package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Tbl_Restaurante")
public class Restaurante {

    @Id
    @Column(name = "id_restaurante")
    private long idRestaurante;

    @Column(name = "tx_cnpj", nullable = false)
    private String cnpj;

    @Column(name = "tx_nome", nullable = false)
    private String nome;

    @Column(name = "tx_descrição")
    private String descricao;

    @Column(name = "tx_cep")
    private String cep;

    @Column(name = "tx_endereco")
    private String endereco;

    @Column(name = "nr_taxaDeEntrega")
    private double taxaEntrega;

    @Column(name = "nr_tempoDeEntregaMinimo")
    private int tempoEntregaMin;

    @Column(name = "nr_tempoDeEntregaMaximo")
    private int tempoEntregaMax;

    @Column(name = "bool_aprovado")
    private boolean aprovado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tx_TipoCozinhaEnum")
    private TipoCozinhaEnum tipoCozinha;

    @OneToMany(mappedBy = "restaurante")
    private List<HorarioFuncionamento> horarios;

    @OneToMany(mappedBy = "restaurante")
    private List<RestauranteFormaPagamento> formasPagamento;
}
