package geometri.benda.geometri.layanglayang;

import geometri.benda.geometri.BangunRuang;

public class PrismaLayangLayang extends LayangLayang implements BangunRuang {
    private double tinggiPrisma;
    private double luasPermukaan;
    private double volume;

    public PrismaLayangLayang(double tinggiPrisma, double diagonalSatu, double diagonalDua, double sisiPendek, double sisiPanjang) {
        super(diagonalSatu, diagonalDua, sisiPendek, sisiPanjang);
        this.tinggiPrisma = tinggiPrisma;
    }
    
    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiPrisma, diagonalSatu, diagonalDua);
        return this.volume;
    }

    public double hitungVolume(double tinggiPrisma, double diagonalSatu, double diagonalDua) {
        return super.hitungLuas(diagonalSatu, diagonalDua) * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggiPrisma, diagonalSatu, diagonalDua, sisiPendek, sisiPanjang);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiPrisma, double diagonalSatu, double diagonalDua, double sisiPendek, double sisiPanjang) {
        return 2 * super.hitungLuas(diagonalSatu, diagonalDua) + super.hitungKeliling(sisiPendek, sisiPanjang) * tinggiPrisma;
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
        return "Prisma Layang Layang";
    }
}
