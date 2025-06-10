/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran.bola;

/**
 *
 * @author farhannivta
 */
public class TemberengBola extends Bola {
    private double tinggi;
    private double luasPermukaan;
    private double volume;
    
    public TemberengBola(double tinggi, double jariJari) {
        super(jariJari);
        this.tinggi = tinggi;
    }
    
    public double hitungLuasPermukaanMelengkung() {
        return this.hitungLuasPermukaanMelengkung(tinggi, jariJari);
    }
    
    public double hitungLuasPermukaanMelengkung(double tinggi, double jariJari) {
        return 2 * Math.PI * jariJari * tinggi;
    }

    public double hitungLuasBidangPotong() {
        double a = Math.sqrt(2 * this.jariJari * this.tinggi - this.tinggi * this.tinggi);
        return Math.PI * a * a;
    }
    
    public double hitungLuasBidangPotong(double tinggi, double jariJari) {
        double a = Math.sqrt(2 * jariJari * tinggi - tinggi * tinggi);
        return Math.PI * a * a;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggi, jariJari);
        return this.volume;
    }
    
    public double hitungVolume(double tinggi, double jariJari) {
        return (Math.PI * tinggi * tinggi / 3) * (3 * jariJari - tinggi);
    }
    
    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggi, jariJari);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggi, double jariJari) {
        return this.hitungLuasPermukaanMelengkung(tinggi, jariJari) + this.hitungLuasBidangPotong(tinggi, jariJari);
    }
    
    @Override
    public String getNama() {
        return "Tembereng Bola";
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
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
}
