package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "TBL_CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CLIENTE")
    private long idCliente;

    @Column (name = "TX_NOME")
    private String nome;

    @Column (name = "TX_CPF")
    private String cpf;

    @Column (name = "TX_EMAIL")
    private String email;

    @Column (name = "TX_TELEFONE")
    private String telefone;

    @Column (name = "BO_VALIDADO")
    private boolean validado;



}