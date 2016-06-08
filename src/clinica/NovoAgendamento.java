package clinica;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando.jpaula2
 */
public class NovoAgendamento extends javax.swing.JFrame {

    SQL sql = new SQL();

    static Connection c = null;
    static Statement select = null;
    Agenda agenda = new Agenda();
    
    public NovoAgendamento() throws SQLException, ClassNotFoundException {
        initComponents();
        setResizable(false);
        SQL sql = new SQL();
        //modificarJComboBox();
        Agenda agenda = new Agenda();
        System.out.println(agenda.getTabela().getModel().getValueAt(1, 1));
    }

    public void modificarJComboBox() {
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

        System.out.println(
                "Operação feita com sucesso! ");
    }

    /*
     Algoritmo executado quando o botão "criar" for clicado
     */
    public void criarAgendamento() {
        /*
         Envio dos valores digitados pelo usuário para a tabela AGENDAMENTO
         setTabela tem dois arguementos: a tabela a ser editada e o script SQL
         */
        SQL.setTabela("AGENDAMENTO", "medico_responsavel, paciente, data_inicio,data_fim, observacoes, status)VALUES("
                + "'" + medico_resp_campo.getEditor().getItem().toString() + "',"
                + "'" + paciente_campo.getText() + "',"
                + "'" + dt_inicio_campo.getText() + "',"
                + "'" + dt_fim_campo.getText() + "',"
                + "'" + obs_campo.getText() + "',"
                + "'" + status_seletor.getSelectedItem() + "');");
        //SQL.setTabela("AGENDAMENTO", "(PACIENTE)VALUES('" + paciente_campo.getText() + "');");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        voltarBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        criar_btn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dt_fim_campo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        status_seletor = new javax.swing.JComboBox<String>();
        dt_inicio_campo = new javax.swing.JTextField();
        paciente_campo = new javax.swing.JTextField();
        obs_campo = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 152, 219));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel4.setBackground(new java.awt.Color(39, 142, 108));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/clinica-logo-branco.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 116));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(871, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(39, 142, 108));
        jLabel3.setText("Novo agendamento");

        voltarBtn.setBackground(new java.awt.Color(255, 255, 255));
        voltarBtn.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        voltarBtn.setForeground(new java.awt.Color(255, 255, 255));
        voltarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinica/img/back-icon.png"))); // NOI18N
        voltarBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        voltarBtn.setBorderPainted(false);
        voltarBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        voltarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        voltarBtn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        voltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBtnActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        criar_btn.setBackground(new java.awt.Color(52, 152, 219));
        criar_btn.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        criar_btn.setForeground(new java.awt.Color(255, 255, 255));
        criar_btn.setText("Criar");
        criar_btn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        criar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criar_btnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Observações");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Data fim:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Status:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Médico responsável:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Paciente:");

        dt_fim_campo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        dt_fim_campo.setForeground(new java.awt.Color(0, 153, 153));
        dt_fim_campo.setText(" ");
        dt_fim_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dt_fim_campoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Data início:");

        status_seletor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paciente atendido", "Cancelado", "Não compareceu" }));
        status_seletor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_seletorActionPerformed(evt);
            }
        });

        dt_inicio_campo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        dt_inicio_campo.setForeground(new java.awt.Color(0, 153, 153));
        dt_inicio_campo.setText(" ");
        dt_inicio_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dt_inicio_campoActionPerformed(evt);
            }
        });

        paciente_campo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        paciente_campo.setForeground(new java.awt.Color(0, 155, 155));
        paciente_campo.setText(" ");
        paciente_campo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        paciente_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paciente_campoActionPerformed(evt);
            }
        });

        obs_campo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        obs_campo.setForeground(new java.awt.Color(0, 153, 153));
        obs_campo.setText(" ");
        obs_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obs_campoActionPerformed(evt);
            }
        });

        String[] medicos = new String[] { agenda.getTabela().getModel().getValueAt(1, 1).toString(), "Item 2", "Item 3", "Item 4" }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(medicos));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addComponent(criar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(obs_campo))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel6))
                            .addGap(4, 4, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dt_inicio_campo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(paciente_campo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dt_fim_campo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status_seletor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(obs_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(dt_fim_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dt_inicio_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(paciente_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status_seletor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(49, 49, 49)
                .addComponent(criar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(voltarBtn))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel3)))
                .addGap(0, 385, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(voltarBtn)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void criar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criar_btnActionPerformed
        criarAgendamento();
        JOptionPane.showMessageDialog(null, "Novo agendamento foi criado com sucesso! clique em OK para ver a agenda.", "Agendamento criado", JOptionPane.PLAIN_MESSAGE);
        //abrir JFrame Agenda
        try {
            new Agenda().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(NovoAgendamento.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoAgendamento.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_criar_btnActionPerformed

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        //abrir JFrame Agenda
        try {
            new Agenda().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(NovoAgendamento.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoAgendamento.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_voltarBtnActionPerformed

    private void dt_inicio_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dt_inicio_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dt_inicio_campoActionPerformed

    private void status_seletorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_seletorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_status_seletorActionPerformed

    private void dt_fim_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dt_fim_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dt_fim_campoActionPerformed

    private void obs_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obs_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obs_campoActionPerformed

    private void paciente_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paciente_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paciente_campoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton criar_btn;
    private javax.swing.JTextField dt_fim_campo;
    private javax.swing.JTextField dt_inicio_campo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField obs_campo;
    private javax.swing.JTextField paciente_campo;
    private javax.swing.JComboBox<String> status_seletor;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
