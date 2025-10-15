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
            new Barang("N001", "Nasi Goreng", 15000),
            new Barang("N002", "Nasi Kuning", 7000),
            new Barang("N003", "Nasi Uduk", 10000),
            new Barang("N004", "Nasi Sela", 5000),
            new Barang("M001", "Mie Goreng", 12000),
            new Barang("M002", "Mie Kuah", 13000),
            new Barang("M003", "Mie Nyemek", 14000),
            new Barang("M004", "Mie Carbonara", 16000),
            new Barang("A001", "Ayam Bakar", 20000),
            new Barang("A002", "Ayam Goreng", 20000),
            new Barang("A003", "Ayam Geprek", 15000),
            new Barang("A004", "Ayam Taliwang", 30000),
            new Barang("A005", "Ayam Gepuk", 25000),
            new Barang("D001", "Air Mineral", 5000),
            new Barang("D002", "Es Teh", 7000),
            new Barang("D003", "Pop Ice", 4000),
            new Barang("D004", "Teh Poci", 5000)
        };
    }
}
