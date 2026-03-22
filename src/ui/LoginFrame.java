package ui;

import main_logics.AuthService;
import main_running.*;
import ui.clerk.ClerkDashboard;
import ui.customer.CustomerDashboard;
import ui.manager.ManagerDashboard;

/**
 * Login screen for the Cinema Booking System.
 * @author jiahe
 */
public class LoginFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());

    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Cinema Booking System - Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_Title = new javax.swing.JLabel();
        L_username = new javax.swing.JLabel();
        TF_username = new javax.swing.JTextField();
        L_password = new javax.swing.JLabel();
        PF_password = new javax.swing.JPasswordField();
        BTN_login = new javax.swing.JButton();
        BTN_register = new javax.swing.JButton();
        L_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_Title.setFont(new java.awt.Font("Segoe UI", 0, 24));
        L_Title.setForeground(new java.awt.Color(102, 102, 102));
        L_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Title.setText("Cinema Booking System");

        L_username.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_username.setText("Username:");

        TF_username.setFont(new java.awt.Font("Segoe UI", 0, 14));

        L_password.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_password.setText("Password:");

        PF_password.setFont(new java.awt.Font("Segoe UI", 0, 14));

        BTN_login.setFont(new java.awt.Font("Segoe UI", 0, 14));
        BTN_login.setText("Login");
        BTN_login.addActionListener(this::BTN_loginActionPerformed);

        BTN_register.setFont(new java.awt.Font("Segoe UI", 0, 12));
        BTN_register.setText("Register as Customer");
        BTN_register.addActionListener(this::BTN_registerActionPerformed);

        L_error.setFont(new java.awt.Font("Segoe UI", 0, 12));
        L_error.setForeground(new java.awt.Color(255, 0, 0));
        L_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_error.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(L_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_username)
                    .addComponent(L_password))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF_username, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(PF_password))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BTN_login, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_register))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(L_Title)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_username))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PF_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_password))
                .addGap(10, 10, 10)
                .addComponent(L_error)
                .addGap(15, 15, 15)
                .addComponent(BTN_login, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BTN_register)
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void BTN_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_loginActionPerformed
        String username = TF_username.getText().trim();
        String password = new String(PF_password.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            L_error.setText("Please enter username and password");
            return;
        }

        try {
            AuthService authService = new AuthService();
            User user = authService.login(username, password);

            // Polymorphic dispatch based on user role
            if (user instanceof Manager) {
                new ManagerDashboard((Manager) user).setVisible(true);
            } else if (user instanceof TicketingClerk) {
                new ClerkDashboard((TicketingClerk) user).setVisible(true);
            } else if (user instanceof Customer) {
                new CustomerDashboard((Customer) user).setVisible(true);
            }
            this.dispose();
        } catch (Exception ex) {
            L_error.setText("Invalid username or password");
        }
    }//GEN-LAST:event_BTN_loginActionPerformed

    private void BTN_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_registerActionPerformed
        new RegisterFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BTN_registerActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_login;
    private javax.swing.JButton BTN_register;
    private javax.swing.JLabel L_Title;
    private javax.swing.JLabel L_error;
    private javax.swing.JLabel L_password;
    private javax.swing.JLabel L_username;
    private javax.swing.JPasswordField PF_password;
    private javax.swing.JTextField TF_username;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
