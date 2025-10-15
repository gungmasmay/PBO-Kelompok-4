package pembayaran;

import java.util.List;

import data.Barang;
import data.Pesanan;

public class Struk {
    public void cetakStruk(List<Pesanan> daftarPesanan, double totalBelanja) {
    System.out.println("\n\n==================================================");
    System.out.println("|\t\tSTRUK PEMBAYARAN\t\t|");
    System.out.println("==================================================");
    System.out.println("Detail Pesanan:");
    
    for (Pesanan pesanan : daftarPesanan) {
        Barang barang = pesanan.getBarang();
        System.out.printf("- %-25s(%dx)\t:Rp%,10.0f\n", 
            barang.getNama(), pesanan.getJumlah(), 
            barang.getHarga() * pesanan.getJumlah());
    }
    System.out.println("--------------------------------------------------");
    System.out.println("Total: Rp " + totalBelanja);
}
}
