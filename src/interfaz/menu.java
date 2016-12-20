/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import devolvercambio.DevolverCambio;
import java.util.List;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author AIMX
 */
public class menu extends javax.swing.JFrame {

    double[] tiposMonedas = {0.10, 0.20, 0.50, 1, 2};
    double totalMonedasDisponibles = 54.8;
    int[] monedasDisponibles = {11, 12, 13, 14, 15};

    /*double[] tiposMonedas = {4,3,2,1};
    double totalMonedasDisponibles = 54;
    int[] monedasDisponibles = {15,14,13,12};*/
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
        jButtonCalcularVoraz = new javax.swing.JButton();
        jTextCantidad = new javax.swing.JTextField();
        jButtonCalcularBacktracking = new javax.swing.JButton();
        jButtonCalcularDinamica = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextTiempo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextResultado = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemConfiguracion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantidad a cambiar:");

        jLabel2.setText("Resultado:");

        jButtonCalcularVoraz.setText("Calcular Voraz");
        jButtonCalcularVoraz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularVorazActionPerformed(evt);
            }
        });

        jButtonCalcularBacktracking.setText("Calcular Backtracking");
        jButtonCalcularBacktracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularBacktrackingActionPerformed(evt);
            }
        });

        jButtonCalcularDinamica.setText("Calcular Dinamica");
        jButtonCalcularDinamica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularDinamicaActionPerformed(evt);
            }
        });

        jLabel3.setText("Tiempo que ha tardado:");

        jTextTiempo.setEditable(false);

        jLabel4.setText("(En milisegundos)");

        jTextResultado.setEditable(false);
        jTextResultado.setColumns(20);
        jTextResultado.setRows(5);
        jScrollPane1.setViewportView(jTextResultado);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCalcularVoraz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCalcularBacktracking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCalcularDinamica)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addComponent(jTextTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCalcularVoraz)
                    .addComponent(jButtonCalcularBacktracking)
                    .addComponent(jButtonCalcularDinamica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularVorazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularVorazActionPerformed
        DevolverCambio cambiador = new DevolverCambio();
        double cambio = Double.parseDouble(jTextCantidad.getText());
        if (esViable(cambio)) {
            long tiempoIni = System.currentTimeMillis();
            calcularVoraz(cambiador, cambio);
            long tiempoFin = System.currentTimeMillis();
            this.jTextTiempo.setText(Long.toString(tiempoFin - tiempoIni));
        } else {
            this.jTextResultado.setText("0");
            JOptionPane.showMessageDialog(this,
                    "Es imposible devolver " + cambio + " con las monedas existentes.",
                    "No existe solución",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCalcularVorazActionPerformed

    private boolean esViable(double cambio) {
        double total = 0;
        for (int i = 0; i < tiposMonedas.length; i++) {
            total += tiposMonedas[i] * monedasDisponibles[i];
        }
        System.out.println(total);
        return cambio <= total;
    }
    
    private String arrayToString(int[] array){
        String out = "";
        
        for(int i = 0; i < array.length; i++){
            //if(array[i] > 0)
                out += ">Moneda/s de " + this.tiposMonedas[i] + " €: " + array[i] + "\n";
        }
        
        return out;
    }

    private void calcularDinamico(DevolverCambio cambiador, double cambio) {
        this.jTextResultado.setText(Integer.toString(cambiador.devolverCambioDinamico(tiposMonedas, monedasDisponibles, tiposMonedas.length, cambio)));
    }

    private void calcularVoraz(DevolverCambio cambiador, double cambio) {
        this.jTextResultado.setText(arrayToString(cambiador.devolverCambioVoraz(tiposMonedas, monedasDisponibles, cambio)));
    }

    private void calcularBacktracking(DevolverCambio cambiador, double cambio) {
        this.jTextResultado.setText(Integer.toString(cambiador.devolverCambioBackTracking(tiposMonedas, monedasDisponibles, cambio)));
    }

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

                    this.tiposMonedas = new double[tipos.size()];
                    this.monedasDisponibles = new int[cantidades.size()];
                    double total = 0;

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

    private void jButtonCalcularBacktrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularBacktrackingActionPerformed
        DevolverCambio cambiador = new DevolverCambio();
        double cambio = Double.parseDouble(jTextCantidad.getText());
        if (esViable(cambio)) {
            long tiempoIni = System.currentTimeMillis();
            calcularBacktracking(cambiador, cambio);
            long tiempoFin = System.currentTimeMillis();
            this.jTextTiempo.setText(Long.toString(tiempoFin - tiempoIni));
        } else {
            this.jTextResultado.setText("0");
            JOptionPane.showMessageDialog(this,
                    "Es imposible devolver " + cambio + " con las monedas existentes.",
                    "No existe solución",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCalcularBacktrackingActionPerformed

    private void jButtonCalcularDinamicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularDinamicaActionPerformed
        DevolverCambio cambiador = new DevolverCambio();
        double cambio = Double.parseDouble(jTextCantidad.getText());
        if (esViable(cambio)) {
            long tiempoIni = System.currentTimeMillis();
            calcularDinamico(cambiador, cambio);
            long tiempoFin = System.currentTimeMillis();
            this.jTextTiempo.setText(Long.toString(tiempoFin - tiempoIni));
        } else {
            this.jTextResultado.setText("0");
            JOptionPane.showMessageDialog(this,
                    "Es imposible devolver " + cambio + " con las monedas existentes.",
                    "No existe solución",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCalcularDinamicaActionPerformed

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
    private javax.swing.JButton jButtonCalcularBacktracking;
    private javax.swing.JButton jButtonCalcularDinamica;
    private javax.swing.JButton jButtonCalcularVoraz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemConfiguracion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextArea jTextResultado;
    private javax.swing.JTextField jTextTiempo;
    // End of variables declaration//GEN-END:variables
}
