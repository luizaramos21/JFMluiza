package MLuiza;

import Classes.Controle;
import Classes.Funcionario;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    //Objeto para execultar as funçoes de sair e salvar
    Controle C = new Controle();
    
    //Construtor que recebe um Controle
    public Inicio(Controle c) {
        initComponents();
        setLocationRelativeTo(null);
        this.C = c; //Associa o Controle recebido ao atributo da classe
    }
    
    public Inicio() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnome = new javax.swing.JTextField();
        txtvalor = new javax.swing.JTextField();
        txthoras = new javax.swing.JTextField();
        btnsalvar = new javax.swing.JButton();
        btnexibir = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        txtadms = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 570, 70));

        txtvalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalorActionPerformed(evt);
            }
        });
        jPanel1.add(txtvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 270, 60));
        jPanel1.add(txthoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, 290, 60));

        btnsalvar.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        btnsalvar.setText("SALVAR");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 670, 250, 70));

        btnexibir.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        btnexibir.setText("EXIBIR");
        btnexibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexibirActionPerformed(evt);
            }
        });
        jPanel1.add(btnexibir, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 670, 250, 70));

        btnsair.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        btnsair.setText("SAIR");
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });
        jPanel1.add(btnsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 670, 250, 70));

        try {
            txtadms.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("                      ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtadms, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 280, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\laila\\Downloads\\WhatsApp Image 2024-12-05 at 18.10.18.jpeg")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtvalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorActionPerformed

    private void btnexibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexibirActionPerformed
        new Exibir(C).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnexibirActionPerformed

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsairActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        try {
            //Captura e valida os campos de entrada
            String nome = txtnome.getText();
            String dataAdmissao = txtadms.getText();
            float valorHora = Float.parseFloat(txtvalor.getText());
            float horasTrabalhadas = Float.parseFloat(txthoras.getText());

            //Cria o funcionário com os dados capturados
            Funcionario funcionario = new Funcionario(nome, dataAdmissao, valorHora, horasTrabalhadas);

            //Salva o funcionário e exibe mensagens
            if (C.salvar(funcionario)) {
                JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                //Limpa os campos e coloca foco no nome
                txtnome.setText("");
                txtadms.setText("");
                txtvalor.setText("");
                txthoras.setText("");
                txtnome.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar funcionário!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Os campos 'Valor por Hora' e 'Horas Trabalhadas' devem ser numéricos e estar preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data de Admissão inválida. Use o formato DD/MM/AAAA.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {// Captura e trata exceções relacionadas a dados inválidos (como nome vazio ou valores negativos)
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnsalvarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexibir;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtadms;
    private javax.swing.JTextField txthoras;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
