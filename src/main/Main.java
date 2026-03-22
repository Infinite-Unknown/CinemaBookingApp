package main;

import ui.LoginFrame;

/**
 * Main entry point for the Cinema Booking Application.
 * @author jiahe
 */
public class Main {

    public static void main(String[] args) {
        // Set Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Launch login frame
        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
