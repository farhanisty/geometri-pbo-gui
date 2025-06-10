/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.jajargenjang;

import geometri.benda.geometri.BangunDatar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public class JajarGenjang extends BangunDatar implements Runnable {
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
}
