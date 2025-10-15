import java.util.Scanner;

public class MesinKasir {

     public static Scanner scanner = new Scanner(System.in);
     public static Item[] pesanan = new Item[100];
     public static int jumlahPesanan = 0;

     public static class Item {
          String nama;
          int harga; 
          int qty;

          Item(String nama, int harga, int qty) {
               this.nama = nama;
               this.harga = harga;
               this.qty = qty;
          }

          int getSubtotal() {
               return harga * qty;
          }
     }

     public static void PrintMenu() {
          System.out.println("============= My WarungKu =============");
          System.out.println("1. Nasi Goreng           | Rp. 15.000");
          System.out.println("2. Mie Goreng            | Rp. 12.000");
          System.out.println("3. Teh Manis             | Rp. 5.000");
          System.out.println("4. Kopi                  | Rp. 7.000");
          System.out.println("5. Air Mineral           | Rp. 3.000");
          System.out.println("Harga diatas belum termasuk pajak 10%");
          System.out.println("Pembelian lebih dari 200.000 dapat diskon 10%");
          System.out.println("========================================");
          System.out.println("[1] Pesan Makanan/Minuman");
          System.out.println("[2] Cetak Struk");
          System.out.println("[3] Keluar");
          System.out.print("Masukkan pilihan: ");
     }

     public static void PesanMakanan() {
          while (true) {
               System.out.print("Masukkan Nomor Makanan / Minuman (0 untuk selesai): ");
               int pilih = scanner.nextInt();

               if (pilih == 0) {
                    System.out.println("Selesai memesan. \n");
                    return;
               }

               String nama = "";
               int harga = 0;
               int qty;

               System.out.print("Masukkan jumlah yang diinginkan: ");
               while (true) {
               qty = scanner.nextInt();

                    if (qty <= 0) {
                         System.out.print("Jumlah tidak valid! Masukkan jumlah yang diinginkan: ");
                         qty = scanner.nextInt();
                    } else {
                         break;
                    }  
               }

               switch (pilih) {
                    case 1: nama = "Nasi Goreng"; harga = 15000; break;
                    case 2: nama = "Mie Goreng"; harga = 12000; break;
                    case 3: nama = "Teh Manis"; harga = 5000; break;
                    case 4: nama = "Kopi"; harga = 7000; break;
                    case 5: nama = "Air Mineral"; harga = 3000; break;
                    default:
                    System.out.println("Pilihan tidak valid!");
                    continue; 
               }

               if (jumlahPesanan < pesanan.length) {
                    boolean found = false;
                    for (int i = 0; i < jumlahPesanan; i++) {
                         if (pesanan[i].nama.equals(nama)) {
                              pesanan[i].qty += qty; 
                              found = true;
                              System.out.println(qty + "x " + nama + " ditambahkan (total sekarang: " + pesanan[i].qty + ")\n");
                              break;
                         }
                    }
                    if (!found) {
                         pesanan[jumlahPesanan] = new Item(nama, harga, qty);
                         jumlahPesanan++;
                         System.out.println(qty + "x " + nama + " berhasil ditambahkan ke pesanan!\n");
                    }
               } else {
                    System.out.println("Pesanan sudah penuh!\n");
               }
          }
     }

     public static void CetakStruk() {
          if (jumlahPesanan == 0) {
               System.out.println("Belum ada pesanan! \n");
               return;
          }

          System.out.println("\n=========== STRUK PEMBAYARAN ===========");
          int total = 0;
          for (int i = 0; i < jumlahPesanan; i++) {
               Item item = pesanan[i];
               int subtotal = item.getSubtotal();
               System.out.println(item.qty + "x " + item.nama + " - Rp. " + subtotal);
               total += subtotal;
          }

          double pajak = total * 0.10;
          double grandTotal = total + pajak;

          double diskon = 0;
          if (grandTotal > 200000) {
               diskon = grandTotal * 0.10;
               grandTotal -= diskon;
          }

          System.out.println("----------------------------------------");
          System.out.println("Total: Rp. " + total);
          System.out.println("Pajak (10%): Rp. " + pajak);
          if (diskon > 0) {
               System.out.println("Diskon (10%): -Rp. " + diskon);
          }
          System.out.println("Grand Total: Rp. " + grandTotal);
          System.out.println("======================================== \n");
     }

     public static void main(String[] args) {
          int pil;
          do {
               PrintMenu();
               pil = scanner.nextInt();
               switch (pil) {
                    case 1: PesanMakanan(); break;
                    case 2: 
                    CetakStruk(); 
                    jumlahPesanan = 0;
                    pesanan = new Item[100];
                    break;
                    case 3: System.out.println("Terima kasih, sampai jumpa!"); break;
                    default: System.out.println("Pilihan tidak tersedia"); break;
               }
          } while (pil != 3);

          scanner.close();
     }
}
