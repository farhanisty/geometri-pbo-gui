package geometri.benda.geometri.belahketupat;

import geometri.benda.geometri.BangunRuang;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrismaBelahKetupat extends BelahKetupat implements BangunRuang {
    private double tinggiPrisma;
    private double luasPermukaan;
    private double volume;

    public PrismaBelahKetupat(double tinggiPrisma, double sisi, double diagonalSatu, double diagonalDua) {
        super(sisi, diagonalSatu, diagonalDua);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiPrisma, diagonalSatu, diagonalDua);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiPrisma, double diagonalSatu, double diagonalDua) {
        double luasAlas = super.hitungLuas(diagonalSatu, diagonalDua);
        
        return luasAlas * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggiPrisma, sisi, diagonalSatu, diagonalDua);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiPrisma, double sisi, double diagonalSatu, double diagonalDua) {
        return 2 * super.hitungLuas(diagonalSatu, diagonalDua) + super.hitungKeliling(sisi) * tinggiPrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
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
            Logger.getLogger(PrismaBelahKetupat.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Tinggi Prisma");
        inputs.add("Sisi");
        inputs.add("Diagonal Satu");
        inputs.add("Diagonal Dua");
        return inputs;
    }
    
    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }
}
