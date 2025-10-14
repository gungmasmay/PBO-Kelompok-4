package kasir;

import java.util.Scanner;
import pembayaran.Transaksi;
import data.Barang;

public class Kasir {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Transaksi transaksi = new Transaksi();

        System.out.println("=== SISTEM KASIR ===");
        System.out.print("Masukkan Nama Kasir: ");
        String namaKasir = input.nextLine();

        Barang[] daftarBarang = Barang.getDummyData();

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
            input.nextLine();
            switch (pilihan) {
                case 1:
                    boolean top = true;
                    while (top) {
                        System.out.println("\nDaftar Barang:");
                        for (Barang barang : daftarBarang) {
                            System.out.println(barang.getKode() + " - " + barang.getNama() + " : Rp " + barang.getHarga());
                        }
                        System.out.println("Masukkan '0' untuk kembali ke menu utama.");
                        System.out.print("\nMasukkan kode barang: ");
                        String kodeBarang = input.nextLine();

                        // ✅ Cek dulu apakah user mau kembali
                        if (kodeBarang.equals("0")) {
                            top = false;
                            break; // keluar dari while
                        }

                        // Cari barang yang cocok
                        Barang barangDipilih = null;
                        for (Barang b : daftarBarang) {
                            if (b.getKode().equalsIgnoreCase(kodeBarang)) {
                                barangDipilih = b;
                                break;
                            }
                        }

                        if (barangDipilih != null) {
                            System.out.print("Masukkan jumlah: ");
                            int jumlah = input.nextInt();
                            input.nextLine(); // clear buffer

                            if (jumlah > 0) {
                                double subtotal = barangDipilih.getHarga() * jumlah;
                                totalBelanja += subtotal;
                                System.out.println("Ditambahkan: " + barangDipilih.getNama() + " x" + jumlah);
                                System.out.println("Subtotal barang ini: Rp " + subtotal);
                                System.out.println("Total sementara: Rp " + totalBelanja);
                            } else {
                                System.out.println("Jumlah harus lebih dari 0.");
                            }
                        } else {
                            System.out.println("Kode barang tidak ditemukan.");
                        }
                    }
                    break;

                case 2:
                    if (totalBelanja > 0) {
                        transaksi.prosesTransaksi(totalBelanja);
                        totalBelanja = 0;
                    } else {
                        System.out.println("Belum ada barang yang ditambahkan.");
                    }
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
