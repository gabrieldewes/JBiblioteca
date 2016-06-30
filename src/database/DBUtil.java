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
            //"PRIMARY KEY(id_emprestimo,id_pessoa), "+
            "FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa)); ",
        
        "CREATE TABLE IF NOT EXISTS emprestimo_livro ( "+
            "id_emprestimo	INTEGER NOT NULL, "+
            "id_exemplar	INTEGER NOT NULL, "+
            "PRIMARY KEY(id_emprestimo,id_exemplar), "+
            "FOREIGN KEY(id_emprestimo) REFERENCES emprestimo(id_emprestimo), "+
            "FOREIGN KEY(id_exemplar) REFERENCES exemplar(id_exemplar) ); "    
    };
    
    static String[] drop_ddl = {
        "DROP TABLE IF EXISTS pessoa; ",
        "DROP TABLE IF EXISTS livro; ",
        "DROP TABLE IF EXISTS turma; ",
        "DROP TABLE IF EXISTS exemplar; ",
        "DROP TABLE IF EXISTS emprestimo_livro; ",
        "DROP TABLE IF EXISTS emprestimo; "
    };
    
    static String[] clear_data = {
        "DELETE FROM pessoa; ",
        "DELETE FROM livro; ",
        "DELETE FROM turma; ",
        "DELETE FROM exemplar; ",
        "DELETE FROM emprestimo_livro; ",
        "DELETE FROM emprestimo; "
    };
    
    public void createDDL() {
        try {
            DBHelper db = new DBHelper();
            db.rawLineSQL(create_ddl);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void dropDDL() {
        try {
            DBHelper db = new DBHelper();
            db.rawLineSQL(drop_ddl);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populate() {
        try {
            DBHelper db = new DBHelper();
            db.rawExternalSQL("insert.sql");
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clear() {
        try {
            DBHelper db = new DBHelper();
            db.rawLineSQL(clear_data);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onUpgrade(DBHelper db, int oldVersion, int newVersion) {
        String vers[];
        try {
            for (int i=oldVersion; i<newVersion; i++) {
                vers = DBUtil.selectScript(i);
                DBUtil.updateTabelasBanco(db, vers[0], vers[1], vers[2], vers[3]);
            }

        } catch (Exception e) {
        }
    }
    
    public static String VER_1[] =  {"pessoa", "generated", "TEXT", "gabriel"};
    public static String[] selectScript(int ver){
        switch (ver) {
        case 1:
            return VER_1;
        default:
            return null;         
        }

    }
    
    public static void updateTabelasBanco(DBHelper db, String table, String column, String typ, String valor) {
        try {
            db.rawSQL("ALTER TABLE " + table + " ADD " + column + " " + typ);
            if (!"".equals(valor)){
                db = new DBHelper();
                db.rawSQL("UPDATE "+ table +" SET "+ column +" = '"+ valor +"'");
            }
        } catch (Exception e) {
        }
    }
    
}
