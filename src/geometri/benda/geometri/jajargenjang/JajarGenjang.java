/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.jajargenjang;

import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class JajarGenjang extends BangunDatar {
    public double sisiDatar;
    public double sisiMiring;
    public double tinggi;
    public double luas;
    public double keliling;
    
    public JajarGenjang(double sisiDatar, double sisiMiring, double tinggi) {
        this.sisiDatar = sisiDatar;
        this.sisiMiring = sisiMiring;
        this.tinggi = tinggi;
    }
    
    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(sisiDatar, tinggi);
        return this.luas;
    }
    
    public double hitungLuas(double sisiDatar, double tinggi) {
        return sisiDatar * tinggi;
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(sisiDatar, sisiMiring);
        return this.keliling;
    }
    
    public double hitungKeliling(double sisiDatar, double sisiMiring) {
        return sisiDatar * 2 + sisiMiring * 2;
    }

    @Override
    public String getNama() {
        return "JajarGenjang";
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JajarGenjang.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Sisi Datar");
        inputs.add("Sisi Miring");
        inputs.add("Tinggi");
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
