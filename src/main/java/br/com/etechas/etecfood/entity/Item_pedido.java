package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ITEM_PEDIDO")

public class Item_pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM_PEDIDO")
    private Long id;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @Column(name = "OBSERVACAO")
    private String obersavacao;

    @OneToMany
    @Column(name = "PEDIDO_ID")
    private Pedido pedidoId;

    @ManyToOne
    @Column(name = "id_itemcardapio")
    private ItemCardapio itemCardapio; // vai dar erro pq nn existe
}