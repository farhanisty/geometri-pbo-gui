/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran.bola;

import geometri.benda.geometri.BangunRuang;
import geometri.benda.geometri.lingkaran.Lingkaran;

/**
 *
 * @author farhannivta
 */
public class Bola extends Lingkaran implements BangunRuang {
    private double volume;
    private double luasPermukaan;
    
    public Bola(double jariJari) {
        super(jariJari);
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(jariJari);
        return this.volume;
    }
    
    public double hitungVolume(double jariJari) {
        return Math.pow(jariJari, 3) * Lingkaran.PI * 4 / 3;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(jariJari);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double jariJari) {
        return Math.pow(jariJari, 2) * Lingkaran.PI * 4;
    }
    
    @Override
    public String getNama() {
        return "Bola";
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void setLuasPermukaan(double luasPermukaan) {
        this.luasPermukaan = luasPermukaan;
    }
    
    
}
