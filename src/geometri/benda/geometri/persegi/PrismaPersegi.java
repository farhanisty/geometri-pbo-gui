package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunRuang;
import java.util.ArrayList;
import java.util.List;

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
