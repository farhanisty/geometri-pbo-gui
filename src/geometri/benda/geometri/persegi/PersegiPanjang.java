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
public class PersegiPanjang extends BangunDatar implements Runnable {
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
        this.hitungLuas();
        this.hitungKeliling();
    }
}
