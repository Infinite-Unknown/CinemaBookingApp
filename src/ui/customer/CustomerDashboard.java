package ui.customer;

import main_running.Customer;
import ui.LoginFrame;

/**
 * Customer dashboard with buttons to access different panels.
 * @author jiahe
 */
public class CustomerDashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomerDashboard.class.getName());
    private Customer customer;

    public CustomerDashboard(Customer customer) {
        this.customer = customer;
        initComponents();
        setLocationRelativeTo(null);
        setTitle(customer.getDashboardTitle());
        L_welcome.setText("Welcome, " + customer.getFullName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        L_welcome = new javax.swing.JLabel();
        BTN_movies = new javax.swing.JButton();
        BTN_bookings = new javax.swing.JButton();
        BTN_profile = new javax.swing.JButton();
        BTN_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        L_title.setForeground(new java.awt.Color(51, 51, 51));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Customer Dashboard");

        L_welcome.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_welcome.setForeground(new java.awt.Color(102, 102, 102));
        L_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_welcome.setText("Welcome");

        BTN_movies.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_movies.setText("Browse Movies");
        BTN_movies.addActionListener(this::BTN_moviesActionPerformed);

        BTN_bookings.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_bookings.setText("My Bookings");
        BTN_bookings.addActionListener(this::BTN_bookingsActionPerformed);

        BTN_profile.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_profile.setText("My Profile");
        BTN_profile.addActionListener(this::BTN_profileActionPerformed);

        BTN_logout.setFont(new java.awt.Font("Segoe UI", 0, 14));
        BTN_logout.setForeground(new java.awt.Color(255, 0, 0));
        BTN_logout.setText("Logout");
        BTN_logout.addActionListener(this::BTN_logoutActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addComponent(L_welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_movies, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(BTN_bookings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(L_title)
                .addGap(5, 5, 5)
                .addComponent(L_welcome)
                .addGap(30, 30, 30)
                .addComponent(BTN_movies, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(BTN_bookings, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(BTN_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(BTN_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void BTN_moviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_moviesActionPerformed
        new CustomerMoviesPanel(customer).setVisible(true);
    }//GEN-LAST:event_BTN_moviesActionPerformed

    private void BTN_bookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_bookingsActionPerformed
        new CustomerBookingsPanel(customer).setVisible(true);
    }//GEN-LAST:event_BTN_bookingsActionPerformed

    private void BTN_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_profileActionPerformed
        new CustomerProfilePanel(customer).setVisible(true);
    }//GEN-LAST:event_BTN_profileActionPerformed

    private void BTN_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_logoutActionPerformed
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BTN_logoutActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new CustomerDashboard(
                new Customer("U003", "cust1", "cust123", "Jane Customer", "jane@email.com", "012-3456789", "2026-01-15")
        ).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_bookings;
    private javax.swing.JButton BTN_logout;
    private javax.swing.JButton BTN_movies;
    private javax.swing.JButton BTN_profile;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_welcome;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
