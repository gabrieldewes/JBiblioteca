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
    
    public static void checkDatabase() throws Exception {
        if (!DATABASE.exists()) {
            createNewDatabase();
            JOptionPane.showMessageDialog(null, "Seja Bem-vindo(a) à JBiblioteca!", "JBiblioteca", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /* Cria um backup do banco de dados.
     * O parâmetro arquivo_dkp é o novo arquivo que receberá os dados de backup. 
    */
    public static void backupDatabase(File arquivo_dkp) throws Exception {
        if (!DATABASE.exists()) {
            checkDatabase();
        }
        if (!arquivo_dkp.isDirectory() && !arquivo_dkp.getName().toLowerCase().endsWith(".db")) {
            arquivo_dkp = new File(arquivo_dkp.getPath() + ".db");
        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            int BUFFER=1;
            bis = new BufferedInputStream(new FileInputStream(DATABASE), BUFFER);
            bos = new BufferedOutputStream(new FileOutputStream(arquivo_dkp), BUFFER);
            int byteLido; 
            while ((byteLido = bis.read()) != -1)
            {
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
    /* Recupera o backup e salva por cima do arquivo de banco de dados DATABASE. */
    public static void recoverBackupDatabase(File arquivo_bkp) throws Exception {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int BUFFER=1;
        try {
            bis = new BufferedInputStream(new FileInputStream(arquivo_bkp), BUFFER);
            bos = new BufferedOutputStream(new FileOutputStream(DATABASE), BUFFER);
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
                throw new Exception("Erro ao gravar o arquivo de banco de dados.");
            }
            DBUtil.createDDL();
            log.log(Level.INFO, "Banco de dados criado em '{0}' ", DATABASE.getAbsolutePath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na criação do banco de dados. ERRO: "+ ex.getMessage(), "JBiblioteca", 0);
            throw new Exception("Erro na criação do banco de dados.\n"+ ex.getMessage());
        }
    }
    
}
