package geometri.benda.geometri.segitiga;

import geometri.benda.geometri.BangunRuang;


public class LimasSegitiga extends Segitiga implements BangunRuang {
    private double tinggiLimas;
    private double tinggiSegitigaSisiSatu;
    private double tinggiSegitigaSisiDua;
    private double tinggiSegitigaSisiAlas;
    private double luasPermukaan;
    private double volume;

    public LimasSegitiga(double tinggiLimas, double sisiSatu, double sisiDua, double sisiAlas, double tinggi,
                         double tinggiSegitigaSisiSatu, double tinggiSegitigaSisiDua, double tinggiSegitigaSisiAlas) {
        super(sisiSatu, sisiDua, sisiAlas, tinggi);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitigaSisiSatu = tinggiSegitigaSisiSatu;
        this.tinggiSegitigaSisiDua = tinggiSegitigaSisiDua;
        this.tinggiSegitigaSisiAlas = tinggiSegitigaSisiAlas;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiLimas, sisiAlas, tinggi);
        return this.volume;
    }
    
     public double hitungVolume(double tinggiLimas, double sisiAlas, double tinggi) {
        return super.hitungLuas(sisiAlas, tinggi) * tinggiLimas / 3;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(sisiSatu, sisiDua, sisiAlas, tinggi, tinggiSegitigaSisiSatu, tinggiSegitigaSisiDua, tinggiSegitigaSisiAlas);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double sisiSatu, double sisiDua, double sisiAlas, double tinggi,
                         double tinggiSegitigaSisiSatu, double tinggiSegitigaSisiDua, double tinggiSegitigaSisiAlas) {
        double luasAlas = super.hitungLuas(sisiAlas, tinggi);
        double luasSisiSatu = 0.5 * sisiSatu * tinggiSegitigaSisiSatu;
        double luasSisiDua = 0.5 * sisiDua * tinggiSegitigaSisiDua;
        double luasSisiAlas = 0.5 * sisiAlas * tinggiSegitigaSisiAlas;
        return luasAlas + luasSisiSatu + luasSisiDua + luasSisiAlas;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiSegitigaSisiSatu() {
        return tinggiSegitigaSisiSatu;
    }

    public void setTinggiSegitigaSisiSatu(double tinggiSegitigaSisiSatu) {
        this.tinggiSegitigaSisiSatu = tinggiSegitigaSisiSatu;
    }

    public double getTinggiSegitigaSisiDua() {
        return tinggiSegitigaSisiDua;
    }

    public void setTinggiSegitigaSisiDua(double tinggiSegitigaSisiDua) {
        this.tinggiSegitigaSisiDua = tinggiSegitigaSisiDua;
    }

    public double getTinggiSegitigaSisiAlas() {
        return tinggiSegitigaSisiAlas;
    }

    public void setTinggiSegitigaSisiAlas(double tinggiSegitigaSisiAlas) {
        this.tinggiSegitigaSisiAlas = tinggiSegitigaSisiAlas;
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
        return "Limas Segitiga";
    }
}
