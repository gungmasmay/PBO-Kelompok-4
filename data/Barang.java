package data;

public class Barang {
    private String kode;
    private String nama;
    private double harga;

    public Barang(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public static Barang[] getDummyData() {
        return new Barang[] {
            new Barang("B001", "Beras 5kg", 75000),
            new Barang("B002", "Minyak Goreng 1L", 18000),
            new Barang("B003", "Gula Pasir 1kg", 15000),
            new Barang("B004", "Telur 1kg", 28000),
            new Barang("B005", "Mie Instan", 3500),
        };
    }
}
