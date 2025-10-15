package pembayaran;

import java.util.Scanner;
import data.Pelanggan;
import data.Pesanan;

public class Transaksi {
    // protected MetodePembayaran metode;

    String nomorRekening = null;
    String nomorHP = null;

    public void prosesTransaksi(double totalBelanja, String IDPelanggan) {
        if (totalBelanja == 0) {
            System.out.println("Belum ada barang. Tambahkan barang terlebih dahulu!");
            return;
        }

        for (Pelanggan pelanggan : Pelanggan.getDummyData()) {
            if (pelanggan.getId().equalsIgnoreCase(IDPelanggan)) {
                nomorRekening = pelanggan.getNomorRekening();
                nomorHP = pelanggan.getNomorHP();
                break;
            }
        }

        Scanner input = new Scanner(System.in);

        System.out.println("\n=== PILIH METODE PEMBAYARAN ===");
        System.out.println("1. Kartu Debit");
        System.out.println("2. E-Wallet");
        System.out.println("3. Tunai");
        System.out.print("Pilih metode: ");
        int pilihMetode = input.nextInt();


        switch (pilihMetode) {
            case 1:
                System.out.println("Nomor Rekening: " + nomorRekening);
                Pembayaran Debit = new KartuDebit();
                Debit.metodePembayaran(totalBelanja, nomorRekening);
                break;
            case 2:
                System.out.println("Nomor HP: " + nomorHP);
                Pembayaran Ewallet = new EWallet();
                Ewallet.metodePembayaran(totalBelanja, nomorHP);
                break;
            case 3:
                Pembayaran pembayaranTunai = new Tunai();
                pembayaranTunai.metodePembayaran(totalBelanja, null);
            break;
            default:
                System.out.println("Metode tidak valid");
                break;
        }

        System.out.println("Kembali ke menu utama...");
        }
    }
