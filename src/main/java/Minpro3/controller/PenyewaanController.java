package Minpro3.Controller;

import java.util.ArrayList;
import Minpro3.Model.*;

public class PenyewaanController {

    private ArrayList<AlatMusik> daftarAlat;
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Penyewaan> daftarPenyewaan;

    public PenyewaanController() {

        daftarAlat = new ArrayList<>();
        daftarPelanggan = new ArrayList<>();
        daftarPenyewaan = new ArrayList<>();

        daftarAlat.add(new AlatMusikAkustik(
                "GTR-001",
                "Gitar Akustik",
                "Gitar",
                100000,
                "Disewa",
                "Kayu"
        ));

        daftarAlat.add(new AlatMusikElektrik(
                "KBD-001",
                "Keyboard",
                "Keyboard",
                150000,
                "Disewa",
                220
        ));

        daftarAlat.add(new AlatMusikAkustik(
                "DRM-001",
                "Drum Akustik",
                "Drum",
                200000,
                "Ready",
                "Kayu"
        ));

        daftarAlat.add(new AlatMusikElektrik(
                "GTR-002",
                "Gitar Elektrik",
                "Gitar",
                175000,
                "Ready",
                220
        ));

        daftarPelanggan.add(new Pelanggan(
                "PLN-001",
                "Dilan",
                "08882293918",
                "Samarinda"
        ));

        daftarPelanggan.add(new Pelanggan(
                "PLN-002",
                "Ibrah",
                "081234567890",
                "Samarinda"
        ));

        daftarPelanggan.add(new Pelanggan(
                "PLN-003",
                "Rizky",
                "082345678901",
                "Balikpapan"
        ));

        daftarPenyewaan.add(new Penyewaan(
                "SW-001",
                "PLN-001",
                "GTR-001",
                2,
                200000
        ));

        daftarPenyewaan.add(new Penyewaan(
                "SW-002",
                "PLN-002",
                "KBD-001",
                3,
                450000
        ));
    }

    public ArrayList<AlatMusik> getDaftarAlat() {
        return daftarAlat;
    }

    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public ArrayList<Penyewaan> getDaftarPenyewaan() {
        return daftarPenyewaan;
    }

    public boolean tambahAlat(AlatMusik alat) {

        if (alat == null) {
            return false;
        }

        if (cariAlat(alat.getIdAlat()) != null) {
            return false;
        }

        daftarAlat.add(alat);

        return true;
    }

    public boolean ubahAlat(
            String id,
            String nama,
            String jenis,
            double harga,
            String status) {

        AlatMusik alat = cariAlat(id);

        if (alat == null) {
            return false;
        }

        alat.setNamaAlat(nama);
        alat.setJenisAlat(jenis);
        alat.setHargaSewa(harga);
        alat.setStatus(status);

        return true;
    }

    public boolean hapusAlat(String id) {

        AlatMusik alat = cariAlat(id);

        if (alat == null) {
            return false;
        }

        daftarAlat.remove(alat);

        return true;
    }


    public boolean tambahPelanggan(Pelanggan pelanggan) {

        if (pelanggan == null) {
            return false;
        }

        if (cariPelanggan(pelanggan.getIdPelanggan()) != null) {
            return false;
        }

        daftarPelanggan.add(pelanggan);

        return true;
    }

    public boolean ubahPelanggan(
            String id,
            String nama,
            String noTelepon,
            String alamat) {

        Pelanggan pelanggan = cariPelanggan(id);

        if (pelanggan == null) {
            return false;
        }

        pelanggan.setNamaPelanggan(nama);
        pelanggan.setNoTelepon(noTelepon);
        pelanggan.setAlamat(alamat);

        return true;
    }

    public boolean hapusPelanggan(String id) {

        Pelanggan pelanggan = cariPelanggan(id);

        if (pelanggan == null) {
            return false;
        }

        daftarPelanggan.remove(pelanggan);

        return true;
    }

    public boolean tambahPenyewaan(
            String idPenyewaan,
            String idPelanggan,
            String idAlat,
            int lamaSewa) {

        return tambahPenyewaan(
                idPenyewaan,
                idPelanggan,
                idAlat,
                lamaSewa,
                0
        );
    }

