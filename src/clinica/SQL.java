package clinica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

    /*
     Método responsável por converter um arquivo TXT especificado via parâmetro para String
     @param caminho - onde o arquivo TXT está
     @return - string com os dados do TXT
     */
    public static String txtParaString(String caminho) {
        try {
            File file = new File("src\\clinica\\sql\\DDL-DML.txt");//txt que contém comandos DDL e DML
            //ISO-8859-1 para ler as acentuações corretamente:
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Erro";
    }

    /*
     Método responsável por obter todos os comandos SQL do arquivo TXT e converter para o arquivo de BD Clinica.sqlite
     */
    public static void criarTabelas() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            select = c.createStatement();
            select.executeUpdate(txtParaString("src\\clinica\\sql\\DDL-DML.txt"));

            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println("Erro no método criarTabelas() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
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
            String sql = "INSERT INTO " + tabela + "(" + codigo;
            select.executeUpdate(sql);
            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println("Erro no método setTabela() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /*
     método responsável por obter dados da tabela AGENDAMENTO
     @return vetor de ArrayLists, cada índice do vetor tem um ArrayList com uma coluna
     */
    public ArrayList[] retornarDados() throws SQLException, ClassNotFoundException {
        //um ArrayList representa uma coluna do BD, ex: coluna PACIENTE. Tem que ser ArrayList pois não sabemos a qtd de elementos
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> medicoResp = new ArrayList<>();
        ArrayList<String> paciente = new ArrayList<>();
        ArrayList<String> dataInicio = new ArrayList<>();
        ArrayList<String> dataFim = new ArrayList<>();
        ArrayList<String> observacoes = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        //vetor com ArrayLists com as 7 colunas, o vetor irá conter todos os dados da tabela AGENDAMENTO. 
        ArrayList[] colunas = new ArrayList[7];

        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
        select = c.createStatement();

        //ADICIONAR TODOS OS IDS NO ARRAYLIST 'id'
        ResultSet rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            id.add(rs.getString("agendamento_id"));
        }
        colunas[0] = id;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna MEDICO_RESP)
        select.close();//para cada loop precisa fechar o select
        
        //ADICIONAR TODOS OS MÉDICOS NO ARRAYLIST 'medicoResp'
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            medicoResp.add(rs.getString("medico_responsavel"));
        }
        colunas[1] = medicoResp;//armazenar no vetor de ArrayLists o primeiro ArrayList (dados da coluna MEDICO_RESP)
        select.close();//para cada loop precisa fechar o select

        //ADICIONAR TODOS OS PACIENTES NO ARRAYLIST 'paciente'
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            paciente.add(rs.getString("paciente"));
        }
        colunas[2] = paciente;
        select.close();

        //ADICIONAR TODAS AS DATAS DE INÍCIO NO ARRAYLIST 'dataInicio'
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            dataInicio.add(rs.getString("data_inicio"));
        }
        colunas[3] = dataInicio;
        select.close();

        //ADICIONAR TODAS AS DATAS FIM NO ARRAYLIST 'dataFim'
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            dataFim.add(rs.getString("data_fim"));
        }
        colunas[4] = dataFim;
        select.close();

        //ADICIONAR TODAS AS OBSERVACOES NO ARRAYLIST 'observacoes'
        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            observacoes.add(rs.getString("observacoes"));
        }
        colunas[5] = observacoes;
        select.close();

        rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
        while (rs.next()) {
            status.add(rs.getString("status"));
        }
        colunas[6] = status;
        select.close();

        c.close();
        return colunas;
    }

    /*
     Método responsável por obter os nomes de todos os médicos ou pacientes
     @param String que deve conter ou 'medico' ou 'paciente'
     @return Array de tamanho correto com todos os nomes de médicos ou pacientes cadastrados via comando insert into
     */
    public static String[] retornarNomes(String medicoOuPaciente) throws SQLException, ClassNotFoundException {

        ArrayList<String> nomesArrayList = new ArrayList<>();
        ResultSet rs = null;

        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
        select = c.createStatement();

        if (medicoOuPaciente.equalsIgnoreCase("medico")) { //se o valor passado via parâmetro for 'medico'
            rs = select.executeQuery("SELECT * FROM MEDICO;"); //selecione a tabela MEDICO
        } else if (medicoOuPaciente.equalsIgnoreCase("paciente")) { //se o valor passado via parâmetro for 'paciente'
            rs = select.executeQuery("SELECT * FROM PACIENTE;"); //selecione a tabela PACIENTE
        }
        if (medicoOuPaciente.equalsIgnoreCase("medico")) { //se o valor passado via parâmetro for 'medico'
            while (rs.next()) {
                nomesArrayList.add(rs.getString("nome_medico")); //adicione no ArrayList nomes de médicos
            }
        } else if (medicoOuPaciente.equalsIgnoreCase("paciente")) { //se o valor passado via parâmetro for 'paciente'
            while (rs.next()) {
                nomesArrayList.add(rs.getString("nome_paciente")); //adicione no ArrayList nomes de pacientes
            }
        }

        //converter arraylist para vetor pois a função deve retornar um vetor:
        String[] nomes = nomesArrayList.toArray(new String[nomesArrayList.size()]);
        select.close();
        c.close();
        return nomes;
    }
    
    /*
        Método responsável por remover um registro do BD
        @param comando é a instrução SQL. Ex: delete from agendamento
    */
    public static void removerRegistro(String comando) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            select = c.createStatement();
            select.executeUpdate(comando);

            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println("Erro no método criarTabelas() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
