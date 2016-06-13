package clinica;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Projeto Integrador II - Agendamento Eletrônico
 * @author Fernando José
 */
public class Agenda extends javax.swing.JFrame {

    //arrumar pois agenda() não pode fazer tudo
    Connection c = null;
    Statement select = null;
    SQL sql = new SQL();

    public Agenda() throws SQLException, ClassNotFoundException {
        initComponents();
        setResizable(false);
        configurarJTable();
    }

    /*
     Função para alterar o layout e fazer ajustes no JTable que contém a agenda
     */
    public void configurarJTable() {
        Tabela.getColumnModel().getColumn(0).setPreferredWidth(15); //diminuir largura da coluna ID
        popularJTable();
        configurarQtdeDeLinhas();
    }

    /*
        Método responsável por aumentar ou diminuir a quantidade de linhas do JTable, conforme a quantidade de agendamentos cadastrados
    */
    public void configurarQtdeDeLinhas() {
        DefaultTableModel dtm = (DefaultTableModel) Tabela.getModel();
        int key = 0; //0 para não dar exception variável não inicializada
        for (int j = Tabela.getRowCount() - 1; j >= 0; j--) {
            //Ler desde a última posição da tabela até a primeira: 
            //se o valor não for nulo então a posição j é o tamanho de elementos válidos da tabela
            if (Tabela.getModel().getValueAt(j, 0) != null) { //0 é a linha, j é a coluna
                key = j;
                break;
            }
            dtm.setRowCount(j);
        }
        Tabela.setModel(dtm);
    }

    /*
     Método responsável que juntamente com as funções da classe SQL insere dados da tabela AGENDAMENTO para o JTable
     */
    public void popularJTable() {
        int cont = 0;
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
                Tabela.setValueAt(sql.retornarDados()[6].get(cont), cont, 6);
                cont++;
            }

            rs.close();
            select.close();
            c.close();
        } catch (Exception e) {
            System.err.println("Erro no método popularJTable() - " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public JTable getTabela() {
        return Tabela;
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
        novoAgendBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        removerRegistroBtn = new javax.swing.JButton();
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
        jLabel3.setText("Agenda");

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
                .addGap(176, 176, 176)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

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

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", null, null, "", null},
                {null, "", "", null, null, "", null},
                {null, "", "", null, null, "", null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Médico Responsável", "Paciente", "Data Início", "Data Fim", "Observações", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabela.setToolTipText("");
        Tabela.setFocusable(false);
        Tabela.setGridColor(new java.awt.Color(180, 129, 129));
        jScrollPane1.setViewportView(Tabela);

        removerRegistroBtn.setBackground(new java.awt.Color(228, 238, 238));
        removerRegistroBtn.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        removerRegistroBtn.setForeground(new java.awt.Color(102, 102, 102));
        removerRegistroBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/apagar-icone.png"))); // NOI18N
        removerRegistroBtn.setText("Remover Registro");
        removerRegistroBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        removerRegistroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRegistroBtnActionPerformed(evt);
            }
        });

        Descricao.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        Descricao.setForeground(new java.awt.Color(102, 102, 102));
        Descricao.setText("Visualize a agenda completa de cada médico. Você pode apagar agendamentos ou ir para o formulário de criação de agendamentos ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(482, 482, 482)
                            .addComponent(novoAgendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(removerRegistroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Descricao))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoAgendBtn)
                    .addComponent(removerRegistroBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(273, 273, 273))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE))
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
                    Logger.getLogger(Agenda.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Agenda.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
                dispose();
            }
        });
    }//GEN-LAST:event_novoAgendBtnActionPerformed


    private void removerRegistroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRegistroBtnActionPerformed
        //algoritmo para remover a linha selecionada na tabela ao clicar no botão de remoção

        //apagar do Banco de dados
        SQL.removerRegistro("DELETE FROM AGENDAMENTO WHERE AGENDAMENTO_ID = " + Tabela.getValueAt(Tabela.getSelectedRow(), 0));

        //deletar do JTable
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
    }//GEN-LAST:event_removerRegistroBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Agenda().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Agenda.class
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton novoAgendBtn;
    private javax.swing.JButton removerRegistroBtn;
    // End of variables declaration//GEN-END:variables
}
