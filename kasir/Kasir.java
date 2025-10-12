package kasir;

import java.util.Scanner;
import pembayaran.Transaksi;

public class Kasir {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Transaksi transaksi = new Transaksi();  // kita gunakan class Transaksi yang udah dibuat

        System.out.println("=== SISTEM KASIR ===");
        System.out.print("Masukkan Nama Kasir: ");
        String namaKasir = input.nextLine();

        double totalBelanja = 0;
        int pilihan;
        do {
            System.out.println("\n=============================");
            System.out.println("Halo, " + namaKasir);
            System.out.println("1. Tambah Barang");
            System.out.println("2. Bayar");
            System.out.println("3. Keluar");
            System.out.println("=============================");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String namaBarang = input.nextLine();

                    System.out.print("Masukkan harga barang: ");
                    double hargaBarang = input.nextDouble();

                    System.out.print("Masukkan jumlah barang: ");
                    int jumlahBarang = input.nextInt();

                    double subtotal = hargaBarang * jumlahBarang;
                    totalBelanja += subtotal;

                    System.out.println("Barang \"" + namaBarang + "\" sebanyak " + jumlahBarang + " ditambahkan. Subtotal: Rp " + subtotal);
                    System.out.println("Total sementara: Rp " + totalBelanja);
                    break;

                case 2:
                    transaksi.prosesTransaksi(totalBelanja);
                    totalBelanja = 0;
                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem kasir!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }

        } while (pilihan != 3);

        input.close();
    }
}
