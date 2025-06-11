package geometri.benda.geometri.layanglayang;

import geometri.benda.geometri.BangunRuang;
import java.util.ArrayList;
import java.util.List;

public class LimasLayangLayang extends LayangLayang implements BangunRuang {
    private double tinggiLimas;
    private double tinggiSegitigaSisiPendek;
    private double tinggiSegitigaSisiPanjang;
    private double luasPermukaan;
    private double volume;

    public LimasLayangLayang(double tinggiLimas, double diagonalSatu, double diagonalDua,
                             double sisiPendek, double sisiPanjang,
                             double tinggiSegitigaSisiPendek, double tinggiSegitigaSisiPanjang) {
        super(diagonalSatu, diagonalDua, sisiPendek, sisiPanjang);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitigaSisiPendek = tinggiSegitigaSisiPendek;
        this.tinggiSegitigaSisiPanjang = tinggiSegitigaSisiPanjang;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiLimas, diagonalSatu, diagonalDua);
        return this.volume;
    }

    public double hitungVolume(double tinggiLimas, double diagonalSatu, double diagonalDua) {
        return super.hitungLuas(diagonalSatu, diagonalDua) * tinggiLimas / 3;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(diagonalSatu, diagonalDua, sisiPendek, sisiPanjang, tinggiSegitigaSisiPendek, tinggiSegitigaSisiPanjang);
        return this.luasPermukaan;
    }

    public double hitungLuasPermukaan(double diagonalSatu, double diagonalDua,
                             double sisiPendek, double sisiPanjang,
                             double tinggiSegitigaSisiPendek, double tinggiSegitigaSisiPanjang) {
        double luasAlas = super.hitungLuas(diagonalSatu, diagonalDua);
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
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Diagonal Satu");
        inputs.add("Diagonal Dua");
        inputs.add("Sisi Pendek");
        inputs.add("Sisi Panjang");
        return inputs;
    }
    
    @Override
    public String getNama() {
        return "Limas Layang Layang";
    }
}
