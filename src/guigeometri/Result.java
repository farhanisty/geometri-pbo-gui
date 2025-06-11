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
    private JLabel loadingLabel;
    private Timer dotTimer;
    
    public Result(JFrame parent, String title, BangunDatar bangunDatar) {
        super(parent, title, false);
        this.bangunDatar = bangunDatar;
        
        setSize(800, 400);  // Make dialog wider to accommodate image
        setLocationRelativeTo(getParent());
        setResizable(false);
        
        SwingUtilities.invokeLater(() -> {
            this.setupDialog();
        });
        
    }

    private void startDotAnimation() {
        dotTimer = new Timer(500, new java.awt.event.ActionListener() {
            int dotCount = 0;

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dotCount = (dotCount + 1) % 4; 
                String dots = ".".repeat(dotCount);
                loadingLabel.setText("Menghitung" + dots);
            }
        });
        dotTimer.start();
    }
    
    private void setupDialog() {
        CardLayout cardLayout = new CardLayout();
        JPanel containerPanel = new JPanel(cardLayout);
        add(containerPanel); // Hanya satu kali add ke JFrame/JDialog

        // -------------------- PANEL LOADING --------------------
        JPanel loadingPanel = new JPanel(new BorderLayout());
        loadingLabel = new JLabel("Menghitung, mohon tunggu");
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        loadingPanel.add(loadingLabel, BorderLayout.CENTER);

        dotTimer = new Timer(500, new java.awt.event.ActionListener() {
            int dotCount = 0;

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dotCount = (dotCount + 1) % 4; 
                String dots = ".".repeat(dotCount);
                loadingLabel.setText("Menghitung" + dots);
            }
        });
        dotTimer.start();

        containerPanel.add(loadingPanel, "loading");

        // -------------------- PANEL MAIN --------------------
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(300, 300));

        try {
            String imagePath = "/gambar/" + bangunDatar.getNama().toLowerCase().replace(" ", "_").replace(".", "") + ".png";
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Gambar tidak ditemukan");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imagePanel.add(errorLabel, BorderLayout.CENTER);
        }

        mainPanel.add(resultPanel, BorderLayout.WEST);
        mainPanel.add(imagePanel, BorderLayout.EAST);
        containerPanel.add(mainPanel, "main");

        // -------------------- WORKER --------------------
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                bangunDatar.run(); // proses hitung
                return null;
            }

            @Override
            protected void done() {
                dotTimer.stop();

                if(bangunDatar instanceof BangunRuang bangunRuang) {
                    resultPanel.add(new JLabel("Luas Permukaan: " + bangunRuang.hitungLuasPermukaan()));
                    resultPanel.add(new JLabel("Volume: " + bangunRuang.hitungVolume()));
                } else {
                    resultPanel.add(new JLabel("Luas: " + bangunDatar.getLuas()));
                    resultPanel.add(new JLabel("Keliling: " + bangunDatar.getKeliling()));
                }

                JButton tutupButton = new JButton("Tutup");
                tutupButton.addActionListener(e -> dispose());
                resultPanel.add(tutupButton);

                mainPanel.revalidate();
                mainPanel.repaint();

                // Ganti panel loading ke panel hasil
                cardLayout.show(containerPanel, "main");
            }
        };

        worker.execute();

        // Tampilkan panel loading pertama kali
        cardLayout.show(containerPanel, "loading");
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