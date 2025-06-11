package guigeometri;

import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import geometri.benda.geometri.jajargenjang.JajarGenjang;
import geometri.benda.geometri.layanglayang.LayangLayang;
import geometri.benda.geometri.lingkaran.JuringLingkaran;
import geometri.benda.geometri.lingkaran.Lingkaran;
import geometri.benda.geometri.lingkaran.TemberengLingkaran;
import geometri.benda.geometri.persegi.Persegi;
import geometri.benda.geometri.persegi.PersegiPanjang;
import geometri.benda.geometri.segitiga.Segitiga;
import geometri.benda.geometri.trapesium.Trapesium;
import guigeometri.Inputable;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input extends JFrame {
    private String bangunType;
    private JPanel inputPanel;
    private JPanel mainPanel;
    private BangunDatar bangunDatar;
    
    String[] bangun2D = {
        "Segitiga", "Persegi", "PersegiPanjang", "JajarGenjang", "Trapesium",
        "BelahKetupat", "LayangLayang", "Lingkaran", "Tembereng", "Juring"
    };
    
    String[] bangun3D = {
        "PrismaSegitiga", "LimasSegitiga", "PrismaPersegi", "LimasPersegi",
        "PrismaPersegiPanjang", "LimasPersegiPanjang", "PrismaJajaranGenjang", "LimasJajaranGenjang",
        "PrismaTrapesium", "LimasTrapesium", "Tabung", "Kerucut",
        "KerucutTerpancung", "Bola", "TemberengBola", "JuringBola", "CincinBola"
    };
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
        
        if (Arrays.asList(bangun2D).contains(this.bangunType) || Arrays.asList(bangun3D).contains(this.bangunType)) {
            createInputs();
        }
        else {
            JLabel label = new JLabel("Bentuk " + bangunType + " belum diimplementasikan");
            inputPanel.add(label);
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
    
    private void createInputs() {
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));
        
        switch (this.bangunType) {
            case "Segitiga":
                bangunDatar = new Segitiga(0, 0, 0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "Persegi":
                bangunDatar = new Persegi(0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "PersegiPanjang":
                bangunDatar = new PersegiPanjang(0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "JajarGenjang":
                bangunDatar = new JajarGenjang(0, 0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "Trapesium":
                bangunDatar = new Trapesium(0, 0, 0, 0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "BelahKetupat":
                bangunDatar = new BelahKetupat(0, 0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "LayangLayang":
                bangunDatar = new LayangLayang(0, 0, 0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "Lingkaran":
                bangunDatar = new Lingkaran(0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "Tembereng":
                bangunDatar = new TemberengLingkaran(0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            case "Juring":
                bangunDatar = new JuringLingkaran(0, 0);
                for (String input: bangunDatar.getInputs()) {
                    addInputField(input);
                }
                break;
            default:
                System.out.println("Error");
                
        }
    }
    
    private JTextField addInputField(String label) {
        inputPanel.add(new JLabel(label + ":"));
        JTextField field = new JTextField();
        inputPanel.add(field);
        return field;
    }
    
    private void hitungBangun() {
        if (Arrays.asList(bangun2D).contains(this.bangunType) || Arrays.asList(bangun3D).contains(this.bangunType)) {
            hitungInput();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Perhitungan untuk " + bangunType + " belum diimplementasikan",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void hitungInput() {
        Component[] components = inputPanel.getComponents();
        List<Double> inputs = new ArrayList<>();
        
        try {
            for (Component comp : components) {
                if (comp instanceof JTextField) {
                    inputs.add(Double.parseDouble(((JTextField) comp).getText()));
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Mohon masukkan angka yang valid untuk semua field.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
            
            
            
//        String[] bangun2D = {
//            "Segitiga", "Persegi", "PersegiPanjang", "JajarGenjang", "Trapesium",
//            "BelahKetupat", "LayangLayang", "Lingkaran", "Tembereng", "Juring"
//        };
            if (bangunDatar instanceof Segitiga segitiga) {
                segitiga.sisiSatu = inputs.get(0);
                segitiga.sisiDua = inputs.get(1);
                segitiga.sisiAlas = inputs.get(2);
                segitiga.tinggi = inputs.get(3);
                
                showResults(segitiga);
            }
            else if (bangunDatar instanceof Persegi persegi) {
                
                persegi.sisi = inputs.get(0);
                
                showResults(persegi);
            }
            else if (bangunDatar instanceof PersegiPanjang persegipanjang) {
                persegipanjang.sisiPendek = inputs.get(0);
                persegipanjang.sisiPanjang = inputs.get(1);
                
                showResults(persegipanjang);
            }
            else if (bangunDatar instanceof JajarGenjang jajargenjang) {
                jajargenjang.sisiDatar = inputs.get(0);
                jajargenjang.sisiMiring = inputs.get(1);
                jajargenjang.tinggi = inputs.get(2);

                showResults(jajargenjang);
            }
            else if (bangunDatar instanceof Trapesium trapesium) {
                trapesium.sisiAtas = inputs.get(0);
                trapesium.sisiAlas = inputs.get(1);
                trapesium.sisiMiringSatu = inputs.get(2);
                trapesium.sisiMiringDua = inputs.get(3);
                trapesium.tinggi = inputs.get(4);
                
                showResults(trapesium);
            }
            else if (bangunDatar instanceof BelahKetupat belahketupat) {
                belahketupat.sisi = inputs.get(0);
                belahketupat.diagonalSatu = inputs.get(1);
                belahketupat.diagonalDua = inputs.get(2);
                
                showResults(belahketupat);
            }
            else if (bangunDatar instanceof LayangLayang layanglayang) {
                layanglayang.diagonalSatu = inputs.get(0);
                layanglayang.diagonalDua = inputs.get(1);
                layanglayang.sisiPendek = inputs.get(2);
                layanglayang.sisiPanjang = inputs.get(3);
                
                showResults(layanglayang);
            }
            
            else if (bangunDatar instanceof TemberengLingkaran tembereng) {
                tembereng.jariJari = inputs.get(0);
                tembereng.sudutTheta = inputs.get(1);
                
                showResults(tembereng);
            }
            else if (bangunDatar instanceof JuringLingkaran juring) {
                juring.jariJari = inputs.get(0);
                juring.sudut = inputs.get(1);
                
                showResults(juring);
            }
            else if (bangunDatar instanceof Lingkaran lingkaran) {
                lingkaran.jariJari = inputs.get(0);
                
                showResults(lingkaran);
            }
    }
    
    private void showResults(BangunDatar bangunDatar) {
        bangunDatar.hitungLuas();
        bangunDatar.hitungKeliling();
//        
//        JDialog resultDialog = new JDialog(this, "Hasil Perhitungan " + bangunDatar.getNama(), true);
//        resultDialog.setSize(300, 200);
//        resultDialog.setLocationRelativeTo(this);
//        
//        JPanel resultPanel = new JPanel();
//        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
//        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        
//        
//        String luasStr = String.format("%.2f", bangunDatar.getLuas());
//        String kelilingStr = String.format("%.2f", bangunDatar.getKeliling());
//        
//        JLabel luasLabel = new JLabel("Luas: " + luasStr + " satuan persegi");
//        luasLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        luasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        
//        JLabel kelilingLabel = new JLabel("Keliling: " + kelilingStr + " satuan");
//        kelilingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        kelilingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        
//        JButton tutupButton = new JButton("Tutup");
//        tutupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tutupButton.addActionListener(e -> resultDialog.dispose());
//        
//        resultPanel.add(luasLabel);
//        resultPanel.add(Box.createVerticalStrut(10));
//        resultPanel.add(kelilingLabel);
//        resultPanel.add(Box.createVerticalStrut(20));
//        resultPanel.add(tutupButton);
//        
//        resultDialog.add(resultPanel);
//        resultDialog.setVisible(true);
        
         new Result(this, "Hasil Perhitungan " + bangunDatar.getNama(), bangunDatar).setVisible(true);
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