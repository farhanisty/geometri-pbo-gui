package geometri.benda.geometri.jajargenjang;

import geometri.benda.geometri.BangunRuang;

public class LimasJajarGenjang extends JajarGenjang implements BangunRuang {
    private double tinggiLimas;
    private double tinggiSegitigaSisiDatar;
    private double tinggiSegitigaSisiMiring;
    private double luasPermukaan;
    private double volume;

    public LimasJajarGenjang(double tinggiLimas, double sisiDatar, double sisiMiring, double tinggi,
                             double tinggiSegitigaSisiDatar, double tinggiSegitigaSisiMiring) {
        super(sisiDatar, sisiMiring, tinggi);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitigaSisiDatar = tinggiSegitigaSisiDatar;
        this.tinggiSegitigaSisiMiring = tinggiSegitigaSisiMiring;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiLimas, sisiDatar, tinggi);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiLimas, double sisiDatar, double tinggi) {
        return super.hitungLuas(sisiDatar, tinggi) * tinggiLimas / 3;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(sisiDatar, sisiMiring, tinggi, tinggiSegitigaSisiDatar, tinggiSegitigaSisiMiring);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double sisiDatar, double sisiMiring, double tinggi, double tinggiSegitigaSisiDatar, double tinggiSegitigaSisiMiring) {
        double luasAlas = super.hitungLuas(sisiDatar, tinggi);
        double luasSisiDatar = 2 * (0.5 * sisiDatar * tinggiSegitigaSisiDatar);
        double luasSisiMiring = 2 * (0.5 * sisiMiring * tinggiSegitigaSisiMiring);
        
        return luasAlas + luasSisiDatar + luasSisiMiring;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiSegitigaSisiDatar() {
        return tinggiSegitigaSisiDatar;
    }

    public void setTinggiSegitigaSisiDatar(double tinggiSegitigaSisiDatar) {
        this.tinggiSegitigaSisiDatar = tinggiSegitigaSisiDatar;
    }

    public double getTinggiSegitigaSisiMiring() {
        return tinggiSegitigaSisiMiring;
    }

    public void setTinggiSegitigaSisiMiring(double tinggiSegitigaSisiMiring) {
        this.tinggiSegitigaSisiMiring = tinggiSegitigaSisiMiring;
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
        return "Limas Jajar Genjang";
    }
}