/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran.bola;

import geometri.benda.geometri.lingkaran.Lingkaran;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class JuringBola extends Bola implements Runnable {
    private double alpha;
    private double volume;
    private double luasPermukaan;
    
    public JuringBola(double alphaDerajat, double jariJari) {
        super(jariJari);
        
        this.alpha = Math.toRadians(alphaDerajat);
    }
    
    @Override
     public double hitungVolume() {
        this.volume = this.hitungVolume(jariJari, alpha);
        return this.volume;
    }
     
     public double hitungVolume(double jariJari, double alpha) {
//        return (2 * Math.PI * Math.pow(jariJari, 3) / 3) * (1 - Math.cos(Math.toRadians(alpha)));
          return ((alpha / 360) * super.hitungVolume(jariJari)); 
    }
     
    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(jariJari, alpha);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double jariJari, double alpha) {
//        return this.hitungLuasPermukaanMelengkung(jariJari, alpha) + this.hitungLuasBidangSegitigaKerucut(jariJari, alpha);
        return (alpha * 4 / 360 + 1)* super.hitungLuas(jariJari);
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JuringBola.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    } 
    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Sudut (Derajat)");
        inputs.add("Jari Jari");
        return inputs;
    }
    
    @Override
    public String getNama() {
        return "Juring Bola";
    }

    public double hitungLuasPermukaanMelengkung() {
        return this.hitungLuasPermukaanMelengkung(jariJari, alpha);
    }
    
    public double hitungLuasPermukaanMelengkung(double jariJari, double alpha) {
        return 2 * Lingkaran.PI * jariJari * jariJari * (1 - Math.cos(alpha));
    }

    public double hitungLuasBidangSegitigaKerucut() {
        return this.hitungLuasBidangSegitigaKerucut(jariJari, alpha);
    }
    
    public double hitungLuasBidangSegitigaKerucut(double jariJari, double alpha) {
        return 2 * jariJari * jariJari * alpha;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    @Override
    public void setLuasPermukaan(double luasPermukaan) {
        this.luasPermukaan = luasPermukaan;
    }
}
