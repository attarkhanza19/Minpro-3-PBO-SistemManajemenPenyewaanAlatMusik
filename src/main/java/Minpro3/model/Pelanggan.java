package Minpro3.Model;

public class Pelanggan {

    private String idPelanggan;
    private String namaPelanggan;
    private String noTelepon;
    private String alamat;

    public Pelanggan(
            String idPelanggan,
            String namaPelanggan,
            String noTelepon,
            String alamat) {

        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }


    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    // Setter

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void tampilkanData() {

        System.out.println("ID Pelanggan : " + idPelanggan);
        System.out.println("Nama         : " + namaPelanggan);
        System.out.println("No. Telepon  : " + noTelepon);
        System.out.println("Alamat       : " + alamat);
    }
}