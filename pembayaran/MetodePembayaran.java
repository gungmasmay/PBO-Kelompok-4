package pembayaran;


public class MetodePembayaran {
    public void KartuDebit(double totalBelanja) {
        System.out.println("Proses pembayaran dengan Kartu Debit sebesar: Rp " + totalBelanja);
    }

    public void EWallet(double totalBelanja) {
        System.out.println("Proses pembayaran dengan E-Wallet sebesar: Rp " + totalBelanja);
    }

    public void Tunai(double totalBelanja, double uangTunai) {
        System.out.println("Proses pembayaran dengan Tunai sebesar: Rp " + totalBelanja + ", Uang tunai diterima: Rp " + uangTunai);
    }
}
