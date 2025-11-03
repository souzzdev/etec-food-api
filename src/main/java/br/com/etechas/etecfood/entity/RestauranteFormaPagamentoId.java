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

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class RestauranteFormaPagamentoId implements Serializable {
    private Long restauranteId;
    private Long formaPagamentoId;
}
