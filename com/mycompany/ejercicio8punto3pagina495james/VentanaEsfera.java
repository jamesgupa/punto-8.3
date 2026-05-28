package com.mycompany.ejercicio8punto3pagina495james;

/**
 *
 * @author James Gutierrez P
 */

import javax.swing.JOptionPane;

public class VentanaEsfera extends javax.swing.JFrame {

    public VentanaEsfera() {
        initComponents();
        setTitle("Esfera");
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        radio = new javax.swing.JLabel();
        campoRadio = new javax.swing.JTextField();
        calcular = new javax.swing.JButton();
        volumen = new javax.swing.JLabel();
        superficie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        radio.setText("Radio (cms):");
        calcular.setText("Calcular");
        calcular.addActionListener(this::calcularActionPerformed);
        volumen.setText("Volumen (cm3):");
        superficie.setText("Superficie (cm2):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio)
                    .addComponent(volumen)
                    .addComponent(superficie))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(calcular, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(campoRadio))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio)
                    .addComponent(campoRadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(calcular)
                .addGap(12, 12, 12)
                .addComponent(volumen)
                .addGap(18, 18, 18)
                .addComponent(superficie)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pack();
    }

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {
        boolean error = false;
        try {
            double r = Double.parseDouble(campoRadio.getText());
            Esfera esfera = new Esfera(r);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        }
        if (error) {
            JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VentanaEsfera().setVisible(true));
    }

    private javax.swing.JButton calcular;
    private javax.swing.JTextField campoRadio;
    private javax.swing.JLabel radio;
    private javax.swing.JLabel superficie;
    private javax.swing.JLabel volumen;
}
