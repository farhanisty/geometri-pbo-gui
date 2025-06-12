package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunRuang;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrismaPersegi extends Persegi implements BangunRuang {
    private double luasPermukaan;
    private double volume;

    public PrismaPersegi(double sisi) {
        super(sisi);
    }
    
    @Override
    public double hitungVolume() {
        this.volume = sisi * sisi * sisi; 
        return this.volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = 6 * super.hitungLuas(); 
        return this.luasPermukaan;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void setLuasPermukaan(double luasPermukaan) {
        this.luasPermukaan = luasPermukaan;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PrismaPersegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }   
    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Sisi");
        return inputs;
    }

    @Override
    public String getNama() {
        return "PrismaPersegi"; 
    }
}
