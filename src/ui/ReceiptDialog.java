package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog to display a formatted receipt.
 * @author jiahe
 */
public class ReceiptDialog extends javax.swing.JDialog {

    public ReceiptDialog(java.awt.Window parent, String receiptText) {
        super(parent, "Receipt", ModalityType.APPLICATION_MODAL);
        initComponents(receiptText);
        setLocationRelativeTo(parent);
    }

    private void initComponents(String receiptText) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTextArea textArea = new JTextArea(receiptText);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 350));

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(closeBtn);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        pack();
    }
}
