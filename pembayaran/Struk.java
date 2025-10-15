package pembayaran;

import java.util.List;

import data.Barang;
import data.Pesanan;

public class Struk {
    public void cetakStruk(List<Pesanan> daftarPesanan, double totalBelanja) {
    System.out.println("\n=== STRUK PEMBAYARAN ===");
    
    for (Pesanan pesanan : daftarPesanan) {
        Barang barang = pesanan.getBarang();
        System.out.printf("%s x%d = Rp %,10.0f\n", 
            barang.getNama(), pesanan.getJumlah(), 
            barang.getHarga() * pesanan.getJumlah());
    }
    
    System.out.println("Total: Rp " + totalBelanja);
}
}
