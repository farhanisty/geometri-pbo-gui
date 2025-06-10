/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.trapesium;

import geometri.benda.geometri.BangunDatar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public class Trapesium extends BangunDatar implements Runnable {
    public double sisiAtas;
    public double sisiAlas;
    public double sisiMiringSatu;
    public double sisiMiringDua;
    public double tinggi;
    public double luas;
    public double keliling;
    
    public Trapesium(double sisiAtas, double sisiAlas, double sisiMiringSatu, double sisiMiringDua, double tinggi) {
        this.sisiAlas = sisiAlas;
        this.sisiAtas = sisiAtas;
        this.sisiMiringSatu = sisiMiringSatu;
        this.sisiMiringDua = sisiMiringDua;
        this.tinggi = tinggi;
    }
    
    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(sisiAlas, sisiAtas, tinggi);
        return this.luas;
    }
    
    public double hitungLuas(double sisiAlas, double sisiAtas, double tinggi) {
        return (sisiAlas + sisiAtas) * tinggi / 2;
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(sisiAtas, sisiAlas, sisiMiringSatu, sisiMiringDua);
        return this.keliling;
    }
    
    public double hitungKeliling(double sisiAtas, double sisiAlas, double sisiMiringSatu, double sisiMiringDua) {
        return sisiAlas + sisiMiringDua + sisiMiringSatu + sisiAtas;
    }

    @Override
    public String getNama() {
        return "Trapesium";
    }
    
    @Override
    public void run() {
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Sisi Atas");
        inputs.add("Sisi Alas");
        inputs.add("Sisi Miring Satu");
        inputs.add("Sisi Miring Dua");
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
