package geometri.benda.geometri.belahketupat;

import geometri.benda.geometri.BangunRuang;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LimasBelahKetupat extends BelahKetupat implements BangunRuang, Runnable {
    private double tinggiLimas;
    private double tinggiSegitigaSisi;
    private double luasPermukaan;
    private double volume;

    public LimasBelahKetupat(double tinggiLimas, double sisi, double diagonalSatu, double diagonalDua, double tinggiSegitigaSisi) {
        super(sisi, diagonalSatu, diagonalDua);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitigaSisi = tinggiSegitigaSisi;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiLimas, diagonalSatu, diagonalDua);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiLimas, double diagonalSatu, double diagonalDua) {
        double luasAlas = super.hitungLuas(diagonalSatu, diagonalDua);
        return luasAlas * tinggiLimas / 3;
    }
    
    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(sisi, diagonalSatu, diagonalDua, tinggiSegitigaSisi);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double sisi, double diagonalSatu, double diagonalDua, double tinggiSegitigaSisi) {
        double luasAlas = super.hitungLuas(diagonalSatu, diagonalDua);
        double luasSisiSamping = 4 * (0.5 *  sisi * tinggiSegitigaSisi);
        return luasAlas + luasSisiSamping;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiSegitigaSisi() {
        return tinggiSegitigaSisi;
    }

    public void setTinggiSegitigaSisi(double tinggiSegitigaSisi) {
        this.tinggiSegitigaSisi = tinggiSegitigaSisi;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void setLuasPermukaan(double luasPermukaan) {
        this.luasPermukaan = luasPermukaan;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LimasBelahKetupat.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Tinggi Limas");
        inputs.add("Sisi");
        inputs.add("Diagonal Satu");
        inputs.add("Diagonal Dua");
        inputs.add("Tinggi Segitiga Sisi");
        return inputs;
    }
    
    @Override
    public String getNama() {
        return "Limas Belah Ketupat";
    }

}
