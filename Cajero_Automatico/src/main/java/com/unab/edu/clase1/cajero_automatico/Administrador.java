/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.clase1.cajero_automatico;

import com.unab.edu.DAO.ClsCuenta_Usuario;
import com.unab.edu.DAO.ClsUsuario;
import com.unab.edu.Entidades.Cuenta_Usuario;
import com.unab.edu.Entidades.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        DisplayMember();
    }
    
     public static String fechaActual(){
        
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        
        return formatoFecha.format(fecha);
        
    }
    
    String Valuemember[];
    
    void DisplayMember(){
        
        DefaultComboBoxModel cbdefault = new DefaultComboBoxModel();
        ClsUsuario claseUsuario = new ClsUsuario();
        ArrayList<Usuario> Usuarios = claseUsuario.MostrarSoloUsuarios();
        Valuemember = new String [Usuarios.size()];
        String Filas[] = new String[5];
        for (var iterarDatos : Usuarios){
            Filas[0] = String.valueOf(iterarDatos.getIdUsuario());
            Filas[1] = iterarDatos.getUsuario();
            cbdefault.addElement(Filas[1]);
                        
        }
      
        cmbUsuarioAbonar.setModel(cbdefault);
    }
    
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMontoAbono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbUsuarioAbonar = new javax.swing.JComboBox<>();
        btnEnviarAbono = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMontoAbono.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Welcome / Admin");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Usuario a quien va a abonar");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad a Abonar");

        cmbUsuarioAbonar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cmbUsuarioAbonar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEnviarAbono.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        btnEnviarAbono.setText("Enviar Abono");
        btnEnviarAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarAbonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMontoAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap(436, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEnviarAbono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbUsuarioAbonar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtMontoAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(cmbUsuarioAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnEnviarAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarAbonoActionPerformed
        
        String sDate1 = fechaActual();
            try {
                Date date1 = new SimpleDateFormat("dd/MM/YYYY").parse(sDate1);

                ClsCuenta_Usuario Cuentas = new ClsCuenta_Usuario();
                Cuenta_Usuario cuenta = new Cuenta_Usuario();
                cuenta.setSaldo(Double.parseDouble(txtMontoAbono.getText()));
                cuenta.setTransaccion(2);
                cuenta.setFecha(date1);
                cuenta.setIdUsuario(Integer.parseInt(lblIdEncontrado.getText()));
                Cuentas.AgregarTransaccion(cuenta);               
                txtMontoAbono.setText("");
                
                JOptionPane.showMessageDialog(null,"Dinero Enviado");
        
            } catch (ParseException ex) {
                System.out.println("Error de fecha");
            }
    
        
    }//GEN-LAST:event_btnEnviarAbonoActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarAbono;
    private javax.swing.JComboBox<String> cmbUsuarioAbonar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMontoAbono;
    // End of variables declaration//GEN-END:variables
}
