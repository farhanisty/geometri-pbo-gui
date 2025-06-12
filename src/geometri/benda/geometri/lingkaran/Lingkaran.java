/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran;

import geometri.benda.geometri.BangunDatar;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class Lingkaran extends BangunDatar {
    public static final double PI = 3.14;
    public double jariJari;
    public double luas;
    public double keliling;
    
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(jariJari);
        return this.luas;
    }
    
    public double hitungLuas(double jariJari) {
        return Lingkaran.PI * (jariJari * jariJari);
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(jariJari);
        return this.keliling;
    }
    
    public double hitungKeliling(double jariJari) {
        return Lingkaran.PI * jariJari * 2;
    }

    @Override
    public String getNama() {
        return "Lingkaran";
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Lingkaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Jari Jari");
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
