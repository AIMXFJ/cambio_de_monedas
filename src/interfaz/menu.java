/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import devolvercambio.DevolverCambio;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author AIMX
 */
public class menu extends javax.swing.JFrame {

    int[] tiposMonedas;
    int totalMonedasDisponibles;
    int[] monedasDisponibles;

    /**
     * Creates new form menu
     */
    public menu() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCalcular = new javax.swing.JButton();
        jTextCantidad = new javax.swing.JTextField();
        jTextResultadoDinamico = new javax.swing.JTextField();
        jTextResultadoBacktracking = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemConfiguracion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantidad a cambiar:");

        jLabel2.setText("Resultado Backtracking:");

        jButtonCalcular.setText("Calcular");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jTextResultadoDinamico.setEditable(false);

        jTextResultadoBacktracking.setEditable(false);

        jLabel3.setText("Resultado Prog.Dinámica");

        jMenu1.setText("Admin");

        jMenuItemConfiguracion.setText("Configuracion");
        jMenuItemConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfiguracionActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemConfiguracion);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCalcular)
                    .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextResultadoDinamico)
                    .addComponent(jTextResultadoBacktracking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextResultadoBacktracking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextResultadoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        // TODO add your handling code here:
        DevolverCambio cambiador = new DevolverCambio();
        this.jTextResultadoBacktracking.setText(Integer.toString(cambiador.devolverCambioBackTracking(monedasDisponibles, tiposMonedas, totalMonedasDisponibles)));
        this.jTextResultadoDinamico.setText(Integer.toString(cambiador.devolverCambioDinamico(tiposMonedas, monedasDisponibles, tiposMonedas.length, totalMonedasDisponibles)));
    }//GEN-LAST:event_jButtonCalcularActionPerformed

    private void jMenuItemConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfiguracionActionPerformed
        JTextField tiposField = new JTextField("", 6);
        JTextField valoresField = new JTextField("", 6);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Introducir los elementos separados mediante comas."));
        panel.add(new JLabel("Tipos de moneda:"));
        panel.add(tiposField);
        panel.add(Box.createHorizontalStrut(15)); // a spacer
        panel.add(new JLabel("Número de monedas de cada tipo:"));
        panel.add(valoresField);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Configuración", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            if (tiposField.getText().equals("") && valoresField.getText().equals("")) {
                JOptionPane.showMessageDialog(this,
                        "Los valores no pueden estar vacíos.",
                        "Input error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                List<String> tipos = Arrays.asList(tiposField.getText().split("\\s*,\\s*"));
                List<String> cantidades = Arrays.asList(valoresField.getText().split("\\s*,\\s*"));

                if (tipos.size() != cantidades.size()) {
                    JOptionPane.showMessageDialog(this,
                            "El numero de valores en ambas entradas debe ser el mismo",
                            "Input error",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    this.tiposMonedas = new int[tipos.size()];
                    this.monedasDisponibles = new int[cantidades.size()];
                    int total = 0;

                    for (int r = 0; r < this.tiposMonedas.length; r++) {
                        this.tiposMonedas[r] = Integer.valueOf(tipos.get(r));
                    }

                    for (int q = 0; q < this.monedasDisponibles.length; q++) {
                        this.monedasDisponibles[q] = Integer.valueOf(cantidades.get(q));
                        total += Integer.valueOf(cantidades.get(q));
                    }

                    this.totalMonedasDisponibles = total;

                    System.out.println("Tipos Monedas\n");
                    for (int i = 0; i < this.tiposMonedas.length; i++) {
                        System.out.println(this.tiposMonedas[i] + "\n");
                    }

                    System.out.println("Cantidades Monedas\n");
                    for (int j = 0; j < this.monedasDisponibles.length; j++) {
                        System.out.println(this.monedasDisponibles[j] + "\n");
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItemConfiguracionActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemConfiguracion;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextResultadoBacktracking;
    private javax.swing.JTextField jTextResultadoDinamico;
    // End of variables declaration//GEN-END:variables
}
