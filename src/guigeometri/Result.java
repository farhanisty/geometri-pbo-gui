package guigeometri;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.BangunRuang;

public class Result extends JDialog {
    private BangunDatar bangunDatar;
    
    public Result(JFrame parent, String title, BangunDatar bangunDatar) {
        super(parent, title, true);
        this.bangunDatar = bangunDatar;
        setupDialog();
    }
    
    private void setupDialog() {
        setSize(800, 400);  // Make dialog wider to accommodate image
        setLocationRelativeTo(getParent());
        setResizable(false);
        
        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Left panel for calculation results
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        
        if(bangunDatar instanceof BangunRuang bangunRuang) {
            String luasPermukaan = String.format("%.2f", bangunRuang.hitungLuasPermukaan());
            String volume = String.format("%.2f", bangunRuang.hitungVolume());
            
            JLabel luasPermukaanLabel = new JLabel("Luas Permukaan: " + luasPermukaan + " satuan persegi");
            luasPermukaanLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            luasPermukaanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel volumeLabel = new JLabel("Volume: " + volume + " kubik");
            volumeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            volumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            resultPanel.add(luasPermukaanLabel);
            resultPanel.add(volumeLabel);
        } else {
            String luasStr = String.format("%.2f", bangunDatar.getLuas());
            String kelilingStr = String.format("%.2f", bangunDatar.getKeliling());

            JLabel luasLabel = new JLabel("Luas: " + luasStr + " satuan persegi");
            luasLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            luasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel kelilingLabel = new JLabel("Keliling: " + kelilingStr + " satuan");
            kelilingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            kelilingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultPanel.add(luasLabel);
            resultPanel.add(kelilingLabel);
        }
        
        JButton tutupButton = new JButton("Tutup");
        tutupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tutupButton.addActionListener(e -> dispose());
        
        
        resultPanel.add(Box.createVerticalStrut(10));
        resultPanel.add(Box.createVerticalStrut(20));
        resultPanel.add(tutupButton);
        
        // Right panel for image
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(300, 300));
        
        try {
            // Ambil nama gambar dengan pola yang sama seperti di class menu
            String imagePath = "/gambar/" + bangunDatar.getNama().toLowerCase().replace(" ", "_").replace(".", "") + ".png";

            
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

            
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();  // Debug jika terjadi kesalahan
            JLabel errorLabel = new JLabel("Gambar tidak ditemukan");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imagePanel.add(errorLabel, BorderLayout.CENTER);
        }



        
        // Add panels to main panel
        mainPanel.add(resultPanel, BorderLayout.WEST);
        mainPanel.add(imagePanel, BorderLayout.EAST);
        
        add(mainPanel);
    }
    
    private Image getScaledImage(Image srcImg, int width, int height) {
        double scale = Math.min(
            (double) width / srcImg.getWidth(null),
            (double) height / srcImg.getHeight(null)
        );
        
        int scaledWidth = (int) (srcImg.getWidth(null) * scale);
        int scaledHeight = (int) (srcImg.getHeight(null) * scale);
        
        BufferedImage resizedImg = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, scaledWidth, scaledHeight, null);
        g2.dispose();
        
        return resizedImg;
    }
} 