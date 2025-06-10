package geometri.benda.geometri.trapesium;

import geometri.benda.geometri.BangunRuang;

public class LimasTrapesium extends Trapesium implements BangunRuang {
    private double tinggiLimas;
    private double tinggiSegitigaSisiAtas;
    private double tinggiSegitigaSisiAlas;
    private double tinggiSegitigaSisiMiringSatu;
    private double tinggiSegitigaSisiMiringDua;
    private double luasPermukaan;
    private double volume;

    public LimasTrapesium(double tinggiLimas, double sisiAtas, double sisiAlas,
                          double sisiMiringSatu, double sisiMiringDua, double tinggi,
                          double tinggiSegitigaSisiAtas, double tinggiSegitigaSisiAlas,
                          double tinggiSegitigaSisiMiringSatu, double tinggiSegitigaSisiMiringDua) {
        super(sisiAtas, sisiAlas, sisiMiringSatu, sisiMiringDua, tinggi);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitigaSisiAtas = tinggiSegitigaSisiAtas;
        this.tinggiSegitigaSisiAlas = tinggiSegitigaSisiAlas;
        this.tinggiSegitigaSisiMiringSatu = tinggiSegitigaSisiMiringSatu;
        this.tinggiSegitigaSisiMiringDua = tinggiSegitigaSisiMiringDua;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiLimas, sisiAtas, sisiAlas);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiLimas, double sisiAtas, double sisiAlas) {
        return super.hitungLuas(sisiAlas, sisiAtas, tinggi) * tinggiLimas / 3;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(sisiAtas, sisiAlas, sisiMiringSatu, sisiMiringDua, tinggi, tinggiSegitigaSisiAtas, tinggiSegitigaSisiAlas, tinggiSegitigaSisiMiringSatu, tinggiSegitigaSisiMiringDua);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double sisiAtas, double sisiAlas,
                          double sisiMiringSatu, double sisiMiringDua, double tinggi,
                          double tinggiSegitigaSisiAtas, double tinggiSegitigaSisiAlas,
                          double tinggiSegitigaSisiMiringSatu, double tinggiSegitigaSisiMiringDua) {
        double luasAlas = super.hitungLuas(sisiAlas, sisiAtas, tinggi);
        double luasSisiAtas = 0.5 * sisiAtas * tinggiSegitigaSisiAtas;
        double luasSisiAlas = 0.5 * sisiAlas * tinggiSegitigaSisiAlas;
        double luasSisiMiringSatu = 0.5 * sisiMiringSatu * tinggiSegitigaSisiMiringSatu;
        double luasSisiMiringDua = 0.5 * sisiMiringDua * tinggiSegitigaSisiMiringDua;
        return luasAlas + luasSisiAtas + luasSisiAlas + luasSisiMiringSatu + luasSisiMiringDua;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiSegitigaSisiAtas() {
        return tinggiSegitigaSisiAtas;
    }

    public void setTinggiSegitigaSisiAtas(double tinggiSegitigaSisiAtas) {
        this.tinggiSegitigaSisiAtas = tinggiSegitigaSisiAtas;
    }

    public double getTinggiSegitigaSisiAlas() {
        return tinggiSegitigaSisiAlas;
    }

    public void setTinggiSegitigaSisiAlas(double tinggiSegitigaSisiAlas) {
        this.tinggiSegitigaSisiAlas = tinggiSegitigaSisiAlas;
    }

    public double getTinggiSegitigaSisiMiringSatu() {
        return tinggiSegitigaSisiMiringSatu;
    }

    public void setTinggiSegitigaSisiMiringSatu(double tinggiSegitigaSisiMiringSatu) {
        this.tinggiSegitigaSisiMiringSatu = tinggiSegitigaSisiMiringSatu;
    }

    public double getTinggiSegitigaSisiMiringDua() {
        return tinggiSegitigaSisiMiringDua;
    }

    public void setTinggiSegitigaSisiMiringDua(double tinggiSegitigaSisiMiringDua) {
        this.tinggiSegitigaSisiMiringDua = tinggiSegitigaSisiMiringDua;
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
        return "Limas Trapesium";
    }
}
