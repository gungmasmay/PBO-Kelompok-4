package pembayaran;

import data.Pesanan;

public class Struk {
    public void cetakStruk(Pesanan[] Pesanan) {
        System.out.println("=== STRUK PEMBAYARAN ===");
        
        for (Pesanan pesanan : Pesanan) {
            System.out.println(pesanan.getJumlah() + " x " + pesanan.getBarang().getNama() + " - Rp " + (pesanan.getJumlah() * pesanan.getBarang().getHarga()));
        }
        System.out.println("Terima kasih telah berbelanja!");
    }
}
