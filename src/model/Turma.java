/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Dewes
 */
public class Turma {
    private int id_turma;
    private String nome;
    private String ano;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_turma;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.ano);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.id_turma != other.id_turma) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        return true;
    }

    public Turma(int id_turma, String nome, String ano) {
        this.id_turma = id_turma;
        this.nome = nome;
        this.ano = ano;
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
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
}
