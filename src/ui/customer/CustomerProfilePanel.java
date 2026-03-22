package ui.customer;

import javax.swing.*;
import main_logics.AuthService;
import main_running.Customer;

/**
 * Panel for editing customer profile information.
 * @author jiahe
 */
public class CustomerProfilePanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomerProfilePanel.class.getName());
    private Customer customer;

    public CustomerProfilePanel(Customer customer) {
        this.customer = customer;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("My Profile");
        loadProfile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        L_fullName = new javax.swing.JLabel();
        TF_fullName = new javax.swing.JTextField();
        L_email = new javax.swing.JLabel();
        TF_email = new javax.swing.JTextField();
        L_phone = new javax.swing.JLabel();
        TF_phone = new javax.swing.JTextField();
        L_password = new javax.swing.JLabel();
        PF_password = new javax.swing.JPasswordField();
        BTN_update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("My Profile");

        L_fullName.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_fullName.setText("Full Name:");

        TF_fullName.setFont(new java.awt.Font("Segoe UI", 0, 14));

        L_email.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_email.setText("Email:");

        TF_email.setFont(new java.awt.Font("Segoe UI", 0, 14));

        L_phone.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_phone.setText("Phone:");

        TF_phone.setFont(new java.awt.Font("Segoe UI", 0, 14));

        L_password.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_password.setText("New Password:");

        PF_password.setFont(new java.awt.Font("Segoe UI", 0, 14));

        BTN_update.setFont(new java.awt.Font("Segoe UI", 0, 14));
        BTN_update.setText("Update Profile");
        BTN_update.addActionListener(this::BTN_updateActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_fullName)
                            .addComponent(L_email)
                            .addComponent(L_phone)
                            .addComponent(L_password))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_email, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PF_password, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BTN_update, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(L_title)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_fullName)
                    .addComponent(TF_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_email)
                    .addComponent(TF_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_phone)
                    .addComponent(TF_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_password)
                    .addComponent(PF_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(BTN_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void loadProfile() {
        TF_fullName.setText(customer.getFullName());
        TF_email.setText(customer.getEmail());
        TF_phone.setText(customer.getPhoneNumber());
    }

    private void BTN_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_updateActionPerformed
        try {
            String fullName = TF_fullName.getText().trim();
            String email = TF_email.getText().trim();
            String phone = TF_phone.getText().trim();
            String newPassword = new String(PF_password.getPassword()).trim();

            if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields");
                return;
            }

            customer.setFullName(fullName);
            customer.setEmail(email);
            customer.setPhoneNumber(phone);
            if (!newPassword.isEmpty()) {
                customer.setPassword(newPassword);
            }

            AuthService authService = new AuthService();
            authService.updateUser(customer);
            JOptionPane.showMessageDialog(this, "Profile updated successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating profile: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_updateActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new CustomerProfilePanel(
                new Customer("U003", "cust1", "cust123", "Jane Customer", "jane@email.com", "012-3456789", "2026-01-15")
        ).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_update;
    private javax.swing.JLabel L_email;
    private javax.swing.JLabel L_fullName;
    private javax.swing.JLabel L_password;
    private javax.swing.JLabel L_phone;
    private javax.swing.JLabel L_title;
    private javax.swing.JPasswordField PF_password;
    private javax.swing.JTextField TF_email;
    private javax.swing.JTextField TF_fullName;
    private javax.swing.JTextField TF_phone;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
