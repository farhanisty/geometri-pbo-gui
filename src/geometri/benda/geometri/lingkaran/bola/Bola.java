/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran.bola;

import geometri.benda.geometri.BangunRuang;
import geometri.benda.geometri.lingkaran.Lingkaran;
import geometri.benda.geometri.lingkaran.Tabung;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class Bola extends Lingkaran implements BangunRuang, Runnable {
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
        return super.hitungLuas(jariJari) * 4;
    }
    
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Jari Jari");
        return inputs;
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
