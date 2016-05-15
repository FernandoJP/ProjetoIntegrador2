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
 * Projeto Integrador II - Agendamento Eletrônico
 * @author Fernando José
 */

public class SQL {
    
    public static void criarTabelas() {
        
        Connection c = null;
        Statement select = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            c.setAutoCommit(false);
            select = c.createStatement();

            //criação da tabela medico
            String sql = "CREATE TABLE IF NOT EXISTS MEDICO"
                    + "(MEDICO_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " NOME CHAR(255),"
                    + " DATA_NASC DATE,"
                    + " APAGAR CHAR,"
                    + " ENDERECO CHAR(255));";
            select.executeUpdate(sql);

            //criação da tabela especialidade
            //sql = "CREATE TABLE IF NOT EXISTS ESPECIALIDADE;";
            //select.executeUpdate(sql);

            //criação da tabela status
            //sql = "CREATE TABLE IF NOT EXISTS STATUS;";
            //select.executeUpdate(sql);

            //criação da tabela agendamento
            sql = "CREATE TABLE IF NOT EXISTS AGENDAMENTO"
                   + "(AGENDAMENTO_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "MEDICO_RESP CHAR(255),"
                    + " PACIENTE CHAR(255),"
                    + " STATUS CHAR(255),"
                    + " OBSERVACOES CHAR(255),"
                    + " DATA_INICIO DATE(255),"
                    + " DATA_FIM DATE(255),"
                    + " SERVICO CHAR(255));";

            select.executeUpdate(sql);
            c.commit();

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
            System.err.println("Erro no método criarTabelas() - "+e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operação feita com sucesso! ");
    }
    
    /*
        Método responsável por editar dados de uma tabela
        @param tabela: qual tabela será editada
        @param codigo: código SQL, deverá conter a instrução INSERT INTO, ex: (n,m)values(1,2)
    */
    public static void setTabela(String tabela, String codigo){
        Connection c = null;
        Statement select = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            c.setAutoCommit(false);
            select = c.createStatement();
            System.out.println("Enviando a seguinte instrução: "+"INSERT INTO "+tabela+"("+ codigo);
            String sql = "INSERT INTO "+tabela+"("+ codigo;
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
            System.err.println("Erro no método criarTabelas() - "+e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operação feita com sucesso! ");
    }
}
