package Minpro3.Model;

public class AlatMusikAkustik extends AlatMusik implements DapatDitampilkan {

    private String bahan;

    public AlatMusikAkustik(
            String idAlat,
            String namaAlat,
            String jenisAlat,
            double hargaSewa,
            String status,
            String bahan) {

        super(idAlat, namaAlat, jenisAlat, hargaSewa, status);

        this.bahan = bahan;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    @Override
    public void tampilkanData() {

        System.out.println("ID Alat       : " + getIdAlat());
        System.out.println("Nama Alat     : " + getNamaAlat());
        System.out.println("Jenis Alat    : " + getJenisAlat());
        System.out.println("Harga Sewa    : Rp" + getHargaSewa());
        System.out.println("Status        : " + getStatus());
        System.out.println("Bahan         : " + bahan);
    }
}