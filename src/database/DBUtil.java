/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dewes
 */
public class DBUtil {
    
    public static void updateDDL(int current_ver, int new_ver) {
        try {
            DBHelper db = new DBHelper();
            db.onUpgrade(db, current_ver, new_ver);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createDDL() {
        try {
            DBHelper db = new DBHelper();
            db.rawLineSQL(create_ddl);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void dropDDL() {
        try {
            DBHelper db = new DBHelper();
            db.rawLineSQL(drop_ddl);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void populate() {
        try {
            DBHelper db = new DBHelper();
            db.rawLineSQL(insert_data);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void clear() {
        try {
            DBHelper db = new DBHelper();
            db.rawLineSQL(clear_data);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static String VER_1[] =  {"emprestimo", "situation", "TEXT", ""};
    public static String VER_2[] =  {"app_config", "prazo_default", "INTEGER", "0"};
    
    public static String[] selectScript(int ver){
        switch (ver) {
        case 1: 
            return VER_1;
        case 2:
            return VER_2;
        default:
            return null;         
        }
    }
    
    public static void updateTabelasBanco(DBHelper db, String table, String column, String typ, String valor) {
        try {
            db.rawSQL("ALTER TABLE " + table + " ADD " + column + " " + typ);
            if (!"".equals(valor)){
                db.rawSQL("UPDATE "+ table +" SET "+ column +" = '"+ valor +"'");
            }
        } catch (Exception e) {
        }
    }
    
    static String[] create_ddl = {
        "CREATE TABLE IF NOT EXISTS turma ( " +
            "id_turma INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT NOT NULL, " +
            "ano TEXT NOT NULL); ",
        
        "CREATE TABLE IF NOT EXISTS pessoa (" +
            "id_pessoa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "id_turma  INTEGER NOT NULL, " +
            "nome      TEXT DEFAULT 'Sem Nome', " +
            "cargo     TEXT NOT NULL, " +
            "codigo    TEXT NOT NULL UNIQUE, " +
            "FOREIGN KEY (id_turma) REFERENCES turma(id_turma) ON UPDATE CASCADE ON DELETE RESTRICT ); ", 
        
        "CREATE TABLE IF NOT EXISTS livro (" +
            "id_livro INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "titulo   TEXT NOT NULL DEFAULT 'Sem título', " +
            "autor    TEXT NOT NULL); ",
        
        "CREATE TABLE IF NOT EXISTS exemplar (" +
            "id_exemplar  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "codigo	  TEXT NOT NULL UNIQUE, " +
            "disponivel   TEXT NOT NULL, " +
            "coordenada_x TEXT NOT NULL, " +
            "coordenada_y TEXT NOT NULL, " +
            "id_livro     INTEGER NOT NULL, " +
            "FOREIGN KEY (id_livro) REFERENCES livro(id_livro) ON UPDATE CASCADE ON DELETE CASCADE); ",
        
        "CREATE TABLE IF NOT EXISTS emprestimo ( "+
            "id_emprestimo	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "id_pessoa          INTEGER NOT NULL, "+
            "data_inicio	TEXT NOT NULL, "+
            "data_fim	        TEXT, "+
            "situation          TEXT, "+
            "FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa)); ",
        
        "CREATE TABLE IF NOT EXISTS emprestimo_livro ( "+
            "id_emprestimo	INTEGER NOT NULL, "+
            "id_exemplar	INTEGER NOT NULL, "+
            "PRIMARY KEY(id_emprestimo,id_exemplar), "+
            "FOREIGN KEY(id_emprestimo) REFERENCES emprestimo(id_emprestimo), "+
            "FOREIGN KEY(id_exemplar) REFERENCES exemplar(id_exemplar) ); ",
        
        "CREATE TABLE IF NOT EXISTS app_config ( " +
            "taxa_juros    REAL,"+
            "last_backup   TEXT, "+
	    "db_version	   INTEGER, "+
            "prazo_default INTEGER, "+
            "auto_bkp      BLOB ); ",
        
        "INSERT INTO app_config (taxa_juros, db_version, prazo_default, auto_bkp) VALUES (0.0, 1, 7, 'true'); "
    };
    
    static String[] drop_ddl = {
        "DROP TABLE IF EXISTS pessoa; ",
        "DROP TABLE IF EXISTS livro; ",
        "DROP TABLE IF EXISTS turma; ",
        "DROP TABLE IF EXISTS exemplar; ",
        "DROP TABLE IF EXISTS emprestimo_livro; ",
        "DROP TABLE IF EXISTS emprestimo; ",
        "DROP TABLE IF EXISTS app_config; "
    };
    
    static String[] clear_data = {
        "DELETE FROM pessoa; ",
        "DELETE FROM livro; ",
        "DELETE FROM turma; ",
        "DELETE FROM exemplar; ",
        "DELETE FROM emprestimo_livro; ",
        "DELETE FROM emprestimo; ",
        "DELETE FROM app_config; "
    };
    
    static String[] insert_data= {
        "INSERT INTO livro (titulo, autor) VALUES ('Alice no pais das maravilhas', ''); ",
        "INSERT INTO livro (titulo, autor) VALUES ('Água para elefantes', 'Sara Cruen'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('Sol e Lua', 'Signos'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('O avantajado livro de pensamentos do cassera & planeta', 'Casseta e Planeta'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('As melhores piadas do planeta e do casseta também', 'Casseta e Planeta'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('A Cabana', 'Artista desconhecido'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('Cidades de Papel', 'Albert richerd'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('Estrelas de Biscoito', 'Artista aluado'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('Como criar uma mente', 'Algum engenheiro da google'); ",
        "INSERT INTO livro (titulo, autor) VALUES ('Forest gump é mato', 'Racionais'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (1, '0000', '', 'x', 'y'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (2, '0001', '', 'x1', 'y1'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (3, '0002', '', 'x2', 'y2'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (4, '0003', '', 'x3', 'y3'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (4, '0004', '', 'x4', 'y4'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (4, '0005', '', 'x4', 'y4'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (5, '0006', '', 'x4', 'y4'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (6, '0007', '', 'x', 'y'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (6, '0008', '', 'x1', 'y1'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (7, '0009', '', 'x2', 'y2'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (8, '0010', '', 'x3', 'y3'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (9, '0011', '', 'x4', 'y4'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (9, '0012', '', 'x4', 'y4'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (10, '0013', '', 'x3', 'y3'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (10, '0014', '', 'x4', 'y4'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (10, '0015', '', 'x3', 'y3'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (10, '0016', '', 'x3', 'y3'); ",
        "INSERT INTO exemplar (id_livro, codigo, disponivel, coordenada_x, coordenada_y) VALUES (10, '001100110011001100', '', 'x4', 'y4'); ",
        "INSERT INTO turma (nome, ano) VALUES ('A1', 'Primeiro'); ",
        "INSERT INTO turma (nome, ano) VALUES ('A2', 'Primeiro'); ",
        "INSERT INTO turma (nome, ano) VALUES ('B1', 'Segundo'); ",
        "INSERT INTO turma (nome, ano) VALUES ('B2', 'Segundo'); ",
        "INSERT INTO turma (nome, ano) VALUES ('C1', 'Terceiro'); ",
        "INSERT INTO turma (nome, ano) VALUES ('C2', 'Terceiro'); ",
        "INSERT INTO turma (nome, ano) VALUES ('D1', 'Quarto'); ",
        "INSERT INTO turma (nome, ano) VALUES ('D2', 'Quarto'); ",
        "INSERT INTO turma (nome, ano) VALUES ('E1', 'Quinto'); ",
        "INSERT INTO turma (nome, ano) VALUES ('E2', 'Quinto'); ",
        "INSERT INTO turma (nome, ano) VALUES ('F1', 'Sexto'); ",
        "INSERT INTO turma (nome, ano) VALUES ('F2', 'Sexto'); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00000116647210', 'Gabriel Dewes', 'Diretor(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00001', 'Djian Carvalho Sanchez Stielgmaier Santos', 'Diretor(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00002', 'Gabriela Santos', 'Diretor(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00003', 'Gabriela Fernandes', 'Aluno(a)', 1); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00004', 'Camila Oliveira', 'Aluno(a)', 3); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00005', 'Fernanda Caroline', 'Aluno(a)', 4); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00006', 'Alana Rapariga', 'Aluno(a)', 5); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00007', 'Ramon Lummertz', 'Aluno(a)', 5); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00008', 'Gustavo Nascimento', 'Aluno(a)', 1); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00009', 'Isabele Guilhermina', 'Funcionário(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00010', 'Bruna Meneguel', 'Funcionário(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00011', 'Gabriel Oliveira', 'Diretor(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00012', 'Bruna Gertz', 'Diretor(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00013', 'Thaynara Adriana', 'Aluno(a)', 1); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00014', 'Adriane Mattos', 'Aluno(a)', 3); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00015', 'Andressa Freitas', 'Aluno(a)', 4); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00016', 'Júlio Cesar', 'Aluno(a)', 7); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00017', 'Laura Dewes', 'Aluno(a)', 6); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00018', 'Maria Júlia', 'Aluno(a)', 6); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00019', 'Julia Farias', 'Funcionário(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES ('00020', 'Ana Julia', 'Funcionário(a)', 0); ",
    };
    
    
}
