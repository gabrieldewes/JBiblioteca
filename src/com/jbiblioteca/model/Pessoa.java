/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.model;

/**
 *
 * @author Dewes
 */
public class Pessoa {
    private int id_pessoa;
    private int id_turma;
    private String codigo;
    private String nome;

    @Override
    public String toString() {
        return "Pessoa{" + "id_pessoa=" + id_pessoa + ", id_turma=" + id_turma + ", codigo=" + codigo + ", nome=" + nome + '}';
    }

    public Pessoa(int id_pessoa, int id_turma, String codigo, String nome) {
        this.id_pessoa = id_pessoa;
        this.id_turma = id_turma;
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }
    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    public int getId_turma() {
        return id_turma;
    }
    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   
}
