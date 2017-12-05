package com.jbiblioteca.data;

import com.jbiblioteca.api.JBibliotecaResource;
import com.jbiblioteca.dao.ConfigDAO;
import com.jbiblioteca.dao.GenericDAO;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Dewes
 */
public class DBUtil {
    
    public static String VER_2[] =  { "emprestimo", "deleted", "BLOB NOT NULL DEFAULT 0", "0" };
    public static String VER_3[] =  { "emprestimo_livro", "deleted", "BLOB NOT NULL DEFAULT 0", "0" };
    
    public static String[] selectScript(int ver) {
        switch (ver) {
        case 2: 
            return VER_2;
        case 3: 
            return VER_3;
        default:
            return null;         
        }
    }
    
    public static void checkDatabase() {
        Database.checkDatabase();
    }
    
    public static boolean backupDatabase() {
        try {
            synchronized(Database.class) {
                Database.backupDatabase();
                LocalDateTime hoje = LocalDateTime.now();
                return GenericDAO.getInstance().update("app_config", "last_backup", "'" + hoje.toString() + "'");
            }
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static String remoteBackupDatabase() {
        String result = JBibliotecaResource.getInstance()
                .uploadFile(Database.DATABASE_BKP);
        return result;
    }
    
    public static boolean recoverLocalBackup() {
        try {
            synchronized(Database.class) {
                Database.recoverBackupDatabase();
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static void updateDDL(int newVersion) {     
        int oldVersion = ConfigDAO.getInstance().getDBVersion();
        if (oldVersion < newVersion) {
            DBHelper db = DBHelper.getInstance();
            db.onUpgrade(db, oldVersion, newVersion);
        }
    }
    
    public static void createDDL() {
        DBHelper db = DBHelper.getInstance();
        db.rawLineSQL(create_ddl);
        
    }
    
    public static void dropDDL() {
        DBHelper db = DBHelper.getInstance();
        db.rawLineSQL(drop_ddl);
    }
    
    public static void populate() {
        DBHelper db = DBHelper.getInstance();
        db.rawLineSQL(insert_data);
    }
    
    public static void clear() {
        DBHelper db = DBHelper.getInstance();
        db.rawLineSQL(clear_data);
    }
    
    static String[] create_ddl = {
        "CREATE TABLE IF NOT EXISTS turma ( "+
            "id_turma INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "ano TEXT, "+
            "nome TEXT NOT NULL);",
        
        "CREATE TABLE IF NOT EXISTS pessoa ("+
            "id_pessoa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "id_turma  INTEGER NOT NULL, "+
            "nome TEXT DEFAULT 'Sem Nome', "+
            "cargo TEXT, "+
            "codigo TEXT NOT NULL UNIQUE, "+
            "FOREIGN KEY (id_turma) REFERENCES turma(id_turma) ON UPDATE CASCADE ON DELETE RESTRICT );", 
        
        "CREATE TABLE IF NOT EXISTS livro ("+
            "id_livro INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "isbn TEXT NOT NULL, "+
            "titulo TEXT NOT NULL DEFAULT 'Sem título', "+
            "autor TEXT NOT NULL);",
        
        "CREATE TABLE IF NOT EXISTS exemplar ("+
            "id_exemplar INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "codigo TEXT NOT NULL UNIQUE, "+
            "disponivel TEXT NOT NULL, "+
            "coordenada_x TEXT NOT NULL, "+
            "coordenada_y TEXT NOT NULL, "+
            "id_livro INTEGER NOT NULL, "+
            "FOREIGN KEY (id_livro) REFERENCES livro(id_livro) ON UPDATE CASCADE ON DELETE CASCADE);",
        
        "CREATE TABLE IF NOT EXISTS emprestimo ( "+
            "id_emprestimo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "id_pessoa INTEGER NOT NULL, "+
            "data_inicio TEXT NOT NULL, "+
            "data_fim TEXT, "+
            "situation TEXT, "+
            "deleted BLOB NOT NULL, "+
            "FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa));",
        
        "CREATE TABLE IF NOT EXISTS emprestimo_livro ( "+
            "id_emprestimo INTEGER NOT NULL, "+
            "id_exemplar INTEGER NOT NULL, "+
            "deleted BLOB NOT NULL, "+
            "PRIMARY KEY(id_emprestimo,id_exemplar), "+
            "FOREIGN KEY(id_emprestimo) REFERENCES emprestimo(id_emprestimo), "+
            "FOREIGN KEY(id_exemplar) REFERENCES exemplar(id_exemplar));",
        
        "CREATE TABLE IF NOT EXISTS app_config ( "+
            "taxa_juros REAL,"+
            "last_backup TEXT, "+
	    "db_version	INTEGER, "+
            "prazo_default INTEGER, "+
            "auto_bkp BLOB );",
        
        "INSERT INTO app_config (taxa_juros, db_version, prazo_default, auto_bkp) VALUES (0.25, 0, 7, 1);"
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
    
    static String[] insert_data = {
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'Alice no pais das maravilhas', ''); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'Água para elefantes', 'Sara Cruen'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'Sol e Lua', 'Signos'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'O avantajado livro de pensamentos do cassera & planeta', 'Casseta e Planeta'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'As melhores piadas do planeta e do casseta também', 'Casseta e Planeta'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'A Cabana', 'Artista desconhecido'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'Cidades de Papel', 'Albert richerd'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'Estrelas de Biscoito', 'Artista aluado'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'Como criar uma mente', 'Algum engenheiro da google'); ",
        "INSERT INTO livro (isbn, titulo, autor) VALUES ('', 'Forest gump é mato', 'Racionais'); ",
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
        "INSERT INTO turma (nome) VALUES ('A1'); ",
        "INSERT INTO turma (nome) VALUES ('A2'); ",
        "INSERT INTO turma (nome) VALUES ('B1'); ",
        "INSERT INTO turma (nome) VALUES ('B2'); ",
        "INSERT INTO turma (nome) VALUES ('C1'); ",
        "INSERT INTO turma (nome) VALUES ('C2'); ",
        "INSERT INTO turma (nome) VALUES ('D1'); ",
        "INSERT INTO turma (nome) VALUES ('D2'); ",
        "INSERT INTO turma (nome) VALUES ('E1'); ",
        "INSERT INTO turma (nome) VALUES ('E2'); ",
        "INSERT INTO turma (nome) VALUES ('F1'); ",
        "INSERT INTO turma (nome) VALUES ('F2'); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00000116647210', 'Gabriel Dewes', 'Diretor(a)', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00001', 'Djian Carvalho Sanchez Stielgmaier Santos', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00002', 'Gabriela Santos', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00003', 'Gabriela Fernandes', 1); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00004', 'Camila Oliveira', 3); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00005', 'Fernanda Caroline', 4); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00006', 'Alana Rapariga', 5); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00007', 'Ramon Lummertz', 5); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00008', 'Gustavo Nascimento', 1); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00009', 'Isabele Guilhermina', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00010', 'Bruna Meneguel', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00011', 'Gabriel Oliveira', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00012', 'Bruna Gertz', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00013', 'Thaynara Adriana', 1); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00014', 'Adriane Mattos', 3); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00015', 'Andressa Freitas', 4); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00016', 'Júlio Cesar', 7); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00017', 'Laura Dewes', 6); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00018', 'Maria Júlia', 6); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00019', 'Julia Farias', 0); ",
        "INSERT INTO pessoa (codigo, nome, id_turma) VALUES ('00020', 'Ana Julia', 0); ",
    };
    
}
