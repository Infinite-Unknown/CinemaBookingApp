package ui.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import main_logics.FileHandler;

/**
 * Panel for managing discount pricing policies.
 * @author jiahe
 */
public class ManagePricingPanel extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManagePricingPanel.class.getName());
    private static final String DISCOUNTS_FILE = "discounts.txt";

    public ManagePricingPanel() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage Pricing & Discounts");
        loadDiscounts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_title = new javax.swing.JLabel();
        L_senior = new javax.swing.JLabel();
        TF_senior = new javax.swing.JTextField();
        L_seniorPct = new javax.swing.JLabel();
        L_student = new javax.swing.JLabel();
        TF_student = new javax.swing.JTextField();
        L_studentPct = new javax.swing.JLabel();
        L_child = new javax.swing.JLabel();
        TF_child = new javax.swing.JTextField();
        L_childPct = new javax.swing.JLabel();
        BTN_save = new javax.swing.JButton();
        L_info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        L_title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        L_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_title.setText("Discount Policies");

        L_senior.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_senior.setText("Senior Citizen Discount:");
        TF_senior.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_seniorPct.setText("%");

        L_student.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_student.setText("Student Discount:");
        TF_student.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_studentPct.setText("%");

        L_child.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_child.setText("Child Discount:");
        TF_child.setFont(new java.awt.Font("Segoe UI", 0, 14));
        L_childPct.setText("%");

        BTN_save.setFont(new java.awt.Font("Segoe UI", 0, 14));
        BTN_save.setText("Save Discounts");
        BTN_save.addActionListener(this::BTN_saveActionPerformed);

        L_info.setFont(new java.awt.Font("Segoe UI", 2, 12));
        L_info.setForeground(new java.awt.Color(102, 102, 102));
        L_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_info.setText("Discounts are applied as percentage off the base ticket price");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_title, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(L_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_senior)
                    .addComponent(L_student)
                    .addComponent(L_child))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF_senior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_student, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_child, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_seniorPct)
                    .addComponent(L_studentPct)
                    .addComponent(L_childPct))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_save, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(L_title)
                .addGap(10, 10, 10)
                .addComponent(L_info)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_senior)
                    .addComponent(TF_senior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_seniorPct))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_student)
                    .addComponent(TF_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_studentPct))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_child)
                    .addComponent(TF_child, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_childPct))
                .addGap(25, 25, 25)
                .addComponent(BTN_save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void loadDiscounts() {
        try {
            List<String> lines = FileHandler.readLines(DISCOUNTS_FILE);
            for (String line : lines) {
                String[] parts = line.split("\\|");
                switch (parts[0]) {
                    case "SENIOR": TF_senior.setText(parts[1]); break;
                    case "STUDENT": TF_student.setText(parts[1]); break;
                    case "CHILD": TF_child.setText(parts[1]); break;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading discounts: " + ex.getMessage());
        }
    }

    private void BTN_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_saveActionPerformed
        try {
            int senior = Integer.parseInt(TF_senior.getText().trim());
            int student = Integer.parseInt(TF_student.getText().trim());
            int child = Integer.parseInt(TF_child.getText().trim());

            if (senior < 0 || senior > 100 || student < 0 || student > 100 || child < 0 || child > 100) {
                JOptionPane.showMessageDialog(this, "Discount must be between 0 and 100");
                return;
            }

            List<String> lines = new ArrayList<>();
            lines.add("SENIOR|" + senior);
            lines.add("STUDENT|" + student);
            lines.add("CHILD|" + child);
            FileHandler.writeLines(DISCOUNTS_FILE, lines);
            JOptionPane.showMessageDialog(this, "Discounts saved successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving discounts: " + ex.getMessage());
        }
    }//GEN-LAST:event_BTN_saveActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new ManagePricingPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_save;
    private javax.swing.JLabel L_child;
    private javax.swing.JLabel L_childPct;
    private javax.swing.JLabel L_info;
    private javax.swing.JLabel L_senior;
    private javax.swing.JLabel L_seniorPct;
    private javax.swing.JLabel L_student;
    private javax.swing.JLabel L_studentPct;
    private javax.swing.JLabel L_title;
    private javax.swing.JTextField TF_child;
    private javax.swing.JTextField TF_senior;
    private javax.swing.JTextField TF_student;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
