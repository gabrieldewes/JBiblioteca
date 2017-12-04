/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.joda.time.LocalDateTime;

/**
 *
 * @author gabriel
 */
public class Emprestimo {
    
    private int id_emprestimo, id_pessoa;
    private ArrayList<Integer> id_exemplar;
    private LocalDateTime data_inicio, data_fim;

    @Override
    public String toString() {
        return "Emprestimo{" + "id_emprestimo=" + id_emprestimo + ", id_pessoa=" + id_pessoa + ", id_exemplar=" + id_exemplar + ", data_inicio=" + data_inicio + ", data_fim=" + data_fim + '}';
    }

    public Emprestimo(int id_emprestimo, int id_pessoa, ArrayList<Integer> id_exemplar, LocalDateTime data_inicio, LocalDateTime data_fim) {
        this.id_emprestimo = id_emprestimo;
        this.id_pessoa = id_pessoa;
        this.id_exemplar = id_exemplar;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public ArrayList<Integer> getId_exemplar() {
        return id_exemplar;
    }

    public void setId_exemplar(ArrayList<Integer> id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    public LocalDateTime getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDateTime data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDateTime getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDateTime data_fim) {
        this.data_fim = data_fim;
    }

}
