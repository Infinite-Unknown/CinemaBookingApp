package ui.customer;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main_logics.*;
import main_running.*;

/**
 * Panel showing customer's bookings with cancel and receipt options.
 * 
 * @author Lam Ming Joe
 */
public class CustomerBookingsPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(CustomerBookingsPanel.class.getName());
    private Customer customer;
    private MovieService movieService;
    private ShowtimeService showtimeService;
    private BookingService bookingService;
    private PaymentService paymentService;
    private DefaultTableModel tableModel;

    public CustomerBookingsPanel(Customer customer) {
        this.customer = customer;
        movieService = new MovieService();
        showtimeService = new ShowtimeService();
        bookingService = new BookingService();
        paymentService = new PaymentService();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("My Bookings");
        loadBookings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_bookings = new javax.swing.JTable();
        BTN_cancel = new javax.swing.JButton();
        BTN_receipt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("My Bookings");

        tableModel = new DefaultTableModel(
                new String[] { "Booking ID", "Movie", "Date/Time", "Seats", "Amount (RM)", "Status" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TBL_bookings.setModel(tableModel);
        TBL_bookings.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TBL_bookings);

        BTN_cancel.setText("Cancel Booking");
        BTN_cancel.addActionListener(this::BTN_cancelActionPerformed);

        BTN_receipt.setText("View Receipt");
        BTN_receipt.addActionListener(this::BTN_receiptActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660,
                                                Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(BTN_cancel)
                                                .addGap(15, 15, 15)
                                                .addComponent(BTN_receipt)))
                                .addGap(20, 20, 20)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(L_title)
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTN_cancel)
                                        .addComponent(BTN_receipt))
                                .addGap(15, 15, 15)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadBookings() {
        tableModel.setRowCount(0);
        try {
            List<Booking> bookings = bookingService.getBookingsByCustomer(customer.getUserId());
            for (Booking b : bookings) {
                Showtime st = showtimeService.getShowtimeById(b.getShowtimeId());
                String movieTitle = "N/A";
                String datetime = "N/A";
                if (st != null) {
                    Movie movie = movieService.getMovieById(st.getMovieId());
                    movieTitle = movie != null ? movie.getTitle() : "N/A";
                    datetime = st.getDate() + " " + st.getTime();
                }
                tableModel.addRow(new Object[] {
                        b.getBookingId(), movieTitle, datetime,
                        b.getSeatNumbers(), String.format("%.2f", b.getTotalAmount()), b.getStatus()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading bookings: " + ex.getMessage());
        }
    }

    private void BTN_cancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BTN_cancelActionPerformed
        int row = TBL_bookings.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a booking to cancel");
            return;
        }
        String status = tableModel.getValueAt(row, 5).toString();
        if (status.equals("CANCELLED")) {
            JOptionPane.showMessageDialog(this, "This booking is already cancelled");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel this booking?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String bookingId = tableModel.getValueAt(row, 0).toString();
                bookingService.cancelBooking(bookingId);
                paymentService.refundPayment(bookingId);
                loadBookings();
                JOptionPane.showMessageDialog(this, "Booking cancelled and refund processed!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }// GEN-LAST:event_BTN_cancelActionPerformed

    private void BTN_receiptActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BTN_receiptActionPerformed
        int row = TBL_bookings.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a booking");
            return;
        }
        try {
            String bookingId = tableModel.getValueAt(row, 0).toString();
            Booking booking = bookingService.getBookingById(bookingId);
            Payment payment = paymentService.getPaymentByBooking(bookingId);
            if (payment == null) {
                JOptionPane.showMessageDialog(this, "No payment found for this booking");
                return;
            }
            Showtime st = showtimeService.getShowtimeById(booking.getShowtimeId());
            Movie movie = movieService.getMovieById(st.getMovieId());
            String receipt = paymentService.generateReceipt(booking, payment, movie, st, customer.getFullName());
            new ui.ReceiptDialog(this, receipt).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }// GEN-LAST:event_BTN_receiptActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new CustomerBookingsPanel(
                new Customer("U003", "cust1", "cust123", "Jane Customer", "jane@email.com", "012-3456789",
                        "2026-01-15"))
                .setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_cancel;
    private javax.swing.JButton BTN_receipt;
    private javax.swing.JLabel L_title;
    private javax.swing.JTable TBL_bookings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
