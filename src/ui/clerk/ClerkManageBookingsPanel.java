package ui.clerk;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main_logics.*;
import main_running.*;

/**
 * Panel for clerks to view and manage all bookings.
 * @author jiahe
 */
public class ClerkManageBookingsPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClerkManageBookingsPanel.class.getName());
    private BookingService bookingService;
    private PaymentService paymentService;
    private MovieService movieService;
    private ShowtimeService showtimeService;
    private DefaultTableModel tableModel;

    public ClerkManageBookingsPanel() {
        bookingService = new BookingService();
        paymentService = new PaymentService();
        movieService = new MovieService();
        showtimeService = new ShowtimeService();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage Bookings");
        loadBookings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_bookings = new javax.swing.JTable();
        BTN_cancel = new javax.swing.JButton();
        BTN_refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Manage Bookings");

        tableModel = new DefaultTableModel(
            new String[]{"Booking ID", "Customer", "Movie", "Seats", "Date", "Amount (RM)", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        TBL_bookings.setModel(tableModel);
        TBL_bookings.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TBL_bookings);

        BTN_cancel.setText("Cancel Selected Booking");
        BTN_cancel.addActionListener(this::BTN_cancelActionPerformed);

        BTN_refresh.setText("Refresh");
        BTN_refresh.addActionListener(this::BTN_refreshActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTN_cancel)
                        .addGap(20, 20, 20)
                        .addComponent(BTN_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(L_title)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_cancel)
                    .addComponent(BTN_refresh))
                .addGap(20, 20, 20))
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

    private void loadBookings() {
        tableModel.setRowCount(0);
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            for (Booking b : bookings) {
                Showtime st = showtimeService.getShowtimeById(b.getShowtimeId());
                String movieTitle = "N/A";
                if (st != null) {
                    Movie movie = movieService.getMovieById(st.getMovieId());
                    movieTitle = movie != null ? movie.getTitle() : st.getMovieId();
                }
                tableModel.addRow(new Object[]{
                    b.getBookingId(), b.getCustomerId(), movieTitle,
                    b.getSeatNumbers(), b.getBookingDate(),
                    String.format("%.2f", b.getTotalAmount()), b.getStatus()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading bookings: " + ex.getMessage());
        }
    }

    private void BTN_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cancelActionPerformed
        int row = TBL_bookings.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a booking to cancel");
            return;
        }
        String status = tableModel.getValueAt(row, 6).toString();
        if (status.equals("CANCELLED")) {
            JOptionPane.showMessageDialog(this, "This booking is already cancelled");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel this booking?",
                "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String bookingId = tableModel.getValueAt(row, 0).toString();
                bookingService.cancelBooking(bookingId);
                paymentService.refundPayment(bookingId);
                JOptionPane.showMessageDialog(this, "Booking cancelled successfully");
                loadBookings();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error cancelling: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_BTN_cancelActionPerformed

    private void BTN_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_refreshActionPerformed
        loadBookings();
    }//GEN-LAST:event_BTN_refreshActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new ClerkManageBookingsPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_cancel;
    private javax.swing.JButton BTN_refresh;
    private javax.swing.JLabel L_title;
    private javax.swing.JTable TBL_bookings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
