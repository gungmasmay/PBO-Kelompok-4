package data;

public class Pelanggan {
    private String id;
    private String nama;
    private String nomorHP;
    private String nomorRekening;
    private double saldoDebit;
    private double saldoEwallet;

    public Pelanggan(String id, String nama, String nomorHP, String nomorRekening, double saldoDebit, double saldoEwallet) {
        this.id = id;
        this.nama = nama;
        this.nomorHP = nomorHP;
        this.nomorRekening = nomorRekening;
        this.saldoDebit = saldoDebit;
        this.saldoEwallet = saldoEwallet;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldoDebit() {
        return saldoDebit;
    }

    public double getSaldoEwallet() {
        return saldoEwallet;
    }

    public void setSaldoDebit(double saldoDebit) {
        this.saldoDebit = saldoDebit;
    }

    public void setSaldoEwallet(double saldoEwallet) {
        this.saldoEwallet = saldoEwallet;
    }


    public static Pelanggan[] getDummyData() {
        return new Pelanggan[] {
            new Pelanggan("P001", "Andi Saputra", "081234567890", "1234567890", 2_000_000, 500_000),
            new Pelanggan("P002", "Budi Santoso", "082345678901", "9876543210", 1_500_000, 300_000),
            new Pelanggan("P003", "Citra Dewi", "083456789012", "1122334455", 5_000_000, 1_200_000),
            new Pelanggan("P004", "Dewi Lestari", "084567890123", "5566778899", 750_000, 150_000),
            new Pelanggan("P005", "Eko Prasetyo", "085678901234", "6677889900", 3_000_000, 2_000_000),
        };
    }
}
