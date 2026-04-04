package ui.manager;

import main_running.Manager;
import ui.LoginFrame;

// main dashboard for manager
// @author jiahe
public class ManagerDashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManagerDashboard.class.getName());
    private Manager manager;

    public ManagerDashboard(Manager manager) {
        this.manager = manager;
        initComponents();
        setLocationRelativeTo(null);
        setTitle(manager.getDashboardTitle());
        L_welcome.setText("Welcome, " + manager.getFullName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        L_welcome = new javax.swing.JLabel();
        BTN_movies = new javax.swing.JButton();
        BTN_showtimes = new javax.swing.JButton();
        BTN_pricing = new javax.swing.JButton();
        BTN_reports = new javax.swing.JButton();
        BTN_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        L_title.setForeground(new java.awt.Color(51, 51, 51));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Cinema Manager Dashboard");

        L_welcome.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_welcome.setForeground(new java.awt.Color(102, 102, 102));
        L_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_welcome.setText("Welcome");

        BTN_movies.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_movies.setText("Manage Movies");
        BTN_movies.addActionListener(this::BTN_moviesActionPerformed);

        BTN_showtimes.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_showtimes.setText("Manage Showtimes");
        BTN_showtimes.addActionListener(this::BTN_showtimesActionPerformed);

        BTN_pricing.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_pricing.setText("Manage Pricing");
        BTN_pricing.addActionListener(this::BTN_pricingActionPerformed);

        BTN_reports.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_reports.setText("View Reports");
        BTN_reports.addActionListener(this::BTN_reportsActionPerformed);

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
                    .addComponent(BTN_showtimes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_pricing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_reports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(BTN_showtimes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(BTN_pricing, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(BTN_reports, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        new ManageMoviesPanel().setVisible(true);
    }//GEN-LAST:event_BTN_moviesActionPerformed

    private void BTN_showtimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_showtimesActionPerformed
        new ManageShowtimesPanel().setVisible(true);
    }//GEN-LAST:event_BTN_showtimesActionPerformed

    private void BTN_pricingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_pricingActionPerformed
        new ManagePricingPanel().setVisible(true);
    }//GEN-LAST:event_BTN_pricingActionPerformed

    private void BTN_reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_reportsActionPerformed
        new ReportsPanel().setVisible(true);
    }//GEN-LAST:event_BTN_reportsActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new ManagerDashboard(
                new Manager("U001", "admin", "admin123", "Admin Manager", "admin@cinema.com", "EMP001")
        ).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_logout;
    private javax.swing.JButton BTN_movies;
    private javax.swing.JButton BTN_pricing;
    private javax.swing.JButton BTN_reports;
    private javax.swing.JButton BTN_showtimes;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_welcome;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
