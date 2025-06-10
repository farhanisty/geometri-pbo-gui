package guigeometri;

import geometri.benda.geometri.belahketupat.BelahKetupat;
import geometri.benda.geometri.persegi.Persegi;
import guigeometri.Inputable;
import javax.swing.*;
import java.awt.*;

public class Input extends JFrame {
    private String bangunType;
    private JPanel inputPanel;
    private JPanel mainPanel;
    
    public Input() {
        this("Trapesium"); 
    }
    
    public Input(String type) {
        this.bangunType = type;
        setupFrame();
        createComponents();
    }
    
    private void setupFrame() {
        setTitle("Input Ukuran " + bangunType);
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Header
        JLabel headerLabel = new JLabel("Masukkan Ukuran " + bangunType);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(headerLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        
        add(mainPanel);
    }
    
    private void createComponents() {
        inputPanel = new JPanel();
        
        switch (bangunType) {
            case "Trapesium":
                createTrapesiumInputs();
                break;
            
            default:
                JLabel label = new JLabel("Bentuk " + bangunType + " belum diimplementasikan");
                inputPanel.add(label);
                break;
        }
        
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton hitungButton = new JButton("Hitung");
        JButton batalButton = new JButton("Batal");
        
        hitungButton.addActionListener(e -> hitungBangun());
        batalButton.addActionListener(e -> dispose());
        
        buttonPanel.add(hitungButton);
        buttonPanel.add(batalButton);
        
        mainPanel.add(buttonPanel);
    }
    
    private void createTrapesiumInputs() {
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));
        
        Inputable inputable = new BelahKetupat(0, 0, 0);
        
        for(String input: inputable.getInputs()) {
            addInputField(input);
        }
        // Create and add input fields
//        addInputField("Sisi Atas (a)");
//        addInputField("Sisi Bawah (b)");
//        addInputField("Tinggi (t)");
//        addInputField("Sisi Miring Kiri");
//        addInputField("Sisi Miring Kanan");
    }
    
    private JTextField addInputField(String label) {
        inputPanel.add(new JLabel(label + ":"));
        JTextField field = new JTextField();
        inputPanel.add(field);
        return field;
    }
    
    private void hitungBangun() {
        switch (bangunType) {
            case "Trapesium":
                hitungTrapesium();
                break;
            default:
                JOptionPane.showMessageDialog(this,
                    "Perhitungan untuk " + bangunType + " belum diimplementasikan",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    private void hitungTrapesium() {
        try {
            
            Component[] components = inputPanel.getComponents();
            double[] values = new double[5];
            int valueIndex = 0;
            
            for (Component comp : components) {
                if (comp instanceof JTextField) {
                    values[valueIndex++] = Double.parseDouble(((JTextField) comp).getText());
                }
            }
            
            
            double luas = ((values[0] + values[1]) * values[2]) / 2; // (a + b) * t / 2
            double keliling = values[0] + values[1] + values[3] + values[4]; // a + b + sisi miring kiri + sisi miring kanan
            
            
            showResults(luas, keliling);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Mohon masukkan angka yang valid untuk semua field.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showResults(double luas, double keliling) {
        JDialog resultDialog = new JDialog(this, "Hasil Perhitungan " + bangunType, true);
        resultDialog.setSize(300, 200);
        resultDialog.setLocationRelativeTo(this);
        
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
        String luasStr = String.format("%.2f", luas);
        String kelilingStr = String.format("%.2f", keliling);
        
        JLabel luasLabel = new JLabel("Luas: " + luasStr + " satuan persegi");
        luasLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        luasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel kelilingLabel = new JLabel("Keliling: " + kelilingStr + " satuan");
        kelilingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        kelilingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton tutupButton = new JButton("Tutup");
        tutupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tutupButton.addActionListener(e -> resultDialog.dispose());
        
        resultPanel.add(luasLabel);
        resultPanel.add(Box.createVerticalStrut(10));
        resultPanel.add(kelilingLabel);
        resultPanel.add(Box.createVerticalStrut(20));
        resultPanel.add(tutupButton);
        
        resultDialog.add(resultPanel);
        resultDialog.setVisible(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Input().setVisible(true);
        });
    }
} 