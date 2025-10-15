import java.util.List;

import data.Pesanan;

public class Test {
    static void HitungTotal (List<Pesanan> pesananPelanggan)
    {
        double subtotal = 0;

        System.out.println("\n\n==================================================");
        System.out.println("|\t\tSTRUK PEMBAYARAN\t\t|");
        System.out.println("==================================================");
        System.out.println("Detail Pesanan:");

        for (Pesanan pesanan : pesananPelanggan) {
            double totalItem = pesanan.menu.harga * pesanan.jumlahPesanan;
            subtotal += totalItem;
            System.out.printf("- %-25s (%dx)\t: Rp %,10.0f\n", pesanan.menu.nama, pesanan.jumlahPesanan, totalItem);
        }

        System.out.println("--------------------------------------------------");

        double nilaiDiskon = 0;
        if (subtotal > 1000000) {
            nilaiDiskon = subtotal * DISKON_10;
            System.out.printf("Subtotal\t\t\t\t: Rp %,10.0f\n", subtotal);
            System.out.printf("Diskon (%.0f%%)\t\t\t\t: Rp %,10.0f\n", DISKON_10 * 100, nilaiDiskon);
        } else if (subtotal > 500000) {
            nilaiDiskon = subtotal * DISKON_5;
            System.out.printf("Subtotal\t\t\t\t: Rp %,10.0f\n", subtotal);
            System.out.printf("Diskon (%.0f%%)\t\t\t\t: Rp %,10.0f\n", DISKON_5 * 100, nilaiDiskon);
        } else if (subtotal > 300000) {
            nilaiDiskon = subtotal * DISKON_3;
            System.out.printf("Subtotal\t\t\t\t: Rp %,10.0f\n", subtotal);
            System.out.printf("Diskon (%.0f%%)\t\t\t\t: Rp %,10.0f\n", DISKON_3 * 100, nilaiDiskon);
        } else {
            System.out.printf("Subtotal\t\t\t\t: Rp %,10.0f\n", subtotal);
        }
        
        double totalSetelahDiskon = subtotal - nilaiDiskon;
        double nilaiPajak = totalSetelahDiskon * PAJAK_PPN;
        double totalAkhir = totalSetelahDiskon + nilaiPajak;

        System.out.printf("Pajak (%.0f%%)\t\t\t\t: Rp %,10.0f\n", PAJAK_PPN * 100, nilaiPajak);
        System.out.println("--------------------------------------------------");
        System.out.printf("Total Biaya\t\t\t\t: Rp %,10.0f\n", totalAkhir);
        System.out.println("==================================================");
        System.out.println("Terima kasih telah berkunjung!");
        
    }

}
