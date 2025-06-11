/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran;

import geometri.benda.geometri.BangunRuang;
import java.util.ArrayList;
import java.util.List;

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
        this.tinggi = tinggi;
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
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Tinggi");
        inputs.add("Jari Jari Kecil");
        inputs.add("Jari Jari Besar");
        return inputs;
    }
    
    @Override
    public void run() {
        this.hitungLuasPermukaan();
        this.hitungVolume();
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

    public double getJariJariKecil() {
        return jariJariKecil;
    }

    public void setJariJariKecil(double jariJariKecil) {
        this.jariJariKecil = jariJariKecil;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    
    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }
}
