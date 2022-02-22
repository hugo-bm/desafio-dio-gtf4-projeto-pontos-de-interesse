package com.br.dio.desafiodiogtf4projetopontosdeinteresse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entidade representativa para Pontos de Interesse
 * @author Hugo Moreno
 * @since Versão 1.0.0
 * @version versão 1.0.0
 */
@Entity
public class PontosInteresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private String descricao;
    @OneToOne
    private Enderecos endereco;

    public long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Enderecos getEndereco() {
        return endereco;
    }
    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }
}
