package clinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Projeto Integrador II - Agendamento Eletrônico
 *
 * @author Fernando José
 */

/*
 Classe responsável por editar valores do arquivo Clinica.sqlite
 */
public class SQL {

    //variáveis globais usadas em todas as funções desta classe
    static Connection c = null;
    static Statement select = null;

    public static void criarTabelas() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
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
                    + " DATA_FIM DATE(255));";

            select.executeUpdate(sql);
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
            System.err.println("Erro no método criarTabelas() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operação feita com sucesso! ");
    }

    /*
     Método responsável por editar dados de uma tabela
     @param tabela: qual tabela será editada
     @param codigo: código SQL, deverá conter a instrução INSERT INTO, ex: (n,m)values(1,2)
     */
    public static void setTabela(String tabela, String codigo) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            select = c.createStatement();
            System.out.println("Enviando a seguinte instrução: " + "INSERT INTO " + tabela + "(" + codigo);
            String sql = "INSERT INTO " + tabela + "(" + codigo;
            System.out.println("ENVIANDO " + "INSERT INTO " + tabela + "(" + codigo);
            select.executeUpdate(sql);
            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println("Erro no método criarTabelas() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operação feita com sucesso! ");
    }

    /*
     método responsável por obter dados da tabela AGENDAMENTO
     @return vetor de ArrayLists, cada índice do vetor tem um ArrayList com uma coluna
     */
    public ArrayList[] retornarDados() throws SQLException, ClassNotFoundException {
        //NÃO REUTILIZAR COLUNA ....... POIS CLEAR N FUNCIONA
        //um ArrayList representa uma coluna do BD, ex: coluna PACIENTE. Tem que ser ArrayList pois não sabemos a qtd de elementos
        ArrayList<String> coluna = new ArrayList<>();
        //vetor com ArrayLists com as 7 colunas, o vetor irá conter todos os dados da tabela AGENDAMENTO. 
        ArrayList[] colunas = new ArrayList[7];

        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
        select = c.createStatement();

        ResultSet rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            coluna.add(rs.getString("MEDICO_RESP"));
        }
        colunas[0] = coluna;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna MEDICO_RESP)
        coluna.removeAll(coluna);
        // coluna.clear();//limpar a coluna para reutilizá-la
        select.close();//para cada loop precisa fechar o select

        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            coluna.add(rs.getString("PACIENTE"));
        }
        colunas[1] = coluna; //armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna PACIENTE)
        coluna.removeAll(coluna);
//coluna.clear();//limpar a coluna para reutilizá-la
        select.close();//para cada loop precisa fechar o select
        /*
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            coluna.add(rs.getString("STATUS"));
        } 
        colunas[2] = coluna;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna STATUS)
        coluna.clear();//limpar a coluna para reutilizá-la
        select.close();//para cada loop precisa fechar o select
        
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            coluna.add(rs.getString("OBSERVACOES"));
        }     
        colunas[3] = coluna;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna OBSERVACOES)
        coluna.clear();//limpar a coluna para reutilizá-la
        select.close();//para cada loop precisa fechar o select
        
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            coluna.add(rs.getString("DATA_INICIO"));
        }      
        colunas[4] = coluna;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna DATA_INICIO)
        coluna.clear();//limpar a coluna para reutilizá-la
        select.close();//para cada loop precisa fechar o select
        
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            coluna.add(rs.getString("DATA_FIM"));
        }
        colunas[5] = coluna;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna DATA_FIM)
        coluna.clear();//limpar a coluna para reutilizá-la
        select.close();//para cada loop precisa fechar o select
        
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            coluna.add(rs.getString("SERVICO"));
        }
        colunas[6] = coluna;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna SERVICO)
        select.close();
         */
        c.close();

        return colunas;
    }
}
