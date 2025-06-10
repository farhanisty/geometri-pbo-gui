package geometri.benda.geometri.segitiga;

import geometri.benda.geometri.BangunRuang;

public class PrismaSegitiga extends Segitiga implements BangunRuang {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaSegitiga(double tinggiPrisma, double sisiSatu, double sisiDua, double sisiAlas, double tinggiSegitiga) {
        super(sisiSatu, sisiDua, sisiAlas, tinggiSegitiga);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        this.volume = this.hitungVolume(tinggiPrisma, sisiAlas, tinggi);
        return this.volume;
    }
    
    public double hitungVolume(double tinggiPrisma, double sisAlas, double tinggi) {
        return super.hitungLuas(sisiAlas, tinggi) * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        this.luasPermukaan = this.hitungLuasPermukaan(tinggiPrisma, sisiSatu, sisiDua, sisiAlas, tinggiPrisma);
        return this.luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiPrisma, double sisiSatu, double sisiDua, double sisiAlas, double tinggiSegitiga) {
        return 2 * super.hitungLuas(sisiAlas, tinggiSegitiga) + super.hitungKeliling(sisiSatu, sisiDua, sisiAlas) * tinggiPrisma;
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
        return "Prisma Segitiga";
    }
}
