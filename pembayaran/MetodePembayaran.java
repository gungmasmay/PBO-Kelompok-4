package pembayaran;

import java.util.Scanner;
import data.Pelanggan;
import data.Pesanan;
import java.util.ArrayList;
import java.util.List;


interface Pembayaran
{
    public abstract void metodePembayaran(double totalBelanja, String nomorRekening, List<Pesanan> daftarPesanan);
}

class KartuDebit implements Pembayaran
{
    @Override
    public void metodePembayaran(double totalBelanja, String nomorRekening, List<Pesanan> daftarPesanan) 
    {
        for (Pelanggan pelanggan : Pelanggan.getDummyData()) {
            if (pelanggan.getNomorRekening().equals(nomorRekening)) {
                if (pelanggan.getSaldoDebit() >= totalBelanja) {
                    pelanggan.setSaldoDebit(pelanggan.getSaldoDebit() - totalBelanja);
                    System.out.println("Pembayaran berhasil.\nSisa saldo debit: Rp " + pelanggan.getSaldoDebit());
                    Struk struk = new Struk();
                    struk.cetakStruk(daftarPesanan, totalBelanja);
                } else {
                    System.out.println("Saldo debit tidak mencukupi.");
                }
                return;
            }
        }
    }
}

class EWallet implements Pembayaran
{
    @Override
    public void metodePembayaran(double totalBelanja, String NomorHP, List<Pesanan> daftarPesanan) 
    {
        for (Pelanggan pelanggan : Pelanggan.getDummyData()) {
            if (pelanggan.getNomorHP().equals(NomorHP)) {
                if (pelanggan.getSaldoEwallet() >= totalBelanja) {
                    pelanggan.setSaldoEwallet(pelanggan.getSaldoEwallet() - totalBelanja);
                    System.out.println("Pembayaran berhasil. \nSisa saldo e-wallet: Rp " + pelanggan.getSaldoEwallet());
                    Struk struk = new Struk();
                    struk.cetakStruk(daftarPesanan, totalBelanja);
                } else {
                    System.out.println("Saldo debit tidak mencukupi.");
                }
                return;
            }
        }
    }
}

class Tunai implements Pembayaran
{
    @Override
    public void metodePembayaran(double totalBelanja, String nomorReferensi, List<Pesanan> daftarPesanan) {
        Scanner input = new Scanner(System.in);

        System.out.println("Total Belanja: Rp " + totalBelanja);
        System.out.print("Masukkan jumlah uang tunai: ");
        
        double jumlahUang = input.nextDouble();
        input.nextLine(); 

        if (jumlahUang >= totalBelanja) {
            double kembalian = jumlahUang - totalBelanja;
            Struk struk = new Struk();
            struk.cetakStruk(daftarPesanan, totalBelanja);
            System.out.println("Pembayaran berhasil.\nKembalian Anda: Rp " + kembalian);
        } else {
            System.out.println("Uang tunai tidak mencukupi.");
        }
    }
}
