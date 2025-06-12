/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.layanglayang;

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
public class LayangLayang extends BangunDatar {
    public double diagonalSatu;
    public double diagonalDua;
    public double sisiPendek;
    public double sisiPanjang;
    public double luas;
    public double keliling;
    
    public LayangLayang(double diagonalSatu, double diagonalDua, double sisiPendek, double sisiPanjang) {
        this.diagonalSatu = diagonalSatu;
        this.diagonalDua = diagonalDua;
        this.sisiPendek = sisiPendek;
        this.sisiPanjang = sisiPanjang;
    }

    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(diagonalSatu, diagonalDua);
        return this.luas;
    }
    
    public double hitungLuas(double diagonalSatu, double diagonalDua) {
        return diagonalSatu * diagonalDua / 2;
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
        return "Layang-layang";
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LayangLayang.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Diagonal Satu");
        inputs.add("Diagonal Dua");
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
