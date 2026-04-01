package ui.customer;

import java.io.IOException;
import java.util.List;
import javax.swing.*;
import main_logics.*;
import main_running.*;
import ui.SeatSelectionPanel;
import ui.ReceiptDialog;

/**
 * Booking panel for selecting showtime, seats, and making payment.
 * @author Lam Ming Joe
 */
public class BookingPanel extends javax.swing.JFrame {

    private Customer customer;
    private Movie movie;
    private Runnable onBookingComplete;
    private ShowtimeService showtimeService;
    private BookingService bookingService;
    private PaymentService paymentService;
    private SeatSelectionPanel seatPanel;
    private List<Showtime> showtimes;

    public BookingPanel(Customer customer, Movie movie, Runnable onBookingComplete) {
        this.customer = customer;
        this.movie = movie;
        this.onBookingComplete = onBookingComplete;
        showtimeService = new ShowtimeService();
        bookingService = new BookingService();
        paymentService = new PaymentService();
        initComponents();
        seatPanel = new ui.SeatSelectionPanel();
        pnlSeatContainer.setLayout(new java.awt.BorderLayout());
        pnlSeatContainer.add(seatPanel);
        setLocationRelativeTo(null);
        setTitle("Book Tickets - " + movie.getTitle());
        loadShowtimes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_movieTitle = new javax.swing.JLabel();
        L_movieTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        L_movieTitle.setText(movie.getTitle() + " (" + movie.getRating() + ")");

        L_movieInfo = new javax.swing.JLabel();
        L_movieInfo.setFont(new java.awt.Font("Segoe UI", 0, 12));
        L_movieInfo.setForeground(new java.awt.Color(102, 102, 102));
        L_movieInfo.setText(movie.getGenre() + " | " + movie.getDurationMinutes() + " min | " + movie.getLanguage());

        L_showtime = new javax.swing.JLabel();
        L_showtime.setText("Select Showtime:");
        L_showtime.setFont(new java.awt.Font("Segoe UI", 0, 14));
        CB_showtime = new javax.swing.JComboBox<>();
        CB_showtime.addActionListener(this::CB_showtimeActionPerformed);

        pnlSeatContainer = new javax.swing.JPanel();
        pnlSeatContainer.setPreferredSize(new java.awt.Dimension(600, 250));

        L_discount = new javax.swing.JLabel();
        L_discount.setText("Discount Type:");
        CB_discount = new javax.swing.JComboBox<>(new String[]{"None", "Student", "Senior Citizen", "Child"});

        L_payment = new javax.swing.JLabel();
        L_payment.setText("Payment Method:");
        CB_payment = new javax.swing.JComboBox<>(new String[]{"CASH", "CARD"});

        L_total = new javax.swing.JLabel();
        L_total.setFont(new java.awt.Font("Segoe UI", 1, 16));
        L_total.setText("Total: RM 0.00");

        BTN_calculate = new javax.swing.JButton();
        BTN_calculate.setText("Calculate Total");
        BTN_calculate.addActionListener(this::BTN_calculateActionPerformed);

        BTN_confirm = new javax.swing.JButton();
        BTN_confirm.setText("Confirm & Pay");
        BTN_confirm.setFont(new java.awt.Font("Segoe UI", 1, 14));
        BTN_confirm.addActionListener(this::BTN_confirmActionPerformed);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_movieTitle)
                    .addComponent(L_movieInfo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L_showtime)
                        .addGap(10, 10, 10)
                        .addComponent(CB_showtime, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSeatContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L_discount)
                        .addGap(10, 10, 10)
                        .addComponent(CB_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(L_payment)
                        .addGap(10, 10, 10)
                        .addComponent(CB_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTN_calculate)
                        .addGap(20, 20, 20)
                        .addComponent(L_total)
                        .addGap(20, 20, 20)
                        .addComponent(BTN_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(L_movieTitle)
                .addGap(3, 3, 3)
                .addComponent(L_movieInfo)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_showtime)
                    .addComponent(CB_showtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(pnlSeatContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_discount)
                    .addComponent(CB_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_payment)
                    .addComponent(CB_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_calculate)
                    .addComponent(L_total)
                    .addComponent(BTN_confirm))
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

    private void loadShowtimes() {
        CB_showtime.removeAllItems();
        try {
            showtimes = showtimeService.getShowtimesByMovie(movie.getMovieId());
            if (showtimes.isEmpty()) {
                CB_showtime.addItem("No showtimes available");
                return;
            }
            for (Showtime st : showtimes) {
                CB_showtime.addItem(st.getShowtimeId() + " | " + st.getHallNumber() + " | "
                        + st.getDate() + " " + st.getTime() + " | RM " + String.format("%.2f", st.getBasePrice())
                        + " | " + st.getAvailableSeats() + " seats left");
            }
            loadSeatsForSelectedShowtime();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading showtimes: " + ex.getMessage());
        }
    }

    private void loadSeatsForSelectedShowtime() {
        int idx = CB_showtime.getSelectedIndex();
        if (idx >= 0 && idx < showtimes.size()) {
            try {
                Showtime st = showtimes.get(idx);
                List<Seat> seats = bookingService.getSeatsByShowtime(st.getShowtimeId());
                seatPanel.loadSeats(seats);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading seats: " + ex.getMessage());
            }
        }
    }

    private void CB_showtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_showtimeActionPerformed
        loadSeatsForSelectedShowtime();
    }//GEN-LAST:event_CB_showtimeActionPerformed

