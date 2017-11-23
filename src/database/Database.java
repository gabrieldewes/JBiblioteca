/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class Database {
    
    private static final Logger log = Logger.getLogger(Database.class.getName());
    
    public static final java.io.File DATABASE = new java.io.File(System.getProperty("user.home")
            + System.getProperty("file.separator") + ".jbiblioteca"
            + System.getProperty("file.separator") + "jbiblioteca_db.db");
    
    public static java.io.File DATABASE_BKP = new java.io.File(System.getProperty("user.home")
            + System.getProperty("file.separator") + ".jbiblioteca"
            + System.getProperty("file.separator") + "jbiblioteca_bkp.db");
    
    public static void checkDatabase() throws Exception {
        if (!DATABASE.exists()) {
            createNewDatabase();
            JOptionPane.showMessageDialog(null, "Seja bem-vindo(a) à JBiblioteca! Aplicação instalada e pronta para uso.", "JBiblioteca", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void backupDatabase() throws Exception {
        if (!DATABASE.exists()) {
            checkDatabase();
        }
        if (!DATABASE_BKP.isDirectory() && !DATABASE_BKP.getName().toLowerCase().endsWith(".db")) {
            DATABASE_BKP = new File(DATABASE_BKP.getPath() + ".db");
        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            int size = 1;
            bis = new BufferedInputStream(new FileInputStream(DATABASE), size);
            bos = new BufferedOutputStream(new FileOutputStream(DATABASE_BKP), size);
            int byteLido; 
            while ( (byteLido = bis.read()) != -1 ) {
                bos.write(byteLido);
            }
        } finally {
            if (bos != null) {
                bos.flush();
                bos.close();
            }
            if (bis != null) {
                bis.close();
            }
        }
    }

    public static void recoverBackupDatabase() throws Exception {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int size = 1;
        try {
            bis = new BufferedInputStream(new FileInputStream(DATABASE_BKP), size);
            bos = new BufferedOutputStream(new FileOutputStream(DATABASE), size);
            int byteLido;
            while ((byteLido = bis.read()) != -1) {
                bos.write(byteLido);
            }
        } finally {
            if (bos != null) {
                bos.flush();
                bos.close();
            }
            if (bis != null) {
                bis.close();
            }
        }
    }
    
    public static void createNewDatabase() throws Exception {
        try {
            DATABASE.getParentFile().mkdirs(); /* Cria os diretórios pai do arquivo (caso não existam) */
            DATABASE.createNewFile();          /* Cria o arquivo do banco */
            if (!DATABASE.exists()) {          /* Caso o arquivo ainda não exista, após os comandos acima, dispara exceção */
                throw new Exception("Erro ao gravar o arquivo de banco de dados");
            }
            DBUtil.createDDL();
            log.log(Level.INFO, "Banco de dados criado em {0}", DATABASE.getAbsolutePath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na criação do banco de dados. ERRO: " + ex.getMessage(), "JBiblioteca", 0);
            throw new Exception("Erro na criação do banco de dados.\n"+ ex.getMessage());
        }
    }
    
}
