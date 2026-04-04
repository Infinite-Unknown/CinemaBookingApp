package ui.manager;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main_logics.*;
import main_running.*;

// @author jiahe
public class ReportsPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportsPanel.class.getName());
    private final BookingService bookingService;
    private final MovieService movieService;
    private final ShowtimeService showtimeService;
    private DefaultTableModel tableModel;

    public ReportsPanel() {
        bookingService = new BookingService();
        movieService = new MovieService();
        showtimeService = new ShowtimeService();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Booking Reports");
        loadReport();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_report = new javax.swing.JTable();
        BTN_refresh = new javax.swing.JButton();
        L_totalBookings = new javax.swing.JLabel();
        L_totalRevenue = new javax.swing.JLabel();
        L_confirmedBookings = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Booking & Revenue Reports");

        tableModel = new DefaultTableModel(
            new String[]{"Booking ID", "Movie", "Hall", "Date/Time", "Seats", "Amount (RM)", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        TBL_report.setModel(tableModel);
        jScrollPane1.setViewportView(TBL_report);

        BTN_refresh.setText("Refresh");
        BTN_refresh.addActionListener(this::BTN_refreshActionPerformed);

        L_totalBookings.setFont(new java.awt.Font("Segoe UI", 1, 14));
        L_totalBookings.setText("Total Bookings: 0");

        L_totalRevenue.setFont(new java.awt.Font("Segoe UI", 1, 14));
        L_totalRevenue.setForeground(new java.awt.Color(0, 128, 0));
        L_totalRevenue.setText("Total Revenue: RM 0.00");

        L_confirmedBookings.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_confirmedBookings.setText("Confirmed: 0 | Cancelled: 0");

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
                        .addComponent(L_totalBookings)
                        .addGap(30, 30, 30)
                        .addComponent(L_totalRevenue)
                        .addGap(30, 30, 30)
                        .addComponent(L_confirmedBookings))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(L_title)
                .addGap(10, 10, 10)
                .addComponent(BTN_refresh)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_totalBookings)
                    .addComponent(L_totalRevenue)
                    .addComponent(L_confirmedBookings))
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

    // load all bookings and calculate stats
    private void loadReport() {
        tableModel.setRowCount(0);
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            int confirmed = 0;
            int cancelled = 0;
            double totalRevenue = 0;

            for (Booking b : bookings) {
                Showtime st = showtimeService.getShowtimeById(b.getShowtimeId());
                Movie movie = null;
                String movieTitle = "N/A";
                String hallDatetime = "N/A";

                if (st != null) {
                    movie = movieService.getMovieById(st.getMovieId());
                    movieTitle = movie != null ? movie.getTitle() : st.getMovieId();
                    hallDatetime = st.getDate() + " " + st.getTime();
                }

                tableModel.addRow(new Object[]{
                    b.getBookingId(), movieTitle,
                    st != null ? st.getHallNumber() : "N/A",
                    hallDatetime, b.getSeatNumbers(),
                    String.format("%.2f", b.getTotalAmount()), b.getStatus()
                });

                if (b.getStatus().equals("CONFIRMED")) {
                    confirmed++;
                    totalRevenue += b.getTotalAmount();
                } else {
                    cancelled++;
                }
            }

            L_totalBookings.setText("Total Bookings: " + bookings.size());
            L_totalRevenue.setText("Total Revenue: RM " + String.format("%.2f", totalRevenue));
            L_confirmedBookings.setText("Confirmed: " + confirmed + " | Cancelled: " + cancelled);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading report: " + ex.getMessage());
        }
    }

    private void BTN_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_refreshActionPerformed
        loadReport();
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

        java.awt.EventQueue.invokeLater(() -> new ReportsPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_refresh;
    private javax.swing.JLabel L_confirmedBookings;
    private javax.swing.JLabel L_title;
    private javax.swing.JLabel L_totalBookings;
    private javax.swing.JLabel L_totalRevenue;
    private javax.swing.JTable TBL_report;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