    public boolean tambahPenyewaan(
            String idPenyewaan,
            String idPelanggan,
            String idAlat,
            int lamaSewa,
            double diskon) {

        if (cariPenyewaan(idPenyewaan) != null) {
            return false;
        }

        Pelanggan pelanggan = cariPelanggan(idPelanggan);
        AlatMusik alat = cariAlat(idAlat);

        if (pelanggan == null || alat == null) {
            return false;
        }

        if (!alat.getStatus().equalsIgnoreCase("Ready")) {
            return false;
        }

        if (lamaSewa <= 0) {
            return false;
        }

        if (diskon < 0 || diskon > 100) {
            return false;
        }

        double totalHarga;

        if (diskon == 0) {

            totalHarga = alat.hitungTotal(
                    alat.getHargaSewa(),
                    lamaSewa
            );

        } else {

            totalHarga = alat.hitungTotal(
                    alat.getHargaSewa(),
                    lamaSewa,
                    diskon
            );
        }

        Penyewaan penyewaan = new Penyewaan(
                idPenyewaan,
                idPelanggan,
                idAlat,
                lamaSewa,
                totalHarga
        );

        daftarPenyewaan.add(penyewaan);

        alat.setStatus("Disewa");

        return true;
    }

    public boolean ubahPenyewaan(
            String id,
            String idPelanggan,
            String idAlat,
            int lamaSewa) {

        Penyewaan penyewaan = cariPenyewaan(id);

        if (penyewaan == null) {
            return false;
        }

        Pelanggan pelanggan = cariPelanggan(idPelanggan);
        AlatMusik alatBaru = cariAlat(idAlat);

        if (pelanggan == null || alatBaru == null) {
            return false;
        }

        if (lamaSewa <= 0) {
            return false;
        }

        if (!penyewaan.getIdAlat().equalsIgnoreCase(idAlat)) {

            if (!alatBaru.getStatus().equalsIgnoreCase("Ready")) {
                return false;
            }

            AlatMusik alatLama =
                    cariAlat(penyewaan.getIdAlat());

            if (alatLama != null) {
                alatLama.setStatus("Ready");
            }

            alatBaru.setStatus("Disewa");

            penyewaan.setIdAlat(idAlat);
        }

        double totalHarga = alatBaru.hitungTotal(
                alatBaru.getHargaSewa(),
                lamaSewa
        );

        penyewaan.setIdPelanggan(idPelanggan);
        penyewaan.setLamaSewa(lamaSewa);
        penyewaan.setTotalHarga(totalHarga);

        return true;
    }

    public boolean hapusPenyewaan(String id) {

        Penyewaan penyewaan = cariPenyewaan(id);

        if (penyewaan == null) {
            return false;
        }

        AlatMusik alat =
                cariAlat(penyewaan.getIdAlat());

        if (alat != null) {
            alat.setStatus("Ready");
        }

        daftarPenyewaan.remove(penyewaan);

        return true;
    }
    
            public void lihatAlat() {

        System.out.println("\n===== DAFTAR ALAT MUSIK =====");

        if (daftarAlat.isEmpty()) {
            System.out.println("Belum ada data alat musik.");
            return;
        }

        for (AlatMusik alat : daftarAlat) {
            DapatDitampilkan data = (DapatDitampilkan) alat;
            data.tampilkanData();
            System.out.println("----------------------------");
        }
    }

    public void lihatPelanggan() {

        System.out.println("\n===== DAFTAR PELANGGAN =====");

        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }

        for (Pelanggan pelanggan : daftarPelanggan) {
            pelanggan.tampilkanData();
            System.out.println("----------------------------");
        }
    }

    public void lihatPenyewaan() {

        System.out.println("\n===== DAFTAR PENYEWAAN =====");

        if (daftarPenyewaan.isEmpty()) {
            System.out.println("Belum ada data penyewaan.");
            return;
        }

        for (Penyewaan penyewaan : daftarPenyewaan) {
            penyewaan.tampilkanData();
            System.out.println("----------------------------");
        }
    }


    public AlatMusik cariAlat(String id) {

        for (AlatMusik alat : daftarAlat) {

            if (alat.getIdAlat().equalsIgnoreCase(id)) {
                return alat;
            }
        }

        return null;
    }

    public Pelanggan cariPelanggan(String id) {

        for (Pelanggan pelanggan : daftarPelanggan) {

            if (pelanggan.getIdPelanggan()
                    .equalsIgnoreCase(id)) {

                return pelanggan;
            }
        }

        return null;
    }

    public Penyewaan cariPenyewaan(String id) {

        for (Penyewaan penyewaan : daftarPenyewaan) {

            if (penyewaan.getIdPenyewaan()
                    .equalsIgnoreCase(id)) {

                return penyewaan;
            }
        }

        return null;
    }
}