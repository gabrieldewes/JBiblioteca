/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.model;

/**
 *
 * @author gabriel
 */
public class Exemplar {
    
    private int idExemplar, idLivro;
    private String codigo, disponivel, coordenadaX, coordenadaY;
    private Livro livro;

    @Override
    public String toString() {
        return "Exemplar{" + "id_exemplar=" + idExemplar + ", id_livro=" + idLivro + ", codigo=" + codigo + ", disponivel=" + disponivel + '}';
    }
    
    public Exemplar(String codigo) {
        this.codigo = codigo;
    }

    public Exemplar(int idExemplar, int idLivro, String codigo, String disponivel, String coordenadaX, String coordenadaY) {
        this.idExemplar = idExemplar;
        this.idLivro = idLivro;
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Exemplar(int idExemplar, int idLivro, String codigo, String disponivel, String coordenadaX, String coordenadaY, Livro livro) {
        this.idExemplar = idExemplar;
        this.idLivro = idLivro;
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.livro = livro;
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(String coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public String getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(String coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
