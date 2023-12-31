/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasikaryawan;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
// libary database
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author User
 */

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("empty-statement")
    public void getToLogin(){

        // Condition If Null Input
        if (userLogin.getText().equals("")) { 
            userLogin.requestFocus(); 
        }else if (String.valueOf(passLogin.getPassword()).equals("")) { 
            passLogin.requestFocus(); 
        }else{
            String dbUser = ""; String dbPass = ""; String dbType = "";
            String SQLQuery = "SELECT `username`, `password`, `type` FROM `tb_user` WHERE `username`=?" ;
            Connection conn = null; PreparedStatement ps = null; ResultSet res = null;

            try {
                conn = Connect.configDB();
                ps = conn.prepareStatement(SQLQuery);
                ps.setString(1, String.valueOf(userLogin.getText()));
                res = ps.executeQuery();
                while (res.next()) {                
                    dbUser = res.getString(1);
                    dbPass = res.getString(2);
                    dbType = res.getString(3);
                }
                boolean validation = (userLogin.getText().equals(dbUser))&&(String.valueOf(passLogin.getPassword()).equals(dbPass));
                if(validation){
                    switch (dbType) {
                    case "admin":
                        Variabel.setUsername(userLogin.getText());
                        new Admin().setVisible(true);
                        dispose();
                    case "karyawan":
                        new Karyawan().setVisible(true);
                        dispose();
                    default:
                        throw new AssertionError();
                    }
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Data Tidak Terdaftar!");
                    userLogin.setText("");
                    passLogin.setText("");
                }
            } catch (HeadlessException | SQLException e) {

            }finally {
                if(conn != null){ try { conn.close(); } catch (SQLException ex) {} };
                if(ps != null){ try { ps.close(); } catch (SQLException ex) {} };
                if(res != null){ try { res.close(); } catch (SQLException ex) {} };
            }
        };
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userLogin = new javax.swing.JTextField();
        passLogin = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password");

        userLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userLogin.setToolTipText("");
        userLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userLoginKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userLoginKeyReleased(evt);
            }
        });

        passLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        passLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passLoginKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passLoginKeyReleased(evt);
            }
        });

        buttonLogin.setBackground(new java.awt.Color(0, 153, 102));
        buttonLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(0, 0, 0));
        buttonLogin.setText("LOGIN");
        buttonLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passLogin)
                            .addComponent(jLabel2)
                            .addComponent(userLogin)
                            .addComponent(jLabel3)
                            .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel4)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)))
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonLogin)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userLoginKeyPressed
        // TODO add your handling code here:
        boolean validation = (evt.getKeyCode() == KeyEvent.VK_ENTER);
        if (validation) {
            buttonLogin.requestFocus();
        }      
    }//GEN-LAST:event_userLoginKeyPressed

    private void passLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passLoginKeyPressed
        // TODO add your handling code here:
        boolean validation = (evt.getKeyCode() == KeyEvent.VK_ENTER);
        if (validation) {
            buttonLogin.requestFocus();
        }
    }//GEN-LAST:event_passLoginKeyPressed

    @SuppressWarnings("empty-statement")
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        getToLogin();
        
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void userLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userLoginKeyReleased
        // TODO add your handling code here:
        if(userLogin.getText().length() > 10){
            userLogin.setText(userLogin.getText().toLowerCase().substring(0, 10));
        }else {
            userLogin.setText(userLogin.getText().toLowerCase());
        }
    }//GEN-LAST:event_userLoginKeyReleased

    private void passLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passLoginKeyReleased
        // TODO add your handling code here:
        String pass = String.valueOf(passLogin.getPassword());
        if(pass.length() > 10){
            passLogin.setText(pass.toLowerCase().substring(0, 10));
        }else {
            passLogin.setText(pass.toLowerCase());
        }
    }//GEN-LAST:event_passLoginKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passLogin;
    private javax.swing.JTextField userLogin;
    // End of variables declaration//GEN-END:variables
}
