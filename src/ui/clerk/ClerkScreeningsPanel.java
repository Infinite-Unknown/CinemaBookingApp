package ui.clerk;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main_logics.*;
import main_running.*;

/**
 * Panel for clerks to view current screenings/showtimes.
 * @author Chan Hao Wen
 */
public class ClerkScreeningsPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClerkScreeningsPanel.class.getName());
    private ShowtimeService showtimeService;
    private MovieService movieService;
    private DefaultTableModel tableModel;

    public ClerkScreeningsPanel() {
        showtimeService = new ShowtimeService();
        movieService = new MovieService();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Current Screenings");
        loadScreenings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_screenings = new javax.swing.JTable();
        BTN_refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Current Screenings");

        tableModel = new DefaultTableModel(
            new String[]{"Movie", "Hall", "Date", "Time", "Price (RM)", "Available Seats"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        TBL_screenings.setModel(tableModel);
        jScrollPane1.setViewportView(TBL_screenings);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
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

    private void loadScreenings() {
        tableModel.setRowCount(0);
        try {
            List<Showtime> showtimes = showtimeService.getAllShowtimes();
            for (Showtime st : showtimes) {
                Movie movie = movieService.getMovieById(st.getMovieId());
                String movieTitle = movie != null ? movie.getTitle() : st.getMovieId();
                tableModel.addRow(new Object[]{
                    movieTitle, st.getHallNumber(), st.getDate(), st.getTime(),
                    String.format("%.2f", st.getBasePrice()), st.getAvailableSeats()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading screenings: " + ex.getMessage());
        }
    }

    private void BTN_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_refreshActionPerformed
        loadScreenings();
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

        java.awt.EventQueue.invokeLater(() -> new ClerkScreeningsPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_refresh;
    private javax.swing.JLabel L_title;
    private javax.swing.JTable TBL_screenings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
