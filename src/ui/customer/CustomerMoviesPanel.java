package ui.customer;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main_logics.MovieService;
import main_running.Customer;
import main_running.Movie;

/**
 * Panel showing active movies with option to book tickets.
 * @author jiahe
 */
public class CustomerMoviesPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomerMoviesPanel.class.getName());
    private Customer customer;
    private MovieService movieService;
    private DefaultTableModel tableModel;

    public CustomerMoviesPanel(Customer customer) {
        this.customer = customer;
        movieService = new MovieService();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Now Showing");
        loadMovies();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_movies = new javax.swing.JTable();
        BTN_book = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Now Showing");

        tableModel = new DefaultTableModel(
            new String[]{"Movie ID", "Title", "Genre", "Duration", "Language", "Rating"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        TBL_movies.setModel(tableModel);
        TBL_movies.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TBL_movies);

        BTN_book.setFont(new java.awt.Font("Segoe UI", 0, 14));
        BTN_book.setText("Book Tickets");
        BTN_book.addActionListener(this::BTN_bookActionPerformed);

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
                        .addComponent(BTN_book, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(L_title)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(BTN_book, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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

    private void loadMovies() {
        tableModel.setRowCount(0);
        try {
            List<Movie> movies = movieService.getActiveMovies();
            for (Movie m : movies) {
                tableModel.addRow(new Object[]{
                    m.getMovieId(), m.getTitle(), m.getGenre(),
                    m.getDurationMinutes() + " min", m.getLanguage(), m.getRating()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading movies: " + ex.getMessage());
        }
    }

    private void BTN_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_bookActionPerformed
        int row = TBL_movies.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a movie to book");
            return;
        }
        String movieId = tableModel.getValueAt(row, 0).toString();
        try {
            Movie movie = movieService.getMovieById(movieId);
            new BookingPanel(customer, movie, () -> {}).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_bookActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new CustomerMoviesPanel(
                new Customer("U003", "cust1", "cust123", "Jane Customer", "jane@email.com", "012-3456789", "2026-01-15")
        ).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_book;
    private javax.swing.JLabel L_title;
    private javax.swing.JTable TBL_movies;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
