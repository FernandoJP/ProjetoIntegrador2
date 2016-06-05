package clinica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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

    /*
        Método responsável por converter um arquivo TXT especificado via parâmetro para String
        @param caminho - onde o arquivo TXT está
        @return - string com os dados do TXT
     */
    public static String txtParaString(String caminho) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(caminho));
            return scanner.useDelimiter("\\A").next();
    }

    public static String readFile(String caminho) throws IOException {

        File txt = new File(caminho);
        StringBuilder fileContents = new StringBuilder((int) txt.length());
        Scanner scanner = new Scanner(txt);
        String lineSeparator = System.getProperty("line.separator");
        try {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString() + "bosta";
        } finally {
            scanner.close();
        }
    }

    public static void criarTabelas() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            select = c.createStatement();
            select.executeUpdate(txtParaString("src\\clinica\\sql\\Clinica_DDL.txt"));
            System.out.println(readFile("src\\clinica\\sql\\Clinica_DML.txt"));

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
            System.err.println("Erro no método setTabela() - " + e.getClass().getName() + ": " + e.getMessage());
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
        ArrayList<String> especialidade = new ArrayList<>();
        ArrayList<String> medico = new ArrayList<>();
        ArrayList<String> agendamento = new ArrayList<>();
        ArrayList<String> unidade = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        ArrayList<String> paciente = new ArrayList<>();
        //vetor com ArrayLists com as 7 colunas, o vetor irá conter todos os dados da tabela AGENDAMENTO. 
        ArrayList[] colunas = new ArrayList[7];

        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
        select = c.createStatement();

        ResultSet rs = select.executeQuery("SELECT * FROM MEDICO;");
        while (rs.next()) {
            medico.add(rs.getString("NOME"));
        }
        colunas[0] = medico;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna MEDICO_RESP)
        select.close();//para cada loop precisa fechar o select

        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            agendamento.add(rs.getString("AGENDAMENTO_ID"));
        }
        colunas[1] = agendamento; //armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna PACIENTE)
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
