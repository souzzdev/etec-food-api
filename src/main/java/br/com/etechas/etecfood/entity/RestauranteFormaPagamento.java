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

@Getter
@Setter
@Entity
@Table(name = "Tbl_Restaurante_Forma_Pagamento")
public class RestauranteFormaPagamento {

    @EmbeddedId
    private RestauranteFormaPagamentoId id;

    @ManyToOne
    @MapsId("restauranteId")
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;
}
