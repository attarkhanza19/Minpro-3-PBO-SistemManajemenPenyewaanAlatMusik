package Minpro3.View;

import java.util.Scanner;

public class MenuView {

    private Scanner input;

    public MenuView(Scanner input) {
        this.input = input;
    }

    public void tampilkanMenuUtama() {
        System.out.println("\n=================================");
        System.out.println("   SISTEM PENYEWAAN ALAT MUSIK");
        System.out.println("=================================");
        System.out.println("1. Kelola Data Alat Musik");
        System.out.println("2. Kelola Data Pelanggan");
        System.out.println("3. Kelola Data Penyewaan");
        System.out.println("4. Keluar");
        System.out.println("=================================");
    }

    public int inputMenu() {
        System.out.print("Pilih menu: ");
        return Integer.parseInt(input.nextLine());
    }

    public void tampilkanMenuAlat() {
        System.out.println("\n=================================");
        System.out.println("       KELOLA ALAT MUSIK");
        System.out.println("=================================");
        System.out.println("1. Lihat Data Alat");
        System.out.println("2. Tambah Alat");
        System.out.println("3. Ubah Alat");
        System.out.println("4. Hapus Alat");
        System.out.println("5. Kembali");
        System.out.println("=================================");
    }

    public void tampilkanMenuPelanggan() {
        System.out.println("\n=================================");
        System.out.println("       KELOLA DATA PELANGGAN");
        System.out.println("=================================");
        System.out.println("1. Lihat Data Pelanggan");
        System.out.println("2. Tambah Pelanggan");
        System.out.println("3. Ubah Pelanggan");
        System.out.println("4. Hapus Pelanggan");
        System.out.println("5. Kembali");
        System.out.println("=================================");
    }

    public void tampilkanMenuPenyewaan() {
        System.out.println("\n=================================");
        System.out.println("       KELOLA DATA PENYEWAAN");
        System.out.println("=================================");
        System.out.println("1. Lihat Data Penyewaan");
        System.out.println("2. Tambah Penyewaan");
        System.out.println("3. Ubah Penyewaan");
        System.out.println("4. Hapus Penyewaan");
        System.out.println("5. Kembali");
        System.out.println("=================================");
    }
    
    public String inputNomorTelepon(String pesan) {

    while (true) {

        System.out.print(pesan);

        String nomor = input.nextLine();

        if (nomor.matches("\\+?[0-9]+")) {
            return nomor;
        }

        System.out.println(
                "Nomor telepon hanya boleh berisi angka "
                + "dan tanda + di awal."
        );
    }
}


    public String inputString(String pesan) {
        System.out.print(pesan);
        return input.nextLine();
    }

    public int inputInt(String pesan) {
        System.out.print(pesan);
        return Integer.parseInt(input.nextLine());
    }

    public double inputDouble(String pesan) {
        System.out.print(pesan);
        return Double.parseDouble(input.nextLine());
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanError(String pesan) {
        System.out.println("Yang Anda masukkan tidak valid.");
        System.out.println(pesan);
    }
}