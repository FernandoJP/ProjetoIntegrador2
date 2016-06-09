package clinica;

import static clinica.SQL.c;
import java.sql.*;
import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Projeto Integrador II - Agendamento Eletrônico
 *
 * @author Fernando José
 */
public class Relatorio2 extends javax.swing.JFrame {

    //arrumar pois agenda() não pode fazer tudo
    public Relatorio2() throws SQLException, ClassNotFoundException {
        

        Connection c = null;
        Statement select = null;
        int cont = 0;
        initComponents();
        setResizable(false);
        atualizarTamanhoJtable();
        SQL sql = new SQL();

        //Atribuir na posição 0,0 da tabela o arrayList da função retornar
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            select = c.createStatement();

            //código para inserir valores nas tabelas
            ResultSet rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");

            //enquanto existir linhas na tabela AGENDAMENTO, atribua no JTable
            //a função retornarDados retorna um arrayList
            //get(cont) = função do arrayList que permite obter valores do array
            //Estrutura do retorno de retornarDados(): Array = [ArrayList medicoResp, ArrayList Paciente, ArrayList dataInicio, ArrayList dataFim, ArrayList status]
            while (rs.next()) {
                Tabela.setValueAt(sql.retornarDados()[0].get(cont), cont, 0);
                Tabela.setValueAt(sql.retornarDados()[1].get(cont), cont, 1);
                Tabela.setValueAt(sql.retornarDados()[2].get(cont), cont, 2);
                Tabela.setValueAt(sql.retornarDados()[3].get(cont), cont, 3);
                Tabela.setValueAt(sql.retornarDados()[4].get(cont), cont, 4);
                Tabela.setValueAt(sql.retornarDados()[5].get(cont), cont, 5);
                cont++;
            }

            rs.close();
            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println("Erro no Agenda() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } 
    }

    public JTable getTabela() {
        return Tabela;
    }

    private void atualizarTamanhoJtable(){
    for (int row = 0; row < Tabela.getRowCount(); row++)
    {
        int rowHeight = Tabela.getRowHeight();

        for (int column = 0; column < Tabela.getColumnCount(); column++)
        {
            Component comp = Tabela.prepareRenderer(Tabela.getCellRenderer(row, column), row, column);
            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
        }

        Tabela.setRowHeight(row, rowHeight);
    }
}
    
    /*  
     Método resposável por obter dados vindos da classe SQL e jogar estes dados no JTable
     Tudo que for relativo a obtenção e atribuição de dados em SQL será de responsabilidade da classe SQL
     Contudo o método atualizarJTable() é uma exceção
     */
    public void atualizarJTable(String medicoResp, String paciente, String status, String observacoes, String dataInicio, String dataFim) throws SQLException, ClassNotFoundException {
        Connection c = null;
        Statement select = null;
        Relatorio2 agenda = new Relatorio2();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\clinica\\sql\\Clinica.sqlite");
            select = c.createStatement();

            ResultSet rs = select.executeQuery("SELECT * FROM AGENDAMENTO;");
            Tabela.setValueAt(new Integer(2), 1, 1);
            for (int i = 0; i < 50; i++) { //50 pois é o número máx de linhas         
                while (rs.next()) {
                    Tabela.setValueAt(medicoResp, i, 0);
                    Tabela.setValueAt(paciente, i, 1);
                    Tabela.setValueAt(status, i, 2);
                    Tabela.setValueAt(observacoes, i, 3);
                    Tabela.setValueAt(dataInicio, i, 4);
                    Tabela.setValueAt(dataFim, i, 5);
                    Tabela.setValueAt("blablabla", 1, 5);
                }
                //rs.close();
                //select.close();
                c.close();
            }
        } catch (Exception e) {
            System.err.println("Erro no método atualizarJTable() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        novoAgendBtn = new javax.swing.JButton();
        relatorioBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        relatorioBtn1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        Descricao = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        jButton7.setBackground(new java.awt.Color(52, 152, 219));
        jButton7.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Fazer Login");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("17/04");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Segunda");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 152, 219));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1024, 768));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(39, 142, 108));
        jLabel3.setText("Relatório");

        jPanel4.setBackground(new java.awt.Color(39, 142, 108));

        jLabel1.setMaximumSize(new java.awt.Dimension(200, 116));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/clinica-logo-branco.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(200, 116));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/apagar-icone.png"))); // NOI18N

        novoAgendBtn.setBackground(new java.awt.Color(228, 238, 238));
        novoAgendBtn.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        novoAgendBtn.setForeground(new java.awt.Color(102, 102, 102));
        novoAgendBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/novo-agendamento-icon.png"))); // NOI18N
        novoAgendBtn.setText("Novo agendamento");
        novoAgendBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        novoAgendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoAgendBtnActionPerformed(evt);
            }
        });

        relatorioBtn.setBackground(new java.awt.Color(228, 238, 238));
        relatorioBtn.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        relatorioBtn.setForeground(new java.awt.Color(102, 102, 102));
        relatorioBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/relatorios-icon.png"))); // NOI18N
        relatorioBtn.setText("Gerar relatório");
        relatorioBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        relatorioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioBtnActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null, "", null},
                {"", "", null, null, "", null},
                {"", "", null, null, "", null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Médico Responsável", "Paciente", "Data Início", "Data Fim", "Observações", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabela.setToolTipText("");
        jScrollPane1.setViewportView(Tabela);

        relatorioBtn1.setBackground(new java.awt.Color(228, 238, 238));
        relatorioBtn1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        relatorioBtn1.setForeground(new java.awt.Color(102, 102, 102));
        relatorioBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/apagar-icone.png"))); // NOI18N
        relatorioBtn1.setText("Remover Registro");
        relatorioBtn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        relatorioBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioBtn1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Remover no BD");

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 153, 153));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 153, 153));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Médico responsável:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Data início:");

        jTextField5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 153, 153));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Status:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paciente atendido", "Não compareceu" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Data fim:");

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Serviço:");

        jButton8.setBackground(new java.awt.Color(57, 105, 138));
        jButton8.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Gerar Relatório");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        Descricao.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        Descricao.setForeground(new java.awt.Color(102, 102, 102));
        Descricao.setText("Obtenha dados sobre agendamentos, inserindo um filtro por meio do formulário a seguir.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(863, 863, 863)
                        .addComponent(jLabel44))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1284, 1284, 1284)
                                .addComponent(novoAgendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(relatorioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(relatorioBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Descricao)
                            .addComponent(jLabel3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoAgendBtn)
                    .addComponent(relatorioBtn)
                    .addComponent(relatorioBtn1)
                    .addComponent(jLabel4)
                    .addComponent(Descricao))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(jLabel44)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 2016, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void novoAgendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoAgendBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NovoAgendamento().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(Relatorio2.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Relatorio2.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_novoAgendBtnActionPerformed

    private void relatorioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioBtnActionPerformed
        new Relatorio().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_relatorioBtnActionPerformed

    private void relatorioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioBtn1ActionPerformed
        //algoritmo para remover a linha selecionada na tabela ao clicar no botão de remoção
        DefaultTableModel model = (DefaultTableModel) Tabela.getModel();
        int[] rows = Tabela.getSelectedRows();
        TableModel tm = Tabela.getModel();
        while (rows.length > 0) {
            ((DefaultTableModel) tm).removeRow(Tabela.convertRowIndexToModel(rows[0]));
            rows = Tabela.getSelectedRows();
        }
        Tabela.clearSelection();
        for (int row : rows) {
            model.removeRow(Tabela.convertRowIndexToModel(row));
        }
        Tabela.clearSelection();
    }//GEN-LAST:event_relatorioBtn1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SQL sql = new SQL();
        sql.criarTabelas();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Relatorio2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Relatorio2().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(Relatorio2.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Relatorio2.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao;
    private javax.swing.JTable Tabela;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton novoAgendBtn;
    private javax.swing.JButton relatorioBtn;
    private javax.swing.JButton relatorioBtn1;
    // End of variables declaration//GEN-END:variables
}
