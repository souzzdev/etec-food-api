//INTEGRANTES: Isadora Neves, Lukas Santos, Isaac Barbosa, Natanael Roberto, Fernanda Souza e Luiza Brito

package br.com.etechas.etecfood.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "Cardapio")

public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cardapio")
    private long id;

    @ManyToOne
    @Column(name = "id_restaurante")
    private Restaurante restaurante;
}
