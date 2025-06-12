/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri.lingkaran;

import geometri.benda.geometri.belahketupat.BelahKetupat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class JuringLingkaran extends Lingkaran {
    public double sudut;
    public double panjangBusur;
    public double luas;
    public double keliling;
    
    public JuringLingkaran(double sudut, double jariJari) {
        super(jariJari);
        this.sudut = sudut;
    }

    @Override
    public double hitungLuas() {
        this.luas = this.hitungLuas(sudut, jariJari);
        return this.luas;
    }
    
    public double hitungLuas(double sudut, double jariJari) {
        return super.hitungLuas(jariJari) * (sudut / 360.0);
    }

    // Hitung panjang busur juring
    public double hitungPanjangBusur() {
        this.panjangBusur = this.hitungPanjangBusur(sudut, jariJari);
        return this.panjangBusur;
    }
    
    public double hitungPanjangBusur(double sudut, double jariJari) {
        return super.hitungKeliling(jariJari) * (sudut / 360.0);
    }

    @Override
    public double hitungKeliling() {
        this.keliling = this.hitungKeliling(sudut, jariJari);
        return this.keliling;
    }
    
    public double hitungKeliling(double sudut, double jariJari) {
        return this.hitungPanjangBusur(sudut, jariJari) + 2 * jariJari;
    }
    
    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }
        
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JuringLingkaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuas();
        this.hitungKeliling();
        this.hitungPanjangBusur();
    }

    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Sudut");
        inputs.add("Jari-Jari");
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

    public double getPanjangBusur() {
        return panjangBusur;
    }
}
