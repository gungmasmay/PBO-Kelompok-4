package kasir;

import java.util.Scanner;
import pembayaran.Transaksi;
import data.Barang;
import data.Pelanggan;
import data.Pesanan;

public class Kasir {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Transaksi transaksi = new Transaksi();

        System.out.println("=== SISTEM KASIR ===");
        System.out.print("Masukkan ID Pelanggan (ex: P001): ");
        String IDPelanggan = input.nextLine();

        //error handling cek id pelanggan 

        Pelanggan[] daftarPelanggan = Pelanggan.getDummyData();
        Barang[] daftarBarang = Barang.getDummyData();

        double totalBelanja = 0;
        int pilihan;
        String namaPelanggan = null;

        for(Pelanggan pelanggan : daftarPelanggan) 
        {
            if (pelanggan.getId().equalsIgnoreCase(IDPelanggan)) 
            {
                namaPelanggan = pelanggan.getNama();
                break;
            }
        }
        
        do {

            System.out.println("\n=============================");
            System.out.println("Halo, " + namaPelanggan);
            System.out.println("1. Tambah Barang");
            System.out.println("2. Bayar");
            System.out.println("3. Keluar");
            System.out.println("=============================");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) 
            {
                case 1:
                    boolean top = true;

                    while (top) 
                    {
                        System.out.println("=========================================================");
                        System.out.println("|\t\t\tPILIHAN MENU\t\t\t|");
                        System.out.println("=========================================================");
                        System.out.println("| Kode\t| Nama Menu\t\t\t| Harga\t\t|");
                        System.out.println("---------------------------------------------------------");
                        
                        for (Barang barang : daftarBarang) 
                        {
                            System.out.printf("| %s\t| %-25s\t| Rp %,10.0f |\n", barang.getKode(), barang.getNama(), barang.getHarga());
                        }
                        System.out.println("=========================================================");

                        System.out.println("Masukkan '0' untuk kembali ke menu utama.");
                        System.out.print("\nMasukkan kode barang: ");
                        String kodeBarang = input.nextLine();

                        if (kodeBarang.equals("0")) 
                        {
                            top = false;
                            break; // keluar dari while
                        }

                        // Cari barang yang cocok
                        Barang barangDipilih = null;
                        for (Barang b : daftarBarang) 
                        {
                            if (b.getKode().equalsIgnoreCase(kodeBarang)) 
                            {
                                barangDipilih = b;
                                break;
                            }
                        }

                        if (barangDipilih != null) 
                        {
                            System.out.print("Masukkan jumlah: ");
                            int jumlah = input.nextInt();
                            input.nextLine(); // clear buffer

                            if (jumlah > 0) 
                            {
                                double subtotal = barangDipilih.getHarga() * jumlah;
                                totalBelanja += subtotal;
                                System.out.println("Ditambahkan: " + barangDipilih.getNama() + " x" + jumlah);
                                System.out.println("Subtotal barang ini: Rp " + subtotal);
                                System.out.println("Total sementara: Rp " + totalBelanja);
                            } 
                            else 
                            {
                                System.out.println("Jumlah harus lebih dari 0.");
                            }
                        } 
                        else 
                        {
                            System.out.println("Kode barang tidak ditemukan.");
                        }
                    }
                    break;

                case 2:
                    if (totalBelanja > 0) {
                        transaksi.prosesTransaksi(totalBelanja);
                        transaksi.CariPelanggan(IDPelanggan);
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
