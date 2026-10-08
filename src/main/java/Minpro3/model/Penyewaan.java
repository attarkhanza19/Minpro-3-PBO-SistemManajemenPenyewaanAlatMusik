package Minpro3.Model;

public class Penyewaan {

    private String idPenyewaan;
    private String idPelanggan;
    private String idAlat;
    private int lamaSewa;
    private double totalHarga;

    public Penyewaan(
            String idPenyewaan,
            String idPelanggan,
            String idAlat,
            int lamaSewa,
            double totalHarga) {

        this.idPenyewaan = idPenyewaan;
        this.idPelanggan = idPelanggan;
        this.idAlat = idAlat;
        this.lamaSewa = lamaSewa;
        this.totalHarga = totalHarga;
    }


    public String getIdPenyewaan() {
        return idPenyewaan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getIdAlat() {
        return idAlat;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public double getTotalHarga() {
        return totalHarga;
    }


    public void setIdPenyewaan(String idPenyewaan) {
        this.idPenyewaan = idPenyewaan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void setIdAlat(String idAlat) {
        this.idAlat = idAlat;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void tampilkanData() {

        System.out.println("ID Penyewaan : " + idPenyewaan);
        System.out.println("ID Pelanggan : " + idPelanggan);
        System.out.println("ID Alat      : " + idAlat);
        System.out.println("Lama Sewa    : " + lamaSewa + " hari");
        System.out.println("Total Harga  : Rp" + totalHarga);
    }
}