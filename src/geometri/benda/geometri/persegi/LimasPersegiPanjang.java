package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunRuang;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LimasPersegiPanjang extends PersegiPanjang implements BangunRuang {
    private double tinggiLimas;
    private double tinggiSegitigaSisiPendek;
    private double tinggiSegitigaSisiPanjang;
    private double luasPermukaan;
    private double volume;

    public LimasPersegiPanjang(double tinggiLimas, double sisiPendek, double sisiPanjang,
                               double tinggiSegitigaSisiPendek, double tinggiSegitigaSisiPanjang) {
        super(sisiPendek, sisiPanjang);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitigaSisiPendek = tinggiSegitigaSisiPendek;
        this.tinggiSegitigaSisiPanjang = tinggiSegitigaSisiPanjang;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiLimas, sisiPendek, sisiPanjang);
        return this.volume;
    }

    public double hitungVolume(double tinggiLimas, double sisiPendek, double sisiPanjang) {
        return super.hitungLuas(sisiPendek, sisiPanjang) * tinggiLimas / 3;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(sisiPendek, sisiPanjang, tinggiSegitigaSisiPendek, tinggiSegitigaSisiPanjang);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double sisiPendek, double sisiPanjang,
                               double tinggiSegitigaSisiPendek, double tinggiSegitigaSisiPanjang) {
        double luasAlas = super.hitungLuas(sisiPendek, sisiPanjang);
        double luasSisiPendek = 2 * (0.5 * sisiPendek * tinggiSegitigaSisiPendek);
        double luasSisiPanjang = 2 * (0.5 * sisiPanjang * tinggiSegitigaSisiPanjang);
        return luasAlas + luasSisiPendek + luasSisiPanjang;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiSegitigaSisiPendek() {
        return tinggiSegitigaSisiPendek;
    }

    public void setTinggiSegitigaSisiPendek(double tinggiSegitigaSisiPendek) {
        this.tinggiSegitigaSisiPendek = tinggiSegitigaSisiPendek;
    }

    public double getTinggiSegitigaSisiPanjang() {
        return tinggiSegitigaSisiPanjang;
    }

    public void setTinggiSegitigaSisiPanjang(double tinggiSegitigaSisiPanjang) {
        this.tinggiSegitigaSisiPanjang = tinggiSegitigaSisiPanjang;
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
            Logger.getLogger(LimasPersegiPanjang.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Tinggi Limas");
        inputs.add("Sisi Pendek");
        inputs.add("Sisi Panjang");
        inputs.add("Tinggi Segitiga Pendek");
        inputs.add("Tinggi Segitiga Panjang");
        return inputs;
    }

    @Override
    public String getNama() {
        return "Limas Persegi Panjang";
    }
}
