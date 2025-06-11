/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran;

import geometri.benda.geometri.BangunRuang;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import geometri.benda.geometri.lingkaran.Lingkaran;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class Kerucut extends Lingkaran implements BangunRuang{
    private double tinggiKerucut;
    private double luasPermukaan;
    private double volume;
    
    public Kerucut(double tinggiKerucut, double jariJari) {
        super(jariJari);
        this.tinggiKerucut = tinggiKerucut;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiKerucut, jariJari);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiKerucut, double jariJari) {
        return super.hitungLuas(jariJari) * tinggiKerucut;
    }
    
    @Override
    public String getNama() {
        return "Kerucut";
    }
    
    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Tinggi Kerucut");
        inputs.add("Jari Jari");
        return inputs;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Kerucut.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }    

    @Override
    public double hitungLuasPermukaan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getTinggiKerucut() {
        return tinggiKerucut;
    }

    public void setTinggiKerucut(double tinggiKerucut) {
        this.tinggiKerucut = tinggiKerucut;
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
