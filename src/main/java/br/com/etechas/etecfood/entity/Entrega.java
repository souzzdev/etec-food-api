package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "TBL_ENTREGA")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "NUM_ID")
    private long idEntrega;

    @Column (name = "TX_CEP")
    private String cep;

    @Column (name = "TX_ENDERECO")
    private String endereco;

    @Column (name = "TX_COMPLEMENTO")
    private String complemento;

    @ManyToOne
    @Column (name = "FK_ID_CLIENTE")
    private Cliente cliente;

    /*@ManyToOne
    @Column (name = "FK_ID_PEDIDO")
    private Pedido pedido;*/

    /*@ManyToOne
    @Column (name = "FK_ID_ENT")
    private Entregador entregador;*/

}
