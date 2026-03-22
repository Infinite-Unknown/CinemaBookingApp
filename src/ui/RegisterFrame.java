package ui;

import javax.swing.*;
import main_logics.AuthService;

/**
 * Registration form for new customers.
 * @author jiahe
 */
public class RegisterFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegisterFrame.class.getName());

    public RegisterFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Customer Registration");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title = new javax.swing.JLabel();
        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Customer Registration");

        L_username = new javax.swing.JLabel();
        L_username.setText("Username:");
        TF_username = new javax.swing.JTextField();
        L_password = new javax.swing.JLabel();
        L_password.setText("Password:");
        PF_password = new javax.swing.JPasswordField();
        L_confirmPwd = new javax.swing.JLabel();
        L_confirmPwd.setText("Confirm Password:");
        PF_confirmPassword = new javax.swing.JPasswordField();
        L_fullName = new javax.swing.JLabel();
        L_fullName.setText("Full Name:");
        TF_fullName = new javax.swing.JTextField();
        L_email = new javax.swing.JLabel();
        L_email.setText("Email:");
        TF_email = new javax.swing.JTextField();
        L_phone = new javax.swing.JLabel();
        L_phone.setText("Phone Number:");
        TF_phone = new javax.swing.JTextField();

        BTN_register = new javax.swing.JButton();
        BTN_register.setFont(new java.awt.Font("Segoe UI", 0, 14));
        BTN_register.setText("Register");
        BTN_register.addActionListener(this::BTN_registerActionPerformed);

        BTN_back = new javax.swing.JButton();
        BTN_back.setText("Back to Login");
        BTN_back.addActionListener(this::BTN_backActionPerformed);

        L_error = new javax.swing.JLabel();
        L_error.setForeground(java.awt.Color.RED);
        L_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_error.setText(" ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addComponent(L_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_username)
                    .addComponent(L_password)
                    .addComponent(L_confirmPwd)
                    .addComponent(L_fullName)
                    .addComponent(L_email)
                    .addComponent(L_phone))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF_username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PF_password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PF_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_register, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(BTN_back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(L_title)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_username)
                    .addComponent(TF_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_password)
                    .addComponent(PF_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_confirmPwd)
                    .addComponent(PF_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_fullName)
                    .addComponent(TF_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_email)
                    .addComponent(TF_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_phone)
                    .addComponent(TF_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(L_error)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_register, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_back))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_registerActionPerformed
        String username = TF_username.getText().trim();
        String password = new String(PF_password.getPassword()).trim();
        String confirmPwd = new String(PF_confirmPassword.getPassword()).trim();
        String fullName = TF_fullName.getText().trim();
        String email = TF_email.getText().trim();
        String phone = TF_phone.getText().trim();

        // Validation
        if (username.isEmpty() || password.isEmpty() || fullName.isEmpty()
                || email.isEmpty() || phone.isEmpty()) {
            L_error.setText("Please fill in all fields");
            return;
        }
        if (!password.equals(confirmPwd)) {
            L_error.setText("Passwords do not match");
            return;
        }
        if (password.length() < 4) {
            L_error.setText("Password must be at least 4 characters");
            return;
        }

        try {
            AuthService authService = new AuthService();
            authService.registerCustomer(username, password, fullName, email, phone);
            JOptionPane.showMessageDialog(this, "Registration successful! You can now login.");
            new LoginFrame().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            L_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_BTN_registerActionPerformed

    private void BTN_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_backActionPerformed
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BTN_backActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new RegisterFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_back;
    private javax.swing.JButton BTN_register;
    private javax.swing.JLabel L_confirmPwd;
    private javax.swing.JLabel L_email;
    private javax.swing.JLabel L_error;
    private javax.swing.JLabel L_fullName;
    private javax.swing.JLabel L_password;
    private javax.swing.JLabel L_phone;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_username;
    private javax.swing.JPasswordField PF_confirmPassword;
    private javax.swing.JPasswordField PF_password;
    private javax.swing.JTextField TF_email;
    private javax.swing.JTextField TF_fullName;
    private javax.swing.JTextField TF_phone;
    private javax.swing.JTextField TF_username;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
