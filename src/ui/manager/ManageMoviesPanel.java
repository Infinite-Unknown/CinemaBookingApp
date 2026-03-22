package ui.manager;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main_logics.MovieService;
import main_running.Movie;

/**
 * Panel for managing movies - add, update, delete.
 * @author jiahe
 */
public class ManageMoviesPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManageMoviesPanel.class.getName());
    private MovieService movieService;
    private DefaultTableModel tableModel;

    public ManageMoviesPanel() {
        movieService = new MovieService();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage Movies");
        loadMovies();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_movies = new javax.swing.JTable();
        L_movieTitle = new javax.swing.JLabel();
        TF_title = new javax.swing.JTextField();
        L_genre = new javax.swing.JLabel();
        CB_genre = new javax.swing.JComboBox<>();
        L_duration = new javax.swing.JLabel();
        TF_duration = new javax.swing.JTextField();
        L_language = new javax.swing.JLabel();
        CB_language = new javax.swing.JComboBox<>();
        L_rating = new javax.swing.JLabel();
        CB_rating = new javax.swing.JComboBox<>();
        L_description = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_description = new javax.swing.JTextArea();
        BTN_add = new javax.swing.JButton();
        BTN_update = new javax.swing.JButton();
        BTN_delete = new javax.swing.JButton();
        BTN_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Manage Movies");

        tableModel = new DefaultTableModel(
            new String[]{"ID", "Title", "Genre", "Duration", "Language", "Rating", "Active"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        TBL_movies.setModel(tableModel);
        TBL_movies.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TBL_movies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_moviesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_movies);

        L_movieTitle.setText("Title:");
        L_genre.setText("Genre:");
        L_duration.setText("Duration (min):");
        L_language.setText("Language:");
        L_rating.setText("Rating:");
        L_description.setText("Description:");

        CB_genre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Action", "Comedy", "Drama", "Horror", "Sci-Fi", "Romance", "Thriller", "Animation", "Adventure"}));

        CB_language.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "English", "Malay", "Chinese", "Tamil", "Korean", "Japanese"}));

        CB_rating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "G", "PG", "PG-13", "R", "NC-17"}));

        TA_description.setColumns(20);
        TA_description.setRows(3);
        TA_description.setLineWrap(true);
        TA_description.setWrapStyleWord(true);
        jScrollPane2.setViewportView(TA_description);

        BTN_add.setText("Add Movie");
        BTN_add.addActionListener(this::BTN_addActionPerformed);

        BTN_update.setText("Update Movie");
        BTN_update.addActionListener(this::BTN_updateActionPerformed);

        BTN_delete.setText("Remove Movie");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_movieTitle)
                            .addComponent(L_genre)
                            .addComponent(L_duration)
                            .addComponent(L_language)
                            .addComponent(L_rating)
                            .addComponent(L_description))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_title)
                            .addComponent(CB_genre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TF_duration)
                            .addComponent(CB_language, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_rating, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTN_add, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BTN_update, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BTN_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BTN_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(L_title)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_movieTitle)
                    .addComponent(TF_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_genre)
                    .addComponent(CB_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_duration)
                    .addComponent(TF_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_language)
                    .addComponent(CB_language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_rating)
                    .addComponent(CB_rating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_description)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void loadMovies() {
        tableModel.setRowCount(0);
        try {
            List<Movie> movies = movieService.getAllMovies();
            for (Movie m : movies) {
                tableModel.addRow(new Object[]{
                    m.getMovieId(), m.getTitle(), m.getGenre(),
                    m.getDurationMinutes() + " min", m.getLanguage(),
                    m.getRating(), m.isIsActive() ? "Yes" : "No"
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading movies: " + ex.getMessage());
        }
    }

    private void TBL_moviesMouseClicked(java.awt.event.MouseEvent evt) {
        int row = TBL_movies.getSelectedRow();
        if (row >= 0) {
            try {
                String movieId = tableModel.getValueAt(row, 0).toString();
                Movie movie = movieService.getMovieById(movieId);
                if (movie != null) {
                    TF_title.setText(movie.getTitle());
                    CB_genre.setSelectedItem(movie.getGenre());
                    TF_duration.setText(String.valueOf(movie.getDurationMinutes()));
                    CB_language.setSelectedItem(movie.getLanguage());
                    CB_rating.setSelectedItem(movie.getRating());
                    TA_description.setText(movie.getDescription());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    private void BTN_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addActionPerformed
        try {
            String title = TF_title.getText().trim();
            String genre = CB_genre.getSelectedItem().toString();
            String durationStr = TF_duration.getText().trim();
            String language = CB_language.getSelectedItem().toString();
            String rating = CB_rating.getSelectedItem().toString();
            String description = TA_description.getText().trim();

            if (title.isEmpty() || durationStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in title and duration");
                return;
            }

            int duration = Integer.parseInt(durationStr);
            String movieId = movieService.generateMovieId();
            Movie movie = new Movie(movieId, title, genre, duration, language, rating, description, true);
            movieService.addMovie(movie);
            loadMovies();
            clearFields();
            JOptionPane.showMessageDialog(this, "Movie added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Duration must be a number");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding movie: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_addActionPerformed

    private void BTN_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_updateActionPerformed
        int row = TBL_movies.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a movie to update");
            return;
        }
        try {
            String movieId = tableModel.getValueAt(row, 0).toString();
            String title = TF_title.getText().trim();
            String durationStr = TF_duration.getText().trim();

            if (title.isEmpty() || durationStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in title and duration");
                return;
            }

            int duration = Integer.parseInt(durationStr);
            Movie movie = movieService.getMovieById(movieId);
            movie.setTitle(title);
            movie.setGenre(CB_genre.getSelectedItem().toString());
            movie.setDurationMinutes(duration);
            movie.setLanguage(CB_language.getSelectedItem().toString());
            movie.setRating(CB_rating.getSelectedItem().toString());
            movie.setDescription(TA_description.getText().trim());
            movieService.updateMovie(movie);
            loadMovies();
            clearFields();
            JOptionPane.showMessageDialog(this, "Movie updated successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Duration must be a number");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating movie: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_updateActionPerformed

    private void BTN_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deleteActionPerformed
        int row = TBL_movies.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a movie to remove");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to remove this movie?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String movieId = tableModel.getValueAt(row, 0).toString();
                movieService.deleteMovie(movieId);
                loadMovies();
                clearFields();
                JOptionPane.showMessageDialog(this, "Movie removed successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error removing movie: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_BTN_deleteActionPerformed

    private void BTN_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_BTN_clearActionPerformed

    private void clearFields() {
        TF_title.setText("");
        CB_genre.setSelectedIndex(0);
        TF_duration.setText("");
        CB_language.setSelectedIndex(0);
        CB_rating.setSelectedIndex(0);
        TA_description.setText("");
        TBL_movies.clearSelection();
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

        java.awt.EventQueue.invokeLater(() -> new ManageMoviesPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_add;
    private javax.swing.JButton BTN_clear;
    private javax.swing.JButton BTN_delete;
    private javax.swing.JButton BTN_update;
    private javax.swing.JComboBox<String> CB_genre;
    private javax.swing.JComboBox<String> CB_language;
    private javax.swing.JComboBox<String> CB_rating;
    private javax.swing.JLabel L_description;
    private javax.swing.JLabel L_duration;
    private javax.swing.JLabel L_genre;
    private javax.swing.JLabel L_language;
    private javax.swing.JLabel L_movieTitle;
    private javax.swing.JLabel L_rating;
    private javax.swing.JLabel L_title;
    private javax.swing.JTextArea TA_description;
    private javax.swing.JTable TBL_movies;
    private javax.swing.JTextField TF_duration;
    private javax.swing.JTextField TF_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
