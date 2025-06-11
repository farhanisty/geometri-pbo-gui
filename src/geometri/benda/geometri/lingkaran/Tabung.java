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
public class Tabung extends Lingkaran implements BangunRuang{
    private double tinggiTabung;
    private double luasPermukaaan;
    private double volume;
    
    public Tabung(double tinggiTabung, double jariJari) {
        super(jariJari);
        this.tinggiTabung = tinggiTabung;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiTabung, jariJari);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiTabung, double jariJari) {
        return super.hitungLuas(jariJari) * tinggiTabung;
    }
    
    @Override
    public String getNama() {
        return "Tabung";
    }
    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Tinggi Tabung");
        inputs.add("Jari Jari");
        return inputs;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tabung.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }    

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaaan = this.hitungLuasPermukaan(tinggiTabung, jariJari);
        return this.luasPermukaaan;
    }
    
    public double hitungLuasPermukaan(double tinggiTabung, double jariJari) {
        return super.hitungLuas(jariJari) * 2 + super.hitungKeliling(jariJari) * tinggiTabung;
    }

    public double getTinggiTabung() {
        return tinggiTabung;
    }

    public void setTinggiTabung(double tinggiTabung) {
        this.tinggiTabung = tinggiTabung;
    }

    public double getLuasPermukaaan() {
        return luasPermukaaan;
    }

    public void setLuasPermukaaan(double luasPermukaaan) {
        this.luasPermukaaan = luasPermukaaan;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
