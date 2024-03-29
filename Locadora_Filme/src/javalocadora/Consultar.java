/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalocadora;

import Locadora.dao.ClienteDao;
import Locadora.dao.LocacaoDao;
import Locadora.modelo.Cliente;
import Locadora.modelo.Locacao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */
public class Consultar extends javax.swing.JFrame {

    /**
     * Creates new form Consultar
     */
    public Consultar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cons = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_busca = new javax.swing.JTextField();
        cb_busca = new javax.swing.JComboBox<>();
        btn_voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_cons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FILME", "NOME CLIENTE", "LOCAÇÃO", "DEVOLUÇÃO", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tbl_cons);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 860, 330));

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, 30));
        getContentPane().add(txt_busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 265, 30));

        cb_busca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cb_busca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CÓDIGO FILME", "NOME FILME", "DATA DEVOLUÇÃO", "DATA LOCAÇÃO", "CLIENTE", "STATUS" }));
        getContentPane().add(cb_busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, 30));

        btn_voltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_voltar.setText("Voltar");
        btn_voltar.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Splash.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LocacaoDao ldao = new LocacaoDao();
        Locacao f = new Locacao();
        String campo = null;  
        
        if (cb_busca.getSelectedIndex() == 0) {
            campo = "Filme.id_Filme";
        } else if (cb_busca.getSelectedIndex() == 1) {
            campo = "Filme.Titulo";  
        } else if (cb_busca.getSelectedIndex() == 2) {
            campo = "Data_Devolucao";
        } else if (cb_busca.getSelectedIndex() == 3) {
            campo = "Data_locacao";
        } else if (cb_busca.getSelectedIndex() == 4) {
            campo = "Cliente.nome";
        } else if (cb_busca.getSelectedIndex() == 5) {
            campo = "statuss";
        }
        
        List<Locacao> loc = ldao.getLista(campo, txt_busca.getText());
        DefaultTableModel model = (DefaultTableModel) tbl_cons.getModel();
        model.setNumRows(0);

        for (Locacao locacao : loc) {
            model.addRow(new Object[]{
                locacao.getTitulo(),
                locacao.getNome(),
                locacao.getData_loc(),
                locacao.getData_dev(),
                locacao.getStatus()});
                
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Menu obj = new Menu();
        obj.setVisible(true);
    }//GEN-LAST:event_btn_voltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox<String> cb_busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cons;
    private javax.swing.JTextField txt_busca;
    // End of variables declaration//GEN-END:variables
}
