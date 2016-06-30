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
public class Pessoa {
    private int id_pessoa, id_turma;
    private String codigo, nome, cargo;

    @Override
    public String toString() {
        return "Pessoa{" + "id_pessoa=" + id_pessoa + ", id_turma=" + id_turma + ", codigo=" + codigo + ", nome=" + nome + ", cargo=" + cargo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_pessoa;
        hash = 97 * hash + this.id_turma;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cargo);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (this.id_turma != other.id_turma) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return true;
    }

    public Pessoa(int id_pessoa, int id_turma, String codigo, String nome, String cargo) {
        this.id_pessoa = id_pessoa;
        this.id_turma = id_turma;
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
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
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
   
}
