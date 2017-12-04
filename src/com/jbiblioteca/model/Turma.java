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
public class Turma {
    private int id_turma;
    private String nome;

    public Turma(int id_turma, String nome) {
        this.id_turma = id_turma;
        this.nome = nome;
    }

    public int getId_turma() {
        return id_turma;
    }
    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
