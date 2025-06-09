package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu extends JFrame {

    JLabel labelHeader = new JLabel("Geometri", SwingConstants.CENTER);
    JLabel label2D = new JLabel("Benda 2D");
    JLabel label3D = new JLabel("Benda 3D");

    JPanel panel2D = new JPanel(new GridLayout(0, 4, 15, 15));
    JPanel panel3D = new JPanel(new GridLayout(0, 4, 15, 15));

    JButton btnKeluar = new JButton("Keluar");

    public menu() {
        setTitle("Menu Utama Geometri");
        setSize(750, 650);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Atur LookAndFeel default (agar background dan style mengikuti bawaan NetBeans)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored) {}

        // Header
        labelHeader.setBounds(200, 10, 350, 40);
        labelHeader.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(labelHeader);

        // Label kategori
        label2D.setBounds(50, 60, 200, 25);
        label2D.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(label2D);

        label3D.setBounds(50, 330, 200, 25);
        label3D.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(label3D);

        // Panel bangun 2D
        panel2D.setBounds(50, 90, 640, 220);
        add(panel2D);

        // Panel bangun 3D
        panel3D.setBounds(50, 360, 640, 180);
        add(panel3D);

        // Tombol keluar
        btnKeluar.setBounds(300, 560, 140, 40);
        btnKeluar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(btnKeluar);

        btnKeluar.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Tambahkan bangun datar (2D)
        String[] bangun2D = {
            "Segitiga", "Persegi", "Persegi Panjang", "Jajar Genjang", "Trapesium",
            "Belah Ketupat", "Layang Layang", "Lingkaran", "Tembereng", "Juring"
        };
        for (String bangun : bangun2D) {
            panel2D.add(createBangunButton(bangun));
        }

        // Tambahkan bangun ruang (3D)
        String[] bangun3D = {
            "Prisma Segitiga", "Limas Segitiga", "Prisma Persegi", "Limas Persegi",
            "Prisma P. Panjang", "Limas P. Panjang", "Prisma J. Genjang", "Limas J. Genjang",
            "Prisma Trapesium", "Limas Trapesium", "Tabung", "Kerucut",
            "Kerucut Terpancung", "Bola", "Tembereng Bola", "Juring Bola", "Cincin Bola"
        };
        for (String bangun : bangun3D) {
            panel3D.add(createBangunButton(bangun));
        }
    }

    private JPanel createBangunButton(String namaBangun) {
        JPanel box = new JPanel();
        box.setLayout(new BorderLayout());
        box.setPreferredSize(new Dimension(140, 100));
        box.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        // Gambar/icon
        JLabel gambar = new JLabel();
        try {
            String path = "/gambar/" + namaBangun.toLowerCase().replace(" ", "_").replace(".", "") + ".png";
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            gambar.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            gambar.setText("🧱"); // fallback jika gambar tidak ditemukan
            gambar.setHorizontalAlignment(SwingConstants.CENTER);
        }

        JLabel label = new JLabel(namaBangun, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        box.add(gambar, BorderLayout.CENTER);
        box.add(label, BorderLayout.SOUTH);

        box.setCursor(new Cursor(Cursor.HAND_CURSOR));

        box.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Menu " + namaBangun + " dibuka.");
            }
        });

        return box;
    }

    public void tampilkanMenu() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new menu().tampilkanMenu();
    }
}
