package ui.clerk;

import main_running.TicketingClerk;
import ui.LoginFrame;

/**
 * Ticketing Clerk dashboard with buttons to access different clerk panels.
 * @author jiahe
 */
public class ClerkDashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClerkDashboard.class.getName());
    private TicketingClerk clerk;

    public ClerkDashboard(TicketingClerk clerk) {
        this.clerk = clerk;
        initComponents();
        setLocationRelativeTo(null);
        setTitle(clerk.getDashboardTitle() + " - " + clerk.getFullName());
        L_welcome.setText("Welcome, " + clerk.getFullName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        L_welcome = new javax.swing.JLabel();
        BTN_newBooking = new javax.swing.JButton();
        BTN_manageBookings = new javax.swing.JButton();
        BTN_screenings = new javax.swing.JButton();
        BTN_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 24));
        L_title.setForeground(new java.awt.Color(51, 51, 51));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Ticketing Clerk Dashboard");

        L_welcome.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_welcome.setForeground(new java.awt.Color(102, 102, 102));
        L_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_welcome.setText("Welcome");

        BTN_newBooking.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_newBooking.setText("New Walk-in Booking");
        BTN_newBooking.addActionListener(this::BTN_newBookingActionPerformed);

        BTN_manageBookings.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_manageBookings.setText("Manage Bookings");
        BTN_manageBookings.addActionListener(this::BTN_manageBookingsActionPerformed);

        BTN_screenings.setFont(new java.awt.Font("Segoe UI", 0, 16));
        BTN_screenings.setText("View Screenings");
        BTN_screenings.addActionListener(this::BTN_screeningsActionPerformed);

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
                    .addComponent(BTN_newBooking, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(BTN_manageBookings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_screenings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(BTN_newBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(BTN_manageBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(BTN_screenings, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void BTN_newBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_newBookingActionPerformed
        new ClerkBookingPanel(clerk).setVisible(true);
    }//GEN-LAST:event_BTN_newBookingActionPerformed

    private void BTN_manageBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_manageBookingsActionPerformed
        new ClerkManageBookingsPanel().setVisible(true);
    }//GEN-LAST:event_BTN_manageBookingsActionPerformed

    private void BTN_screeningsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_screeningsActionPerformed
        new ClerkScreeningsPanel().setVisible(true);
    }//GEN-LAST:event_BTN_screeningsActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new ClerkDashboard(
                new TicketingClerk("U002", "clerk1", "clerk123", "John Clerk", "john@cinema.com", "EMP002", "Counter 1")
        ).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_logout;
    private javax.swing.JButton BTN_manageBookings;
    private javax.swing.JButton BTN_newBooking;
    private javax.swing.JButton BTN_screenings;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_welcome;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
