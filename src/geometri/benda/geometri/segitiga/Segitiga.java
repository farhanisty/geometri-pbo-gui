/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.segitiga;

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
public class Segitiga extends BangunDatar implements Runnable {
    public double sisiSatu;
    public double sisiDua;
    public double sisiAlas;
    public double tinggi;
    public double luas;
    public double keliling;
    
    public Segitiga(double sisiSatu, double sisiDua, double sisiAlas, double tinggi) {
        this.sisiSatu = sisiSatu;
        this.sisiDua = sisiDua;
        this.sisiAlas = sisiAlas;
        this.tinggi = tinggi;
    }
    
    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(sisiAlas, tinggi);
        return this.luas;
    }
    
    public double hitungLuas(double sisiAlas, double tinggi) {
        return sisiAlas * tinggi / 2;
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(sisiSatu, sisiDua, sisiAlas);
        return this.keliling;
    }
    
    public double hitungKeliling(double sisiSatu, double sisiDua, double sisiAlas) {
        return this.sisiSatu + this.sisiDua + this.sisiAlas;
    }

    @Override
    public String getNama() {
        return "Segitiga";
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Segitiga.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Sisi Satu");
        inputs.add("Sisi Dua");
        inputs.add("Sisi Alas");
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
