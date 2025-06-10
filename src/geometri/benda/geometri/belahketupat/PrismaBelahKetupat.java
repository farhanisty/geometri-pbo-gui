package geometri.benda.geometri.belahketupat;

import geometri.benda.geometri.BangunRuang;

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
    public String getNama() {
        return "Prisma Belah Ketupat";
    }
}
