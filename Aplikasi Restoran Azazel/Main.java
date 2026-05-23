import java.util.Scanner;

public class Main {

static Scanner input = new Scanner(System.in);

static Menu[] daftarMenu = new Menu[100];
static int jumlahMenu = 0;

static String[] namaPesanan = new String[100];
static int[] jumlahPesanan = new int[100];
static int[] subtotalPesanan = new int[100];

static int totalPesanan = 0;

public static void main(String[] args) {

tambahMenuAwal();

int pilih;

do{

System.out.println("\n=========== Aplikasi Restoran AzazeL ===========");
System.out.println("1. Menu Pelanggan");
System.out.println("2. Manajemen Menu");
System.out.println("3. Keluar");
System.out.print("Pilih Menu : ");

pilih = input.nextInt();
input.nextLine();

switch(pilih){

case 1:
menuPelanggan();
break;

case 2:
menuManajemen();
break;

case 3:
System.out.println("Program selesai");
break;

default:
System.out.println("Pilihan tidak tersedia");

}

}while(pilih != 3);

}

static void tambahMenuAwal(){

daftarMenu[jumlahMenu++] =
new Menu("Tteokbokki","Makanan",28000);

daftarMenu[jumlahMenu++] =
new Menu("Kimchi Fried Rice","Makanan",35000);

daftarMenu[jumlahMenu++] =
new Menu("Bulgogi","Makanan",45000);

daftarMenu[jumlahMenu++] =
new Menu("Ramyeon","Makanan",30000);

daftarMenu[jumlahMenu++] =
new Menu("Bibimbap","Makanan",40000);

daftarMenu[jumlahMenu++] =
new Menu("Banana Milk","Minuman",18000);

daftarMenu[jumlahMenu++] =
new Menu("Korean Strawberry Milk","Minuman",22000);

daftarMenu[jumlahMenu++] =
new Menu("Yuja Tea","Minuman",20000);

daftarMenu[jumlahMenu++] =
new Menu("Dalgona Coffee","Minuman",25000);

}

static void tampilkanMenu(){

System.out.println("\n========== MENU MAKANAN ==========");

for(int i=0;i<jumlahMenu;i++){

if(daftarMenu[i].kategori.equalsIgnoreCase("Makanan")){

System.out.println(
(i+1)+". "+
daftarMenu[i].nama+
" - Rp "+daftarMenu[i].harga
);

}

}

System.out.println("\n========== MENU MINUMAN ==========");

for(int i=0;i<jumlahMenu;i++){

if(daftarMenu[i].kategori.equalsIgnoreCase("Minuman")){

System.out.println(
(i+1)+". "+
daftarMenu[i].nama+
" - Rp "+daftarMenu[i].harga
);

}

}

}

static void menuPelanggan(){

totalPesanan = 0;

tampilkanMenu();

while(true){

System.out.print(
"\nMasukkan nama menu (ketik selesai) : "
);

String menuInput = input.nextLine();

if(menuInput.equalsIgnoreCase("selesai")){

break;

}

boolean ditemukan = false;

for(int i=0;i<jumlahMenu;i++){

if(daftarMenu[i].nama.equalsIgnoreCase(menuInput)){

ditemukan = true;

System.out.print("Jumlah Pesanan : ");
int jumlah = input.nextInt();
input.nextLine();

namaPesanan[totalPesanan] =
daftarMenu[i].nama;

jumlahPesanan[totalPesanan] = jumlah;

subtotalPesanan[totalPesanan] =
jumlah * daftarMenu[i].harga;

totalPesanan++;

System.out.println(
"Pesanan berhasil ditambahkan"
);

}

}

if(!ditemukan){

System.out.println(
"Menu tidak tersedia, silakan input lagi"
);

}

}

hitungTotal();

}

static void hitungTotal(){

int total = 0;

System.out.println("\n========== STRUK PEMBAYARAN ==========");

for(int i=0;i<totalPesanan;i++){

System.out.println(

namaPesanan[i]+
" x "+
jumlahPesanan[i]+
" = Rp "+
subtotalPesanan[i]

);

total += subtotalPesanan[i];

}

int diskon = 0;

if(total > 100000){

diskon = total * 10 / 100;

}

int setelahDiskon = total - diskon;

int pajak = setelahDiskon * 10 / 100;

int pelayanan = 20000;

int totalBayar =
setelahDiskon +
pajak +
pelayanan;

if(total > 50000){

System.out.println(
"Promo : Beli 1 Gratis 1 Minuman"
);

}

System.out.println("----------------------------------");
System.out.println("Total Pesanan : Rp "+total);
System.out.println("Diskon : Rp "+diskon);
System.out.println("Pajak 10% : Rp "+pajak);
System.out.println("Biaya Pelayanan : Rp "+pelayanan);
System.out.println("Total Bayar : Rp "+totalBayar);

}

static void menuManajemen(){

int pilih;

do{

System.out.println("\n========== MANAJEMEN MENU ==========");
System.out.println("1. Tambah Menu");
System.out.println("2. Ubah Harga");
System.out.println("3. Hapus Menu");
System.out.println("4. Lihat Menu");
System.out.println("5. Kembali");

System.out.print("Pilih : ");

pilih = input.nextInt();
input.nextLine();

switch(pilih){

case 1:
tambahMenuBaru();
break;

case 2:
ubahHarga();
break;

case 3:
hapusMenu();
break;

case 4:
tampilkanMenu();
break;

case 5:
break;

default:
System.out.println("Pilihan tidak ada");

}

}while(pilih != 5);

}

static void tambahMenuBaru(){

System.out.print(
"Berapa menu yang ingin ditambahkan : "
);

int banyak = input.nextInt();
input.nextLine();

for(int i=0;i<banyak;i++){

System.out.print("Nama Menu : ");
String nama = input.nextLine();

System.out.print("Kategori : ");
String kategori = input.nextLine();

System.out.print("Harga : ");
int harga = input.nextInt();
input.nextLine();

daftarMenu[jumlahMenu++] =
new Menu(nama,kategori,harga);

}

System.out.println("Menu berhasil ditambahkan");

}

static void ubahHarga(){

tampilkanMenu();

System.out.print(
"Masukkan nomor menu yang ingin diubah : "
);

int nomor = input.nextInt();
input.nextLine();

if(nomor >=1 && nomor <= jumlahMenu){

System.out.print(
"Yakin ingin mengubah? (Ya/Tidak) : "
);

String konfirmasi = input.nextLine();

if(konfirmasi.equalsIgnoreCase("Ya")){

System.out.print("Masukkan harga baru : ");

int hargaBaru = input.nextInt();
input.nextLine();

daftarMenu[nomor-1].harga = hargaBaru;

System.out.println("Harga berhasil diubah");

}

}else{

System.out.println("Nomor menu tidak valid");

}

}

static void hapusMenu(){

tampilkanMenu();

System.out.print(
"Masukkan nomor menu yang ingin dihapus : "
);

int nomor = input.nextInt();
input.nextLine();

if(nomor >=1 && nomor <= jumlahMenu){

System.out.print(
"Yakin ingin menghapus? (Ya/Tidak) : "
);

String konfirmasi = input.nextLine();

if(konfirmasi.equalsIgnoreCase("Ya")){

for(int i=nomor-1;i<jumlahMenu-1;i++){

daftarMenu[i] = daftarMenu[i+1];

}

jumlahMenu--;

System.out.println("Menu berhasil dihapus");

}

}else{

System.out.println("Nomor menu tidak valid");

}

}

}
