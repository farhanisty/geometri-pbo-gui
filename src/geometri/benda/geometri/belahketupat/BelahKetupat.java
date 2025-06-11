/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.belahketupat;

import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.lingkaran.Lingkaran;
import guigeometri.Inputable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class BelahKetupat extends BangunDatar implements Runnable, Inputable {
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
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BelahKetupat.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
         List<String> inputs = new ArrayList<>();
        inputs.add("sisi");
        inputs.add("diagonal satu");
        inputs.add("diagonal dua");
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
