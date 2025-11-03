package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "AVALIACAO")

public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AVALIACAO")
    private Long id;

    @Column(name = "NOTA")
    private Integer nota;

    @Column(name = "COMENTARIO")
    private String comentario;

    @ManyToOne
    @Column(name = "PEDIDO_ID")
    private Pedido pedidoId;
}
