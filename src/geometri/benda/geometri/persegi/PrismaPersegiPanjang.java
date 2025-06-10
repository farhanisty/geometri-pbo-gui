package geometri.benda.geometri.persegi;

import geometri.benda.geometri.BangunRuang;


public class PrismaPersegiPanjang extends PersegiPanjang implements BangunRuang {
    private double tinggiPrisma;
    private double luasPermukaan;
    private double volume;

    public PrismaPersegiPanjang(double tinggiPrisma, double sisiPendek, double sisiPanjang) {
        super(sisiPendek, sisiPanjang);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiPrisma, sisiPendek, sisiPanjang);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiPrisma, double sisiPendek, double sisiPanjang) {
        return super.hitungLuas(sisiPendek, sisiPanjang) * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggiPrisma, sisiPendek, sisiPanjang);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiPrisma, double sisiPendek, double sisiPanjang) {
        return 2 * super.hitungLuas(sisiPendek, sisiPanjang) + super.hitungKeliling(sisiPendek, sisiPanjang) * tinggiPrisma;
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
        return "Prisma Persegi Panjang";
    }
}
