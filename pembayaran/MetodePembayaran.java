package pembayaran;

import java.util.Scanner;
import data.Pelanggan;


abstract class Pembayaran
{
    public abstract void metodePembayaran(double totalBelanja, String nomorRekening);
}

class KartuDebit extends Pembayaran
{
    @Override
    public void metodePembayaran(double totalBelanja, String nomorRekening) 
    {
        for (Pelanggan pelanggan : Pelanggan.getDummyData()) {
            if (pelanggan.getNomorRekening().equals(nomorRekening)) {
                if (pelanggan.getSaldoDebit() >= totalBelanja) {
                    pelanggan.setSaldoDebit(pelanggan.getSaldoDebit() - totalBelanja);
                    System.out.println("Pembayaran berhasil.\nSisa saldo debit: Rp " + pelanggan.getSaldoDebit());
                } else {
                    System.out.println("Saldo debit tidak mencukupi.");
                }
                return;
            }
        }
    }
}

class EWallet extends Pembayaran
{
    @Override
    public void metodePembayaran(double totalBelanja, String NomorHP) 
    {
        for (Pelanggan pelanggan : Pelanggan.getDummyData()) {
            if (pelanggan.getNomorHP().equals(NomorHP)) {
                if (pelanggan.getSaldoEwallet() >= totalBelanja) {
                    pelanggan.setSaldoEwallet(pelanggan.getSaldoEwallet() - totalBelanja);
                    System.out.println("Pembayaran berhasil. \nSisa saldo e-wallet: Rp " + pelanggan.getSaldoEwallet());
                } else {
                    System.out.println("Saldo debit tidak mencukupi.");
                }
                return;
            }
        }
    }
}

class Tunai extends Pembayaran
{
    @Override
    public void metodePembayaran(double totalBelanja, String nomorReferensi) {
        Scanner input = new Scanner(System.in);

        System.out.println("Total Belanja: Rp " + totalBelanja);
        System.out.print("Masukkan jumlah uang tunai: ");
        
        double jumlahUang = input.nextDouble();
        input.nextLine(); 

        if (jumlahUang >= totalBelanja) {
            double kembalian = jumlahUang - totalBelanja;
            System.out.println("Pembayaran berhasil.\nKembalian Anda: Rp " + kembalian);
        } else {
            System.out.println("Uang tunai tidak mencukupi.");
        }
    }
}
