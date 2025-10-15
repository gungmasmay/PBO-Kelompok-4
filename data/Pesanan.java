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

    public static Pesanan[] getDummyData() {
        Barang[] daftarBarang = Barang.getDummyData();
        return new Pesanan[] {
            new Pesanan(daftarBarang[0], 2),
            new Pesanan(daftarBarang[1], 1),
            new Pesanan(daftarBarang[2], 3),
            new Pesanan(daftarBarang[3], 1),
            new Pesanan(daftarBarang[4], 5)
        };
    }
}