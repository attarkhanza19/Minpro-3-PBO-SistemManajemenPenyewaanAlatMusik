package Minpro3.Model;

public class AlatMusikElektrik extends AlatMusik {

    private int daya;

    public AlatMusikElektrik(
            String idAlat,
            String namaAlat,
            String jenisAlat,
            double hargaSewa,
            String status,
            int daya) {

        super(idAlat, namaAlat, jenisAlat, hargaSewa, status);
        this.daya = daya;
    }

    public int getDaya() {
        return daya;
    }

    public void setDaya(int daya) {
        this.daya = daya;
    }

    @Override
    public void tampilkanData() {

        System.out.println("ID Alat       : " + getIdAlat());
        System.out.println("Nama Alat     : " + getNamaAlat());
        System.out.println("Jenis Alat    : " + getJenisAlat());
        System.out.println("Harga Sewa    : Rp" + getHargaSewa());
        System.out.println("Status        : " + getStatus());
        System.out.println("Daya          : " + daya + " Watt");
    }
}