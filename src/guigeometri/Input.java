package guigeometri;

import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import geometri.benda.geometri.jajargenjang.JajarGenjang;
import geometri.benda.geometri.jajargenjang.LimasJajarGenjang;
import geometri.benda.geometri.jajargenjang.PrismaJajarGenjang;
import geometri.benda.geometri.layanglayang.LayangLayang;
import geometri.benda.geometri.lingkaran.JuringLingkaran;
import geometri.benda.geometri.lingkaran.Kerucut;
import geometri.benda.geometri.lingkaran.KerucutTerpancung;
import geometri.benda.geometri.lingkaran.Lingkaran;
import geometri.benda.geometri.lingkaran.Tabung;
import geometri.benda.geometri.lingkaran.TemberengLingkaran;
import geometri.benda.geometri.lingkaran.bola.Bola;
import geometri.benda.geometri.lingkaran.bola.CincinBola;
import geometri.benda.geometri.lingkaran.bola.JuringBola;
import geometri.benda.geometri.lingkaran.bola.TemberengBola;
import geometri.benda.geometri.persegi.LimasPersegi;
import geometri.benda.geometri.persegi.LimasPersegiPanjang;
import geometri.benda.geometri.persegi.Persegi;
import geometri.benda.geometri.persegi.PersegiPanjang;
import geometri.benda.geometri.persegi.PrismaPersegi;
import geometri.benda.geometri.persegi.PrismaPersegiPanjang;
import geometri.benda.geometri.segitiga.LimasSegitiga;
import geometri.benda.geometri.segitiga.PrismaSegitiga;
import geometri.benda.geometri.segitiga.Segitiga;
import geometri.benda.geometri.trapesium.LimasTrapesium;
import geometri.benda.geometri.trapesium.PrismaTrapesium;
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
                break;
            case "Persegi":
                bangunDatar = new Persegi(0);
                break;
            case "PersegiPanjang":
                bangunDatar = new PersegiPanjang(0, 0);
                break;
            case "JajarGenjang":
                bangunDatar = new JajarGenjang(0, 0, 0);
                break;
            case "Trapesium":
                bangunDatar = new Trapesium(0, 0, 0, 0, 0);
                break;
            case "BelahKetupat":
                bangunDatar = new BelahKetupat(0, 0, 0);
                break;
            case "LayangLayang":
                bangunDatar = new LayangLayang(0, 0, 0, 0);
                break;
            case "Lingkaran":
                bangunDatar = new Lingkaran(0);
                break;
            case "Tembereng":
                bangunDatar = new TemberengLingkaran(0, 0);
                break;
            case "Juring":
                bangunDatar = new JuringLingkaran(0, 0);
                break;
            case "PrismaSegitiga":
                bangunDatar = new PrismaSegitiga(0,0,0,0,0);
                break;
            case "LimasSegitiga":
                bangunDatar = new LimasSegitiga(0,0,0,0,0,0,0,0);
                break;
            case "PrismaPersegi":
                bangunDatar = new PrismaPersegi(0);
                break;
            case "LimasPersegi":
                bangunDatar = new LimasPersegi(0,0,0);
                break;
            case "PrismaPersegiPanjang":
                bangunDatar = new PrismaPersegiPanjang(0,0,0);
                break;
            case "LimasPersegiPanjang":
                bangunDatar = new LimasPersegiPanjang(0,0,0,0,0);
                break;
            case "PrisamJajaranGenjang":
                bangunDatar = new PrismaJajarGenjang(0,0,0,0);
                break;
            case "LimasJajaranGenjang":
                bangunDatar = new LimasJajarGenjang(0,0,0,0,0,0);
                break;
            case "PrismaTrapesium":
                bangunDatar = new PrismaTrapesium(0,0,0,0,0,0);
                break;
            case "LimasTrapesium":
                bangunDatar = new LimasTrapesium(0,0,0,0,0,0,0,0,0,0);
                break;
            case "Tabung":
                bangunDatar = new Tabung(0,0);
                break;
            case "Kerucut":
                bangunDatar = new Kerucut(0,0);
                break;
            case "KerucutTerpancung":
                bangunDatar = new KerucutTerpancung(0,0,0);
                break;
            case "Bola":
                bangunDatar = new Bola(0);
                break;
            case "TemberengBola":
                bangunDatar = new TemberengBola(0,0);
                break;
            case "JuringBola":
                bangunDatar = new JuringBola(0,0);
                break;
            case "CincinBola":
                bangunDatar = new CincinBola(0,0,0);
                break;
            default:
                bangunDatar = new Bola(12);
                
        }
        
        for (String input: bangunDatar.getInputs()) {
            addInputField(input);
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
                    String rawInput = ((JTextField) comp).getText();
                    Double santizedInput = this.validateInput(rawInput);
                    
                    inputs.add(santizedInput);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Mohon masukkan angka yang valid untuk semua field.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IllegalArgumentException ex) {
            this.showMessage("Angka tidak boleh negatif", "Error",  JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (bangunDatar instanceof Segitiga segitiga) {
            segitiga.sisiSatu = inputs.get(0);
            segitiga.sisiDua = inputs.get(1);
            segitiga.sisiAlas = inputs.get(2);
            segitiga.tinggi = inputs.get(3);
        }
        else if (bangunDatar instanceof Persegi persegi) {

            persegi.sisi = inputs.get(0);
        }
        else if (bangunDatar instanceof PersegiPanjang persegipanjang) {
            persegipanjang.sisiPendek = inputs.get(0);
            persegipanjang.sisiPanjang = inputs.get(1);
        }
        else if (bangunDatar instanceof JajarGenjang jajargenjang) {
            jajargenjang.sisiDatar = inputs.get(0);
            jajargenjang.sisiMiring = inputs.get(1);
            jajargenjang.tinggi = inputs.get(2);
        }
        else if (bangunDatar instanceof Trapesium trapesium) {
            trapesium.sisiAtas = inputs.get(0);
            trapesium.sisiAlas = inputs.get(1);
            trapesium.sisiMiringSatu = inputs.get(2);
            trapesium.sisiMiringDua = inputs.get(3);
            trapesium.tinggi = inputs.get(4);
        }
        else if (bangunDatar instanceof BelahKetupat belahketupat) {
            belahketupat.sisi = inputs.get(0);
            belahketupat.diagonalSatu = inputs.get(1);
            belahketupat.diagonalDua = inputs.get(2);
        }
        else if (bangunDatar instanceof LayangLayang layanglayang) {
            layanglayang.diagonalSatu = inputs.get(0);
            layanglayang.diagonalDua = inputs.get(1);
            layanglayang.sisiPendek = inputs.get(2);
            layanglayang.sisiPanjang = inputs.get(3);
        }

        else if (bangunDatar instanceof TemberengLingkaran tembereng) {
            tembereng.jariJari = inputs.get(0);
            tembereng.sudutTheta = inputs.get(1);
        }
        else if (bangunDatar instanceof JuringLingkaran juring) {
            juring.jariJari = inputs.get(0);
            juring.sudut = inputs.get(1);
        }
        else if (bangunDatar instanceof Lingkaran lingkaran) {
            lingkaran.jariJari = inputs.get(0);
        } else if (bangunDatar instanceof PrismaSegitiga prismaSegitiga) {
            prismaSegitiga.setTinggiPrisma(inputs.get(0));
            prismaSegitiga.sisiSatu = inputs.get(1);
            prismaSegitiga.sisiDua = inputs.get(2);
            prismaSegitiga.sisiAlas = inputs.get(3);
            prismaSegitiga.tinggi = inputs.get(4);
        } else if(bangunDatar instanceof LimasSegitiga limasSegitiga) {
            limasSegitiga.setTinggiLimas(inputs.get(0));
            limasSegitiga.sisiSatu = inputs.get(1);
            limasSegitiga.sisiDua = inputs.get(2);
            limasSegitiga.sisiAlas = inputs.get(3);
            limasSegitiga.tinggi = inputs.get(4);
            limasSegitiga.setTinggiSegitigaSisiSatu(inputs.get(5));
            limasSegitiga.setTinggiSegitigaSisiDua(inputs.get(6));
            limasSegitiga.setTinggiSegitigaSisiAlas(inputs.get(7));
        } else if(bangunDatar instanceof PrismaPersegi prismaPersegi) {
            prismaPersegi.sisi = inputs.get(0);
        } else if(bangunDatar instanceof LimasPersegi limasPersegi) {
            limasPersegi.setTinggiLimas(inputs.get(0));
            limasPersegi.sisi = inputs.get(1);
            limasPersegi.setTinggiSegitiga(inputs.get(2));
        } else if(bangunDatar instanceof PrismaPersegiPanjang prismaPersegiPanjang) {
            prismaPersegiPanjang.setTinggiPrisma(inputs.get(0));
            prismaPersegiPanjang.sisiPendek = inputs.get(1);
            prismaPersegiPanjang.sisiPanjang = inputs.get(2);
        } else if(bangunDatar instanceof LimasPersegiPanjang limasPersegiPanjang) {
            limasPersegiPanjang.setTinggiLimas(inputs.get(0));
            limasPersegiPanjang.sisiPendek = inputs.get(1);
            limasPersegiPanjang.sisiPanjang = inputs.get(2);
            limasPersegiPanjang.setTinggiSegitigaSisiPendek(inputs.get(3));
            limasPersegiPanjang.setTinggiSegitigaSisiPanjang(inputs.get(4));
        } else if(bangunDatar instanceof PrismaJajarGenjang prismaJajarGenjang) {
            prismaJajarGenjang.setTinggiPrisma(inputs.get(0));
            prismaJajarGenjang.sisiDatar = inputs.get(1);
            prismaJajarGenjang.sisiMiring = inputs.get(2);
            prismaJajarGenjang.tinggi = inputs.get(3);
        } else if(bangunDatar instanceof LimasJajarGenjang limasJajarGenjang) {
            limasJajarGenjang.setTinggiLimas(inputs.get(0));
            limasJajarGenjang.sisiDatar = inputs.get(1);
            limasJajarGenjang.sisiMiring = inputs.get(2);
            limasJajarGenjang.tinggi = inputs.get(3);
            limasJajarGenjang.setTinggiSegitigaSisiDatar(inputs.get(4));
            limasJajarGenjang.setTinggiSegitigaSisiMiring(inputs.get(5));
        } else if(bangunDatar instanceof PrismaTrapesium prismaTrapesium) {
            prismaTrapesium.setTinggiPrisma(inputs.get(0));
            prismaTrapesium.sisiAtas = inputs.get(1);
            prismaTrapesium.sisiAlas = inputs.get(2);
            prismaTrapesium.sisiMiringSatu = inputs.get(3);
            prismaTrapesium.sisiMiringDua = inputs.get(4);
            prismaTrapesium.tinggi = inputs.get(5);
        } else if(bangunDatar instanceof LimasTrapesium limasTrapesium) {
            limasTrapesium.setTinggiLimas(inputs.get(0));
            limasTrapesium.sisiAtas = inputs.get(1);
            limasTrapesium.sisiAlas = inputs.get(2);
            limasTrapesium.sisiMiringSatu = inputs.get(3);
            limasTrapesium.sisiMiringDua = inputs.get(4);
            limasTrapesium.tinggi = inputs.get(5);
            limasTrapesium.setTinggiSegitigaSisiAtas(inputs.get(6));
            limasTrapesium.setTinggiSegitigaSisiAlas(inputs.get(7));
            limasTrapesium.setTinggiSegitigaSisiMiringSatu(inputs.get(8));
            limasTrapesium.setTinggiSegitigaSisiMiringDua(inputs.get(9));
        } else if(bangunDatar instanceof Tabung tabung) {
            tabung.setTinggiTabung(inputs.get(0));
            tabung.jariJari = inputs.get(1);
        } else if(bangunDatar instanceof Kerucut kerucut) {
            kerucut.setTinggiKerucut(inputs.get(0));
            kerucut.jariJari = inputs.get(1);
        } else if(bangunDatar instanceof KerucutTerpancung kerucutTerpancung) {
            kerucutTerpancung.setTinggi(inputs.get(0));
            kerucutTerpancung.setJariJariKecil(inputs.get(1));
            kerucutTerpancung.jariJari = inputs.get(2);
        } else if(bangunDatar instanceof Bola bola) {
            bola.jariJari = inputs.get(0);
        } else if(bangunDatar instanceof TemberengBola temberengBola) {
            temberengBola.setTinggi(inputs.get(0));
            temberengBola.jariJari = inputs.get(1);
        } else if(bangunDatar instanceof JuringBola juringBola) {
            juringBola.setAlpha(inputs.get(0));
            juringBola.jariJari = inputs.get(1);
        } else if(bangunDatar instanceof CincinBola cincinBola) {
            cincinBola.setH1(inputs.get(0));
            cincinBola.setH2(inputs.get(1));
            cincinBola.jariJari = inputs.get(2);
        }
        
        showResults(bangunDatar);
    }
    
    private double validateInput(String input) throws IllegalArgumentException, NumberFormatException {
        Double rawInput = Double.valueOf(input);
        
        if(rawInput < 0) {
            throw new IllegalArgumentException("Input must be positive number");
        }
        
        return rawInput;
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
    
    public void showMessage(String message, String title, int option) {
        JOptionPane.showMessageDialog(this, message, title, option);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Input().setVisible(true);
        });
    }
} 