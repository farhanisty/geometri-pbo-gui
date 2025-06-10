/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran;

import geometri.benda.geometri.BangunRuang;

/**
 *
 * @author farhannivta
 */
public class KerucutTerpancung extends Lingkaran implements BangunRuang {
    private double jariJariKecil;
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public KerucutTerpancung(double tinggi, double jariJariKecil, double jariJariBesar) {
        super(jariJariBesar);
        this.jariJariKecil = jariJariKecil;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggi, jariJari, jariJariKecil, jariJariKecil);
        return this.volume;
    }
    
    public double hitungVolume(double tinggi, double jariJari, double jariJariKecil, double jariJariBesar) {
        return (1.0 / 3) * Lingkaran.PI * tinggi * (jariJari * jariJari + jariJari * jariJariKecil + jariJariKecil * jariJariKecil);
    }
    
    public double hitungSisiMiring() {
        return Math.sqrt(Math.pow(this.jariJari - this.jariJariKecil, 2) + Math.pow(tinggi, 2));
    }
    
    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(jariJari, jariJariKecil);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double jariJari, double jariJariKecil) {
        double s = hitungSisiMiring();
        double luasSelimut = Math.PI * (jariJari + jariJariKecil) * s;
        double luasAlasBesar = Math.PI * jariJari * jariJari;
        double luasAlasKecil = Math.PI * jariJariKecil * jariJariKecil;
        return luasSelimut + luasAlasBesar + luasAlasKecil;
    }
    
    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }
}
