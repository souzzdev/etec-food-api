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
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "Tbl_Horario_Funcionamento")
public class HorarioFuncionamento {

    @Id
    @Column(name = "id_horarioFuncionamento")
    private Long id;

    @Column(name = "dt_diaSemana")
    private String diaSemana;

    @Column(name = "dt_horarioAbertura")
    private LocalTime horarioAbertura;

    @Column(name = "dt_horarioFechamento")
    private LocalTime horarioFechamento;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;
}
