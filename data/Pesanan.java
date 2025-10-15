package data;

public class Pesanan {
    // 1. WADAH: Variabel untuk menyimpan satu objek Barang dan jumlahnya
    private Barang barang;    
    private int jumlah;

    public Pesanan(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    // 3. PINTU KELUAR: Getter untuk mengambil kembali data yang sudah tersimpan
    public Barang getBarang() {
        return this.barang;
    }

    public int getJumlah() {
        return this.jumlah;
    }
}