package pembayaran;

import java.util.Scanner;

import pembayaran.MetodePembayaran;

public class Transaksi {
    protected MetodePembayaran metode;

    public Transaksi() {
        this.metode = new MetodePembayaran();
    }

    public void prosesTransaksi(double totalBelanja) {
        if (totalBelanja == 0) {
            System.out.println("Belum ada barang. Tambahkan barang terlebih dahulu!");
            return;
        }

        Scanner input = new Scanner(System.in);

        // 🧾 Menu pilih metode pembayaran
        System.out.println("\n=== PILIH METODE PEMBAYARAN ===");
        System.out.println("1. Kartu Debit");
        System.out.println("2. E-Wallet");
        System.out.println("3. Tunai");
        System.out.print("Pilih metode: ");
        int pilihMetode = input.nextInt();


        switch (pilihMetode) {
            case 1:
                metode.KartuDebit(totalBelanja);
                break;
            case 2:
                metode.EWallet(totalBelanja);
                break;
            case 3:
                System.out.print("Masukkan uang tunai yang diberikan: ");
                double uangTunai = input.nextDouble();
                metode.Tunai(totalBelanja, uangTunai);
                break;
            default:
                System.out.println("Metode tidak valid");
                return;
        }

        // boolean sukses = metode.bayar(totalBelanja);
        // if (sukses) {
        //     System.out.println("✅ Transaksi berhasil untuk " + metode.getNamaPelanggan());
        // } else {
        //     System.out.println("❌ Transaksi gagal. Silakan coba lagi.");
        // }

        System.out.println("Kembali ke menu utama...");
    }
    }
