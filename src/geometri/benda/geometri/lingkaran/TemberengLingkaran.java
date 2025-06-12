/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran;

import java.util.ArrayList;
import java.util.List;
import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author farhannivta
 */
public class TemberengLingkaran extends Lingkaran {
    public double sudutTheta;
    public double luas;
    public double keliling;
    
    public TemberengLingkaran(double jariJari, double sudutTheta) {
        super(jariJari);
        this.sudutTheta = sudutTheta;
    }
    
    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(jariJari, sudutTheta);
        return this.luas;
    }
    
    public double hitungLuas(double jariJari, double sudutTheta) {
        double thetaRadian = Math.toRadians(sudutTheta);

        double luasJuring = (sudutTheta / 360.0) * Lingkaran.PI * jariJari * jariJari;

        double luasSegitiga = 0.5 * jariJari * jariJari * Math.sin(thetaRadian);

        // Luas tembereng = luas juring - luas segitiga
        return luasJuring - luasSegitiga;
    }
    
    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(jariJari, sudutTheta);
        return this.keliling;
    }
    
    public double hitungKeliling(double jariJari, double sudutTheta) {
        double halfThetaRadian = Math.toRadians(sudutTheta / 2);

        double panjangBusur = (sudutTheta / 360.0) * 2 * Lingkaran.PI * jariJari;

        double taliBusur = 2 * jariJari * Math.sin(halfThetaRadian);

        return panjangBusur + taliBusur;
    }
    
    @Override
    public String getNama() {
        return "Tembereng Lingkaran";
    }
        
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TemberengLingkaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Jari-jari");
        inputs.add("Sudut Theta");
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
