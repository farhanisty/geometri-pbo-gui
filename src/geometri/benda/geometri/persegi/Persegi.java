/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import guigeometri.Inputable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class Persegi extends BangunDatar {
    public double luas;
    public double keliling;
    public double sisi;
    
    public Persegi(double sisi) {
        this.sisi = sisi;
    }
    
    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(sisi);
        return this.luas;
    }
    
    public double hitungLuas(double sisi) {
        return sisi * sisi;
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(sisi);
        return this.keliling;
    }
    
    public double hitungKeliling(double sisi) {
        return sisi * 4;
    }

    @Override
    public String getNama() {
        return "Persegi";
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("sisi");
        return inputs;
    }
    
    @Override
    public double getLuas() {
        return luas;
    }

    @Override
    public double getKeliling() {
        return keliling;
    }
    
    
}
