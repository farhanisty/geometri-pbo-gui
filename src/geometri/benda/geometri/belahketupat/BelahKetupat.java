/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.belahketupat;

import geometri.benda.geometri.BangunDatar;

/**
 *
 * @author farhannivta
 */
public class BelahKetupat extends BangunDatar implements Runnable {
    public double sisi;
    public double diagonalSatu;
    public double diagonalDua;
    public double luas;
    public double keliling;
    
    public BelahKetupat(double sisi, double diagonalSatu, double diagonalDua) {
        this.sisi = sisi;
        this.diagonalDua = diagonalDua;
        this.diagonalSatu = diagonalSatu;
    }

    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(this.diagonalDua, this.diagonalDua);
        return this.luas;
    }
    
    public double hitungLuas(double diagonalSatu, double diagonalDua) {
        return diagonalSatu * diagonalDua / 2;
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(this.sisi);
        return this.keliling;
    }
    
    public double hitungKeliling(double sisi) {
        return sisi * 4;
    }

    @Override
    public String getNama() {
        return "Belah Ketupat";
    }

    @Override
    public void run() {
        this.hitungLuas();
        this.hitungKeliling();
    }
}
