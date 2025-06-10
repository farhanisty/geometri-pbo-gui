package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunRuang;

public class LimasPersegi extends Persegi implements BangunRuang {
    private double tinggiLimas;
    private double tinggiSegitiga;
    private double luasPermukaan;
    private double volume;

    public LimasPersegi(double tinggiLimas, double sisi, double tinggiSegitiga) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitiga = tinggiSegitiga;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiLimas, sisi);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiLimas, double sisi) {
        return super.hitungLuas(sisi) * tinggiLimas / 3;
    }

    @Override
     public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(sisi, tinggiSegitiga);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double sisi, double tinggiSegitiga) {
        double luasAlas = super.hitungLuas(sisi);
        double luasSisi = 4 * (0.5 * sisi * tinggiSegitiga);
        return luasAlas + luasSisi;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiSegitiga() {
        return tinggiSegitiga;
    }

    public void setTinggiSegitiga(double tinggiSegitiga) {
        this.tinggiSegitiga = tinggiSegitiga;
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
    public String getNama() {
        return "Limas Persegi";
    }
}
