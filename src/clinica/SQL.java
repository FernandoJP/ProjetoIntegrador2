/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author fernando.jpaula2
 */
public class SQL {
    public static void criarTabelas() {
        Connection c = null;
        Statement select = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\fernando.jpaula2\\Documents\\NetBeansProjects\\JavaApplication1\\src\\clinica\\sql\\Clinica.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            select = c.createStatement();

            //criação da tabela medico
            String sql = "CREATE TABLE IF NOT EXISTS MEDICO"
                    + "(CPF INT PRIMARY KEY,"
                    + " NOME CHAR(50),"
                    + " DATA_NASC DATE,"
                    + " ENDERECO CHAR(50));";
            select.executeUpdate(sql);

            //criação da tabela especialidade
            //sql = "CREATE TABLE IF NOT EXISTS ESPECIALIDADE;";
            //select.executeUpdate(sql);

            //criação da tabela status
            //sql = "CREATE TABLE IF NOT EXISTS STATUS;";
            //select.executeUpdate(sql);

            //criação da tabela agendamento
            sql = "CREATE TABLE IF NOT EXISTS AGENDAMENTO"
                   + "(AGENDAMENTO_ID INT PRIMARY KEY,"
                    + "MEDICO_RESP CHAR(50),"
                    + " STATUS CHAR(50),"
                    + " OBSERVACOES CHAR(50),"
                    + " DATA_INICIO DATE(50),"
                    + " DATA_FIM DATE(50),"
                    + " SERVICO CHAR(50));";

            select.executeUpdate(sql);
            c.commit();

            /* código para inserir valores nas tabelas
             ResultSet rs = select.executeQuery("SELECT * FROM teste;");
             while (rs.next()) {
             int id = rs.getInt("ENDERECO");
             String name = rs.getString("NOME");
             int age = rs.getInt("IDADE");
             System.out.println("ID = " + id);
             System.out.println("NAME = " + name);
             System.out.println("AGE = " + age);
             System.out.println();
             }       
             rs.close();
             */
            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operação feita com sucesso! ");
    }
    
    public static void setTabela(String tabela, String valor){
        Connection c = null;
        Statement select = null;
        try {
            ResultSet rs = select.executeQuery("SELECT * FROM "+tabela+";");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\fernando.jpaula2\\Documents\\NetBeansProjects\\JavaApplication1\\src\\clinica\\sql\\Clinica.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            select = c.createStatement();

            //criação da tabela medico
            String sql = "INSERT INTO "+tabela+"(";
            select.executeUpdate(sql);
  
            select.executeUpdate(sql);
            c.commit();
            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operação feita com sucesso! ");
    }
}