    private double getDiscountPercent() {
        try {
            List<String> discLines = FileHandler.readLines("discounts.txt");
            String selected = CB_discount.getSelectedItem().toString();
            String key = "";
            switch (selected) {
                case "Student": key = "STUDENT"; break;
                case "Senior Citizen": key = "SENIOR"; break;
                case "Child": key = "CHILD"; break;
                default: return 0;
            }
            for (String line : discLines) {
                String[] parts = line.split("\\|");
                if (parts[0].equals(key)) {
                    return Double.parseDouble(parts[1]);
                }
            }
        } catch (Exception ex) {
            // ignore, return 0
        }
        return 0;
    }

    private void BTN_calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_calculateActionPerformed
        List<String> selectedSeats = seatPanel.getSelectedSeats();
        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one seat");
            return;
        }
        int idx = CB_showtime.getSelectedIndex();
        if (idx >= 0 && idx < showtimes.size()) {
            Showtime st = showtimes.get(idx);
            double discountPct = getDiscountPercent();
            double total = bookingService.calculateTotal(st, selectedSeats.size(), discountPct);
            L_total.setText("Total: RM " + String.format("%.2f", total));
        }
    }//GEN-LAST:event_BTN_calculateActionPerformed

    private void BTN_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_confirmActionPerformed
        List<String> selectedSeats = seatPanel.getSelectedSeats();
        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one seat");
            return;
        }
        int idx = CB_showtime.getSelectedIndex();
        if (idx < 0 || idx >= showtimes.size()) {
            JOptionPane.showMessageDialog(this, "Please select a showtime");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Confirm booking for " + selectedSeats.size() + " seat(s)?",
                "Confirm Booking", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            Showtime st = showtimes.get(idx);
            double discountPct = getDiscountPercent();
            double subtotal = st.getBasePrice() * selectedSeats.size();
            double discountAmount = subtotal * (discountPct / 100.0);
            double total = subtotal - discountAmount;

            // Create booking
            Booking booking = bookingService.createBooking(
                    customer.getUserId(), st.getShowtimeId(),
                    selectedSeats, customer.getUserId());

            // Process payment
            String paymentMethod = CB_payment.getSelectedItem().toString();
            Payment payment = paymentService.processPayment(
                    booking.getBookingId(), total, paymentMethod, discountAmount);

            // Show receipt
            Movie movieObj = movie;
            String receipt = paymentService.generateReceipt(booking, payment, movieObj, st);
            new ReceiptDialog(this, receipt).setVisible(true);

            // Refresh parent if callback provided
            if (onBookingComplete != null) {
                onBookingComplete.run();
            }

            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Booking failed: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_confirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_calculate;
    private javax.swing.JButton BTN_confirm;
    private javax.swing.JComboBox<String> CB_discount;
    private javax.swing.JComboBox<String> CB_payment;
    private javax.swing.JComboBox<String> CB_showtime;
    private javax.swing.JLabel L_discount;
    private javax.swing.JLabel L_movieInfo;
    private javax.swing.JLabel L_movieTitle;
    private javax.swing.JLabel L_payment;
    private javax.swing.JLabel L_showtime;
    private javax.swing.JLabel L_total;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlSeatContainer;
    // End of variables declaration//GEN-END:variables
}
