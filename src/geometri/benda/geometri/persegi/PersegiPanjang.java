/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.persegi;

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
public class PersegiPanjang extends BangunDatar {
    public double sisiPendek;
    public double sisiPanjang;
    public double luas;
    public double keliling;
    
    public PersegiPanjang(double sisiPendek, double sisiPanjang) {
        this.sisiPendek = sisiPendek;
        this.sisiPanjang = sisiPanjang;
    }
    
    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(sisiPendek, sisiPanjang);
        return this.luas;
    }
    
    public double hitungLuas(double sisiPendek, double sisiPanjang) {
        return sisiPendek * sisiPanjang;
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(sisiPendek, sisiPanjang);
        return this.keliling;
    }
    
    public double hitungKeliling(double sisiPendek, double sisiPanjang) {
        return sisiPendek * 2 + sisiPanjang * 2;
    }

    @Override
    public String getNama() {
        return "Persegi Panjang";
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PersegiPanjang.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }
    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Sisi Pendek");
        inputs.add("Sisi Panjang");
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
