/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran;

import geometri.benda.geometri.BangunRuang;
import geometri.benda.geometri.lingkaran.Lingkaran;

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
    public double hitungLuasPermukaan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
