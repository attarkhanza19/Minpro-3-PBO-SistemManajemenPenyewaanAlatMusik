package Minpro3.Model;

public abstract class AlatMusik implements DapatDitampilkan {

    private String idAlat;
    private String namaAlat;
    private String jenisAlat;
    private double hargaSewa;
    private String status;

    public AlatMusik(String idAlat, String namaAlat, String jenisAlat,
                     double hargaSewa, String status) {

        this.idAlat = idAlat;
        this.namaAlat = namaAlat;
        this.jenisAlat = jenisAlat;
        this.hargaSewa = hargaSewa;
        this.status = status;
    }

    // Getter

    public String getIdAlat() {
        return idAlat;
    }

    public String getNamaAlat() {
        return namaAlat;
    }

    public String getJenisAlat() {
        return jenisAlat;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public String getStatus() {
        return status;
    }

    // Setter

    public void setIdAlat(String idAlat) {
        this.idAlat = idAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }

    public void setJenisAlat(String jenisAlat) {
        this.jenisAlat = jenisAlat;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double hitungTotal(double hargaSewa, int lamaSewa) {
        return hargaSewa * lamaSewa;
    }

    public double hitungTotal(double hargaSewa, int lamaSewa, double diskon) {

        double total = hargaSewa * lamaSewa;

        return total - (total * diskon / 100);
    }

    @Override
    public abstract void tampilkanData();
}