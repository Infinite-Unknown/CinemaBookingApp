package ui.clerk;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import main_logics.*;
import main_running.*;
import ui.ReceiptDialog;
import ui.SeatSelectionPanel;

/**
 * Walk-in ticket booking panel for ticketing clerks.
 * @author jiahe
 */
public class ClerkBookingPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClerkBookingPanel.class.getName());
    private TicketingClerk clerk;
    private MovieService movieService;
    private ShowtimeService showtimeService;
    private BookingService bookingService;
    private PaymentService paymentService;
    private SeatSelectionPanel seatPanel;
    private List<Showtime> currentShowtimes;

    public ClerkBookingPanel(TicketingClerk clerk) {
        this.clerk = clerk;
        movieService = new MovieService();
        showtimeService = new ShowtimeService();
        bookingService = new BookingService();
        paymentService = new PaymentService();
        currentShowtimes = new ArrayList<>();
        initComponents();
        seatPanel = new ui.SeatSelectionPanel();
        pnlSeatContainer.setLayout(new java.awt.BorderLayout());
        pnlSeatContainer.add(seatPanel);
        setLocationRelativeTo(null);
        setTitle("Walk-in Booking");
        loadMoviesCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        L_movie = new javax.swing.JLabel();
        CB_movie = new javax.swing.JComboBox<>();
        L_showtime = new javax.swing.JLabel();
        CB_showtime = new javax.swing.JComboBox<>();
        L_custName = new javax.swing.JLabel();
        TF_customerName = new javax.swing.JTextField();
        pnlSeatContainer = new javax.swing.JPanel();
        L_discount = new javax.swing.JLabel();
        CB_discount = new javax.swing.JComboBox<>();
        L_payment = new javax.swing.JLabel();
        CB_payment = new javax.swing.JComboBox<>();
        L_total = new javax.swing.JLabel();
        BTN_calculate = new javax.swing.JButton();
        BTN_bookAndPay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Walk-in Booking");

        L_movie.setText("Movie:");

        CB_movie.addActionListener(this::CB_movieActionPerformed);

        L_showtime.setText("Showtime:");

        CB_showtime.addActionListener(this::CB_showtimeActionPerformed);

        L_custName.setText("Customer Name:");

        L_discount.setText("Discount:");

        CB_discount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Student", "Senior Citizen", "Child" }));

        L_payment.setText("Payment:");

        CB_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "CARD" }));

        L_total.setFont(new java.awt.Font("Segoe UI", 1, 14));
        L_total.setText("Total: RM 0.00");

        BTN_calculate.setText("Calculate");
        BTN_calculate.addActionListener(this::BTN_calculateActionPerformed);

        BTN_bookAndPay.setFont(new java.awt.Font("Segoe UI", 1, 14));
        BTN_bookAndPay.setText("Book & Pay");
        BTN_bookAndPay.addActionListener(this::BTN_bookAndPayActionPerformed);

        javax.swing.GroupLayout pnlSeatContainerLayout = new javax.swing.GroupLayout(pnlSeatContainer);
        pnlSeatContainer.setLayout(pnlSeatContainerLayout);
        pnlSeatContainerLayout.setHorizontalGroup(
            pnlSeatContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSeatContainerLayout.setVerticalGroup(
            pnlSeatContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSeatContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L_movie)
                        .addGap(10, 10, 10)
                        .addComponent(CB_movie, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(L_custName)
                        .addGap(5, 5, 5)
                        .addComponent(TF_customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L_showtime)
                        .addGap(10, 10, 10)
                        .addComponent(CB_showtime, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L_discount)
                        .addGap(5, 5, 5)
                        .addComponent(CB_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(L_payment)
                        .addGap(5, 5, 5)
                        .addComponent(CB_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BTN_calculate)
                        .addGap(15, 15, 15)
                        .addComponent(L_total)
                        .addGap(15, 15, 15)
                        .addComponent(BTN_bookAndPay)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(L_title)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_movie)
                    .addComponent(CB_movie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_custName)
                    .addComponent(TF_customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_showtime)
                    .addComponent(CB_showtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(pnlSeatContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_discount)
                    .addComponent(CB_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_payment)
                    .addComponent(CB_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_calculate)
                    .addComponent(L_total)
                    .addComponent(BTN_bookAndPay))
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

    private void loadMoviesCombo() {
        CB_movie.removeAllItems();
        try {
            List<Movie> movies = movieService.getActiveMovies();
            for (Movie m : movies) {
                CB_movie.addItem(m.getMovieId() + " - " + m.getTitle());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void CB_movieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_movieActionPerformed
        CB_showtime.removeAllItems();
        currentShowtimes.clear();
        String selected = (String) CB_movie.getSelectedItem();
        if (selected == null) return;
        try {
            String movieId = selected.split(" - ")[0];
            currentShowtimes = showtimeService.getShowtimesByMovie(movieId);
            for (Showtime st : currentShowtimes) {
                CB_showtime.addItem(st.getShowtimeId() + " | " + st.getHallNumber() + " | "
                        + st.getDate() + " " + st.getTime() + " | RM " + String.format("%.2f", st.getBasePrice())
                        + " | " + st.getAvailableSeats() + " left");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_CB_movieActionPerformed

    private void CB_showtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_showtimeActionPerformed
        int idx = CB_showtime.getSelectedIndex();
        if (idx >= 0 && idx < currentShowtimes.size()) {
            try {
                List<Seat> seats = bookingService.getSeatsByShowtime(currentShowtimes.get(idx).getShowtimeId());
                seatPanel.loadSeats(seats);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_CB_showtimeActionPerformed

    private double getDiscountPercent() {
        try {
            List<String> lines = FileHandler.readLines("discounts.txt");
            String selected = CB_discount.getSelectedItem().toString();
            String key = "";
            switch (selected) {
                case "Student": key = "STUDENT"; break;
                case "Senior Citizen": key = "SENIOR"; break;
                case "Child": key = "CHILD"; break;
                default: return 0;
            }
            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts[0].equals(key)) return Double.parseDouble(parts[1]);
            }
        } catch (Exception ex) { /* ignore */ }
        return 0;
    }

    private void BTN_calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_calculateActionPerformed
        List<String> selected = seatPanel.getSelectedSeats();
        if (selected.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select seats");
            return;
        }
        int idx = CB_showtime.getSelectedIndex();
        if (idx >= 0 && idx < currentShowtimes.size()) {
            double total = bookingService.calculateTotal(currentShowtimes.get(idx), selected.size(), getDiscountPercent());
            L_total.setText("Total: RM " + String.format("%.2f", total));
        }
    }//GEN-LAST:event_BTN_calculateActionPerformed

    private void BTN_bookAndPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_bookAndPayActionPerformed
        List<String> selectedSeats = seatPanel.getSelectedSeats();
        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select seats");
            return;
        }
        int idx = CB_showtime.getSelectedIndex();
        if (idx < 0 || idx >= currentShowtimes.size()) {
            JOptionPane.showMessageDialog(this, "Please select a showtime");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Confirm walk-in booking for " + selectedSeats.size() + " seat(s)?",
                "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            Showtime st = currentShowtimes.get(idx);
            double discPct = getDiscountPercent();
            double subtotal = st.getBasePrice() * selectedSeats.size();
            double discountAmt = subtotal * (discPct / 100.0);
            double total = subtotal - discountAmt;

            // Use WALK-IN as customer ID
            Booking booking = bookingService.createBooking("WALK-IN", st.getShowtimeId(),
                    selectedSeats, clerk.getUserId());

            String paymentMethod = CB_payment.getSelectedItem().toString();
            Payment payment = paymentService.processPayment(
                    booking.getBookingId(), total, paymentMethod, discountAmt);

            Movie movie = movieService.getMovieById(st.getMovieId());
            String receipt = paymentService.generateReceipt(booking, payment, movie, st);
            new ReceiptDialog(this, receipt).setVisible(true);

            // Refresh
            CB_movieActionPerformed(null);
            seatPanel.clearSelection();
            L_total.setText("Total: RM 0.00");
            TF_customerName.setText("");
            JOptionPane.showMessageDialog(this, "Booking completed!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_bookAndPayActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new ClerkBookingPanel(
                new TicketingClerk("U002", "clerk1", "clerk123", "John Clerk", "john@cinema.com", "EMP002", "Counter 1")
        ).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_bookAndPay;
    private javax.swing.JButton BTN_calculate;
    private javax.swing.JComboBox<String> CB_discount;
    private javax.swing.JComboBox<String> CB_movie;
    private javax.swing.JComboBox<String> CB_payment;
    private javax.swing.JComboBox<String> CB_showtime;
    private javax.swing.JLabel L_custName;
    private javax.swing.JLabel L_discount;
    private javax.swing.JLabel L_movie;
    private javax.swing.JLabel L_payment;
    private javax.swing.JLabel L_showtime;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_total;
    private javax.swing.JTextField TF_customerName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlSeatContainer;
    // End of variables declaration//GEN-END:variables
}
