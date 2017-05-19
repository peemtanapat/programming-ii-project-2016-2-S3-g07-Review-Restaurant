package GUI;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.User;

public class LoginGUI extends javax.swing.JFrame {

    private static String username;
    private static int userType; //ให้ 0=admin, 1=user


    public LoginGUI() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFldUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        txtFldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\MyProject\\Picture\\topicLoginRegis.jpg")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel4.setFont(new java.awt.Font("Portmanteau", 1, 18)); // NOI18N
        jLabel4.setText("USERNAME");

        txtFldUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtFldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFldUsernameFocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Portmanteau", 1, 18)); // NOI18N
        jLabel5.setText("Password");

        btnLogin.setFont(new java.awt.Font("Portmanteau", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setEnabled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel3.setText("Log-In");

        btnRegister.setFont(new java.awt.Font("Portmanteau", 1, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        txtFldPassword.setText("jPasswordField1");
        txtFldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFldPasswordFocusGained(evt);
            }
        });
        txtFldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldPasswordActionPerformed(evt);
            }
        });
        txtFldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFldPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btnLogin)
                        .addGap(72, 72, 72)
                        .addComponent(btnRegister))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txtFldPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnRegister))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            loginG();
        } catch (ClassNotFoundException ex) {
            System.out.println("Login Fail" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Login Fail" + ex.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        RegisterGUI register = new RegisterGUI();
        register.setLocationRelativeTo(null);
        register.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtFldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldPasswordActionPerformed

    }//GEN-LAST:event_txtFldPasswordActionPerformed

    private void txtFldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFldUsernameFocusGained

    }//GEN-LAST:event_txtFldUsernameFocusGained

    private void txtFldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFldPasswordFocusGained
        txtFldPassword.setText("");
    }//GEN-LAST:event_txtFldPasswordFocusGained

    private void txtFldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFldPasswordKeyReleased

        usernameIn = txtFldUsername.getText();
        passwordIn = String.valueOf(txtFldPassword.getPassword());
        System.out.println("passwordIn.length: " + passwordIn.length());
        if (usernameIn.length() >= 6 && passwordIn.length() >= 6) {
            btnLogin.setEnabled(true);
        } else {

        }
    }//GEN-LAST:event_txtFldPasswordKeyReleased
    String usernameIn = "";
    String passwordIn = "";

    private void loginG() throws ClassNotFoundException, SQLException {
        HomeGUI hg = null;
        //ReadFrom TextField
        usernameIn = txtFldUsername.getText();
        passwordIn = String.valueOf(txtFldPassword.getPassword());

        User user = new User();
        user.LogIn(usernameIn, passwordIn);
        try {
            this.username = usernameIn;
            this.userType = (user.getUserType().equals("admin")) ? 0 : 1;
        } catch (NullPointerException ex) {
            System.out.println("Unknown Username");
        }
        System.out.println("userType: " + userType);
        if (user.getUserId() == 0) {
            txtFldPassword.setText("");
            btnLogin.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Wrong Username of Password", "Invalid", JOptionPane.WARNING_MESSAGE);
        } else {
            hg = new HomeGUI();
            System.out.println("Login success");
            JOptionPane.showMessageDialog(this, "Login success", "Successful", JOptionPane.WARNING_MESSAGE);
            hg.setVisible(true);
            this.setVisible(false);
        }
        System.out.println("Username: " + usernameIn);

    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LoginGUI.username = username;
    }

    public static int getUserType() {
        return userType;
    }

    public static void setUserType(int userType) {
        LoginGUI.userType = userType;
    }

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginGUI login = new LoginGUI();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtFldPassword;
    private javax.swing.JTextField txtFldUsername;
    // End of variables declaration//GEN-END:variables
}
