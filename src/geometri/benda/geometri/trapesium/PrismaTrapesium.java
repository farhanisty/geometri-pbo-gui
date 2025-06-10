package geometri.benda.geometri.trapesium;

import geometri.benda.geometri.BangunRuang;

public class PrismaTrapesium extends Trapesium implements BangunRuang {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaTrapesium(double tinggiPrisma, double sisiAtas, double sisiAlas, double sisiMiringSatu, double sisiMiringDua, double tinggi) {
        super(sisiAtas, sisiAlas, sisiMiringSatu, sisiMiringDua, tinggi);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiPrisma, sisiAtas, sisiAlas, tinggi);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiPrisma, double sisiAtas, double sisiAlas, double tinggi) {
        return super.hitungLuas(sisiAlas, sisiAtas, tinggi) * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggiPrisma, sisiAtas, sisiAlas, sisiMiringSatu, sisiMiringDua, tinggi);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiPrisma, double sisiAtas, double sisiAlas, double sisiMiringSatu, double sisiMiringDua, double tinggi) {
        return 2 * super.hitungLuas(sisiAlas, sisiAtas, tinggi) + super.hitungKeliling(sisiAtas, sisiAlas, sisiMiringSatu, sisiMiringDua) * tinggiPrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void setLuasPermukaan(double luasPermukaan) {
        this.luasPermukaan = luasPermukaan;
    }

    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }
}
