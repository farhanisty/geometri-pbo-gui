package geometri.benda.geometri.jajargenjang;

import geometri.benda.geometri.BangunRuang;
import geometri.benda.geometri.belahketupat.BelahKetupat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrismaJajarGenjang extends JajarGenjang implements BangunRuang {
    private double tinggiPrisma;
    private double luasPermukaan;
    private double volume;

    public PrismaJajarGenjang(double tinggiPrisma, double sisiDatar, double sisiMiring, double tinggi) {
        super(sisiDatar, sisiMiring, tinggi);
        this.tinggiPrisma = tinggiPrisma;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiPrisma, sisiDatar, tinggi);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiPrisma, double sisiDatar, double tinggi) {
        return super.hitungLuas(sisiDatar, tinggi) * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggiPrisma, sisiDatar, sisiMiring, tinggi);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiPrisma, double sisiDatar, double sisiMiring,double tinggi) {
        return 2 * super.hitungLuas(sisiDatar, tinggi) + super.hitungKeliling(sisiDatar, sisiMiring) * tinggiPrisma;
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
            Logger.getLogger(PrismaJajarGenjang.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hitungLuasPermukaan();
        this.hitungVolume();
    }    
    @Override
    public List<String> getInputs() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Tinggi Prisma");
        inputs.add("Sisi Datar");
        inputs.add("Sisi Miring");
        inputs.add("Tinggi");
        return inputs;
    }

    @Override
    public String getNama() {
        return "Prisma Jajar Genjang";
    }
}
