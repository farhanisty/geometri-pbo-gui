/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunDatar;

/**
 *
 * @author farhannivta
 */
public class Persegi extends BangunDatar implements Runnable {
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
        this.hitungLuas();
        this.hitungKeliling();
    }
}
