package pembayaran;

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
                    System.out.println("Pembayaran berhasil. Sisa saldo debit: Rp " + pelanggan.getSaldoDebit());
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
                    System.out.println("✅ Pembayaran berhasil. Sisa saldo e-wallet: Rp " + pelanggan.getSaldoEwallet());
                } else {
                    System.out.println("❌ Saldo debit tidak mencukupi.");
                }
                return;
            }
        }
    }
}



    // public void KartuDebit(double totalBelanja) {
    //     System.out.println("Proses pembayaran dengan Kartu Debit sebesar: Rp " + totalBelanja);
    // }

    // public void EWallet(double totalBelanja) {
    //     System.out.println("Proses pembayaran dengan E-Wallet sebesar: Rp " + totalBelanja);
    // }

    // public void Tunai(double totalBelanja, double uangTunai) {
    //     System.out.println("Proses pembayaran dengan Tunai sebesar: Rp " + totalBelanja + ", Uang tunai diterima: Rp " + uangTunai);
    // }

