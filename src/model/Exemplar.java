/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author gabriel
 */
public class Exemplar {
    
    private int id_exemplar, id_livro;
    private String codigo, disponivel, coordenada_x, coordenada_y;
    private Livro l;

    @Override
    public String toString() {
        return "Exemplar{" + "id_exemplar=" + id_exemplar + ", id_livro=" + id_livro + ", codigo=" + codigo + ", disponivel=" + disponivel + '}';
    }

    public Exemplar(int id_exemplar, int id_livro, String codigo, String disponivel, String coordenada_x, String coordenada_y) {
        this.id_exemplar = id_exemplar;
        this.id_livro = id_livro;
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
    }

    public Exemplar(int id_exemplar, int id_livro, String codigo, String disponivel, String coordenada_x, String coordenada_y, Livro l) {
        this.id_exemplar = id_exemplar;
        this.id_livro = id_livro;
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
        this.l = l;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Exemplar other = (Exemplar) obj;
        if (this.id_exemplar != other.id_exemplar) {
            return false;
        }
        if (this.id_livro != other.id_livro) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.disponivel, other.disponivel)) {
            return false;
        }
        if (!Objects.equals(this.coordenada_x, other.coordenada_x)) {
            return false;
        }
        if (!Objects.equals(this.coordenada_y, other.coordenada_y)) {
            return false;
        }
        if (!Objects.equals(this.l, other.l)) {
            return false;
        }
        return true;
    }

    public int getId_exemplar() {
        return id_exemplar;
    }

    public void setId_exemplar(int id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
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

    public String getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(String coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public String getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(String coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public Livro getL() {
        return l;
    }

    public void setL(Livro l) {
        this.l = l;
    }

}
