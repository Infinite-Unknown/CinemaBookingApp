package ui;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import main_running.Seat;

/**
 * Reusable seat selection panel with a 5x10 grid of toggle buttons.
 * Used by both Customer booking and Clerk booking.
 * @author Chan Hao Wen
 */
public class SeatSelectionPanel extends JPanel {

    private JToggleButton[][] seatButtons;
    private List<Seat> seats;
    private static final int ROWS = 5;
    private static final int COLS = 10;
    private static final String[] ROW_LABELS = {"A", "B", "C", "D", "E"};

    public SeatSelectionPanel() {
        seatButtons = new JToggleButton[ROWS][COLS];
        setLayout(new BorderLayout(5, 5));
        setBackground(Color.WHITE);

        // Screen label at top
        JLabel screenLabel = new JLabel("[ SCREEN ]", SwingConstants.CENTER);
        screenLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        screenLabel.setForeground(Color.GRAY);
        screenLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        add(screenLabel, BorderLayout.NORTH);

        // Seat grid
        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS + 1, 3, 3));
        gridPanel.setBackground(Color.WHITE);

        for (int r = 0; r < ROWS; r++) {
            // Row label
            JLabel rowLabel = new JLabel(ROW_LABELS[r], SwingConstants.CENTER);
            rowLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            gridPanel.add(rowLabel);

            for (int c = 0; c < COLS; c++) {
                String seatNum = ROW_LABELS[r] + (c + 1);
                JToggleButton btn = new JToggleButton(seatNum);
                btn.setFont(new Font("Segoe UI", Font.PLAIN, 10));
                btn.setPreferredSize(new Dimension(50, 35));
                btn.setBackground(new Color(144, 238, 144)); // light green = available
                btn.setBorderPainted(true);
                btn.setFocusPainted(false);
                btn.setToolTipText("Seat " + seatNum + " - Available");
                btn.addItemListener(e -> {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        ((JToggleButton) e.getSource()).setBackground(new Color(100, 149, 237));
                    } else {
                        ((JToggleButton) e.getSource()).setBackground(new Color(144, 238, 144));
                    }
                });
                seatButtons[r][c] = btn;
                gridPanel.add(btn);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        // Legend at bottom
        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        legendPanel.setBackground(Color.WHITE);
        legendPanel.add(createLegendItem(new Color(144, 238, 144), "Available"));
        legendPanel.add(createLegendItem(Color.LIGHT_GRAY, "Booked"));
        legendPanel.add(createLegendItem(new Color(100, 149, 237), "Selected"));
        add(legendPanel, BorderLayout.SOUTH);
    }

    private JPanel createLegendItem(Color color, String text) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
        item.setBackground(Color.WHITE);
        JLabel colorBox = new JLabel("  ");
        colorBox.setOpaque(true);
        colorBox.setBackground(color);
        colorBox.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        item.add(colorBox);
        item.add(new JLabel(text));
        return item;
    }

    // Load seats and update button states
    public void loadSeats(List<Seat> seatList) {
        this.seats = seatList;
        for (Seat seat : seatList) {
            String seatNum = seat.getSeatNumber();
            int row = seatNum.charAt(0) - 'A';
            int col = Integer.parseInt(seatNum.substring(1)) - 1;

            if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                JToggleButton btn = seatButtons[row][col];
                if (seat.isIsBooked()) {
                    btn.setEnabled(false);
                    btn.setBackground(Color.LIGHT_GRAY);
                    btn.setToolTipText("Seat " + seatNum + " - Booked");
                } else {
                    btn.setEnabled(true);
                    btn.setBackground(new Color(144, 238, 144));
                    btn.setToolTipText("Seat " + seatNum + " - " + seat.getSeatType());
                }
                btn.setSelected(false);
            }
        }
    }

    // Get list of selected seat numbers
    public List<String> getSelectedSeats() {
        List<String> selected = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (seatButtons[r][c].isSelected() && seatButtons[r][c].isEnabled()) {
                    selected.add(ROW_LABELS[r] + (c + 1));
                }
            }
        }
        return selected;
    }

    // Reset all selections
    public void clearSelection() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                seatButtons[r][c].setSelected(false);
                if (seatButtons[r][c].isEnabled()) {
                    seatButtons[r][c].setBackground(new Color(144, 238, 144));
                }
            }
        }
    }
}
