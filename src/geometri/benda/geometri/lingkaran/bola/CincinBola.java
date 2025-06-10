/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran.bola;

import geometri.benda.geometri.BangunRuang;

/**
 *
 * @author farhannivta
 */
public class CincinBola extends Bola {
    private double h1;   // jarak bidang potong bawah dari pusat bola
    private double h2;   // jarak bidang potong atas dari pusat bola
    private double luasPermukaan;
    private double volume;

    public CincinBola(double h1, double h2, double jariJari) {
        super(jariJari);
        this.h1 = h1;
        this.h2 = h2;
    }
    
    @Override
    public double hitungLuas() {
        double h = hitungTinggi();
        return 2 * Math.PI * this.jariJari * h;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(jariJari, h1, h2);
        return this.volume;
    }
    
    public double hitungVolume(double jariJari, double h1, double h2) {
        double a = this.hitungJariJariAlasBawah(jariJari, h1);
        double b = this.hitungJariJariAlasAtas(jariJari, h2);
        double h = this.hitungTinggi(h1, h2);
        return (Math.PI * h * h / 6) * (3 * a + 3 * b + h);
    }
    
    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(jariJari, h1, h2);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double jariJari, double h1, double h2) {
        double h = this.hitungTinggi(h1, h2);
        return 2 * Math.PI * jariJari * h;
    }
    
    @Override
    public String getNama() {
        return "Cincin Bola";
    }

    public double hitungJariJariAlasBawah() {
        return this.hitungJariJariAlasBawah(jariJari, h1);
    }
    
    public double hitungJariJariAlasBawah(double jariJari, double h1) {
        return Math.sqrt(jariJari * jariJari - h1 * h1);
    }

    public double hitungJariJariAlasAtas() {
        return this.hitungJariJariAlasAtas(jariJari, h2);
    }
    
    public double hitungJariJariAlasAtas(double jariJari, double h2) {
        return Math.sqrt(jariJari * jariJari - h2 * h2);
    }

    public double hitungTinggi() {
        return this.hitungTinggi(h1, h2);
    }
    
    public double hitungTinggi(double h1, double h2) {
        return Math.abs(h1 - h2);
    }

    public double getH1() {
        return h1;
    }

    public void setH1(double h1) {
        this.h1 = h1;
    }

    public double getH2() {
        return h2;
    }

    public void setH2(double h2) {
        this.h2 = h2;
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
