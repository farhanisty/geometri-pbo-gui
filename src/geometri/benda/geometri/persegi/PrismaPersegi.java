package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunRuang;

public class PrismaPersegi extends Persegi implements BangunRuang {
    private double tinggiPrisma;
    private double luasPermukaan;
    private double volume;

    public PrismaPersegi(double tinggiPrisma, double sisi) {
        super(sisi);
        this.tinggiPrisma = tinggiPrisma;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiPrisma, sisi);
        return this.volume;
    }

    public double hitungVolume(double tinggiPrisma, double sisi) {
        return super.hitungLuas(sisi) * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggiPrisma, sisi);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiPrisma, double sisi) {
        return 2 * super.hitungLuas(sisi) + super.hitungKeliling(sisi) * tinggiPrisma;
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
    public String getNama() {
        return "Prisma Persegi";
    }
}
