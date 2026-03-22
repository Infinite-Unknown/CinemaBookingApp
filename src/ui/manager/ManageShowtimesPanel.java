package ui.manager;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main_logics.BookingService;
import main_logics.MovieService;
import main_logics.ShowtimeService;
import main_running.Movie;
import main_running.Showtime;

/**
 * Panel for managing showtimes - add, update, delete.
 * @author jiahe
 */
public class ManageShowtimesPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManageShowtimesPanel.class.getName());
    private ShowtimeService showtimeService;
    private MovieService movieService;
    private BookingService bookingService;
    private DefaultTableModel tableModel;

    public ManageShowtimesPanel() {
        showtimeService = new ShowtimeService();
        movieService = new MovieService();
        bookingService = new BookingService();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage Showtimes");
        loadMovieCombo();
        loadShowtimes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        L_movie = new javax.swing.JLabel();
        CB_movie = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_showtimes = new javax.swing.JTable();
        L_hall = new javax.swing.JLabel();
        CB_hall = new javax.swing.JComboBox<>();
        L_date = new javax.swing.JLabel();
        TF_date = new javax.swing.JTextField();
        L_time = new javax.swing.JLabel();
        TF_time = new javax.swing.JTextField();
        L_price = new javax.swing.JLabel();
        TF_price = new javax.swing.JTextField();
        BTN_add = new javax.swing.JButton();
        BTN_update = new javax.swing.JButton();
        BTN_delete = new javax.swing.JButton();
        BTN_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Manage Showtimes");

        L_movie.setText("Movie:");
        CB_movie.addActionListener(this::CB_movieActionPerformed);

        tableModel = new DefaultTableModel(
            new String[]{"ID", "Movie", "Hall", "Date", "Time", "Price (RM)", "Available/Total"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        TBL_showtimes.setModel(tableModel);
        TBL_showtimes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TBL_showtimes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_showtimesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_showtimes);

        L_hall.setText("Hall:");
        CB_hall.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Hall 1", "Hall 2", "Hall 3"}));

        L_date.setText("Date (yyyy-MM-dd):");
        L_time.setText("Time (HH:mm):");
        L_price.setText("Base Price (RM):");

        BTN_add.setText("Add Showtime");
        BTN_add.addActionListener(this::BTN_addActionPerformed);

        BTN_update.setText("Update");
        BTN_update.addActionListener(this::BTN_updateActionPerformed);

        BTN_delete.setText("Delete");
        BTN_delete.addActionListener(this::BTN_deleteActionPerformed);

        BTN_clear.setText("Clear");
        BTN_clear.addActionListener(this::BTN_clearActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L_movie)
                        .addGap(10, 10, 10)
                        .addComponent(CB_movie, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_hall)
                            .addComponent(L_date)
                            .addComponent(L_time)
                            .addComponent(L_price))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CB_hall, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_time, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_price, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTN_add, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BTN_update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BTN_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BTN_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(CB_movie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_hall)
                    .addComponent(CB_hall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_date)
                    .addComponent(TF_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_time)
                    .addComponent(TF_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_price)
                    .addComponent(TF_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void loadMovieCombo() {
        CB_movie.removeAllItems();
        CB_movie.addItem("-- All Movies --");
        try {
            List<Movie> movies = movieService.getActiveMovies();
            for (Movie m : movies) {
                CB_movie.addItem(m.getMovieId() + " - " + m.getTitle());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading movies: " + ex.getMessage());
        }
    }

    private void loadShowtimes() {
        tableModel.setRowCount(0);
        try {
            List<Showtime> showtimes;
            String selected = (String) CB_movie.getSelectedItem();
            if (selected != null && !selected.startsWith("--")) {
                String movieId = selected.split(" - ")[0];
                showtimes = showtimeService.getShowtimesByMovie(movieId);
            } else {
                showtimes = showtimeService.getAllShowtimes();
            }

            for (Showtime st : showtimes) {
                Movie movie = movieService.getMovieById(st.getMovieId());
                String movieTitle = movie != null ? movie.getTitle() : st.getMovieId();
                tableModel.addRow(new Object[]{
                    st.getShowtimeId(), movieTitle, st.getHallNumber(),
                    st.getDate(), st.getTime(),
                    String.format("%.2f", st.getBasePrice()),
                    st.getAvailableSeats() + "/" + st.getTotalSeats()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading showtimes: " + ex.getMessage());
        }
    }

    private void CB_movieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_movieActionPerformed
        loadShowtimes();
    }//GEN-LAST:event_CB_movieActionPerformed

    private void TBL_showtimesMouseClicked(java.awt.event.MouseEvent evt) {
        int row = TBL_showtimes.getSelectedRow();
        if (row >= 0) {
            try {
                String stId = tableModel.getValueAt(row, 0).toString();
                Showtime st = showtimeService.getShowtimeById(stId);
                if (st != null) {
                    CB_hall.setSelectedItem(st.getHallNumber());
                    TF_date.setText(st.getDate());
                    TF_time.setText(st.getTime());
                    TF_price.setText(String.format("%.2f", st.getBasePrice()));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    private void BTN_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addActionPerformed
        try {
            String selected = (String) CB_movie.getSelectedItem();
            if (selected == null || selected.startsWith("--")) {
                JOptionPane.showMessageDialog(this, "Please select a movie");
                return;
            }
            String movieId = selected.split(" - ")[0];
            String hall = CB_hall.getSelectedItem().toString();
            String date = TF_date.getText().trim();
            String time = TF_time.getText().trim();
            String priceStr = TF_price.getText().trim();

            if (date.isEmpty() || time.isEmpty() || priceStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields");
                return;
            }

            double price = Double.parseDouble(priceStr);
            String stId = showtimeService.generateShowtimeId();
            int totalSeats = 50;

            Showtime showtime = new Showtime(stId, movieId, hall, date, time, price, totalSeats, totalSeats);
            showtimeService.addShowtime(showtime);

            // Initialize seats for this showtime
            bookingService.initializeSeats(stId);

            loadShowtimes();
            clearFields();
            JOptionPane.showMessageDialog(this, "Showtime added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Price must be a valid number");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding showtime: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_addActionPerformed

    private void BTN_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_updateActionPerformed
        int row = TBL_showtimes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a showtime to update");
            return;
        }
        try {
            String stId = tableModel.getValueAt(row, 0).toString();
            Showtime st = showtimeService.getShowtimeById(stId);
            st.setHallNumber(CB_hall.getSelectedItem().toString());
            st.setDate(TF_date.getText().trim());
            st.setTime(TF_time.getText().trim());
            st.setBasePrice(Double.parseDouble(TF_price.getText().trim()));
            showtimeService.updateShowtime(st);
            loadShowtimes();
            clearFields();
            JOptionPane.showMessageDialog(this, "Showtime updated successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating showtime: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_updateActionPerformed

    private void BTN_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deleteActionPerformed
        int row = TBL_showtimes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a showtime to delete");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this showtime?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String stId = tableModel.getValueAt(row, 0).toString();
                showtimeService.deleteShowtime(stId);
                loadShowtimes();
                clearFields();
                JOptionPane.showMessageDialog(this, "Showtime deleted!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_BTN_deleteActionPerformed

    private void BTN_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_BTN_clearActionPerformed

    private void clearFields() {
        CB_hall.setSelectedIndex(0);
        TF_date.setText("");
        TF_time.setText("");
        TF_price.setText("");
        TBL_showtimes.clearSelection();
    }

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

        java.awt.EventQueue.invokeLater(() -> new ManageShowtimesPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_add;
    private javax.swing.JButton BTN_clear;
    private javax.swing.JButton BTN_delete;
    private javax.swing.JButton BTN_update;
    private javax.swing.JComboBox<String> CB_hall;
    private javax.swing.JComboBox<String> CB_movie;
    private javax.swing.JLabel L_date;
    private javax.swing.JLabel L_hall;
    private javax.swing.JLabel L_movie;
    private javax.swing.JLabel L_price;
    private javax.swing.JLabel L_time;
    private javax.swing.JLabel L_title;
    private javax.swing.JTable TBL_showtimes;
    private javax.swing.JTextField TF_date;
    private javax.swing.JTextField TF_price;
    private javax.swing.JTextField TF_time;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
