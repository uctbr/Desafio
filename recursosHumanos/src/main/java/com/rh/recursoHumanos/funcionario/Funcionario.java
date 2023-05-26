package com.rh.recursoHumanos.funcionario;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity(name = "Funcionario")
@Table(name = "funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String sobrenome;

    private Cargo cargo;

    private Date dataInicio;

    private Boolean ativo = true;

    public void atualizar(Funcionario funcionario) {
        if(funcionario.getNome()!=null){
            this.nome = funcionario.getNome();
        }
        if(funcionario.getSobrenome()!=null){
            this.sobrenome = funcionario.getSobrenome();
        }
        if(funcionario.getCargo()!=null){
            this.cargo = funcionario.cargo;
        }
        if(funcionario.getDataInicio()!=null){
            this.dataInicio = funcionario.getDataInicio();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
