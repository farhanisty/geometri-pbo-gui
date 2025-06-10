package guigeometri;

import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {
    
    public Result(double luas, double keliling) {
        setTitle("Hasil Perhitungan Trapesium");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Header
        JLabel headerLabel = new JLabel("Hasil Perhitungan");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(headerLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Results panel
        JPanel resultsPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        
        // Format results to 2 decimal places
        String luasStr = String.format("%.2f", luas);
        String kelilingStr = String.format("%.2f", keliling);
        
        JLabel luasLabel = new JLabel("Luas: " + luasStr + " satuan persegi");
        luasLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        resultsPanel.add(luasLabel);
        
        JLabel kelilingLabel = new JLabel("Keliling: " + kelilingStr + " satuan");
        kelilingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        resultsPanel.add(kelilingLabel);
        
        mainPanel.add(resultsPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Close button
        JButton tutupButton = new JButton("Tutup");
        tutupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tutupButton.addActionListener(e -> dispose());
        mainPanel.add(tutupButton);
        
        add(mainPanel);
    }
} 