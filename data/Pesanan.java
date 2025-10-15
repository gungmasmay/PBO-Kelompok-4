package data;

public class Pesanan {
    private Barang barang;   
    private int jumlah;

    public Pesanan(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public Barang getBarang() {
        return this.barang;
    }

    public int getJumlah() {
        return this.jumlah;
    }
}