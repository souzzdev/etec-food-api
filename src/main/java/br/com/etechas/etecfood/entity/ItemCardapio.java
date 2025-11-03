//INTEGRANTES: Isadora Neves, Lukas Santos, Isaac Barbosa, Natanael Roberto, Fernanda Souza e Luiza Brito

package br.com.etechas.etecfood.entity;
import br.com.etechas.etecfood.enums.TipoItemCardapioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "ItemCardapio")

public class ItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_cardapio")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tipo")
    private TipoItemCardapioEnum tipo;

    @Column(name = "preco")
    private double preco;

    @Column(name = "precoPromocional")
    private double precoPromocional;

    @ManyToOne
    @Column(name = "id_cardapio")
    private Cardapio cardapio;

    public double getPrecoEfetivo() {
        return preco;
    }
}
