import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Deklarasi objek pada menu makanan
class Makanan {
    String namaMakanan;
    int hargaMakanan;
    
    Makanan(String namaMakanan,  int hargaMakanan){
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
    }
}

//Deklarasi objek pada menu minuman
class Minuman {
    String namaMinuman;
    int hargaMinuman;
    
    Minuman(String namaMinuman,  int hargaMinuman){
        this.namaMinuman = namaMinuman;
        this.hargaMinuman = hargaMinuman;
    }
}

//Deklarasi objek untuk menyimpan data pada menu
class Order {
    String namaOrder;
    int hargaOrder;
    int jumlahOrder;
    
    Order(String namaOrder,  int hargaOrder,  int jumlahOrder) {
        this.namaOrder = namaOrder;
        this.hargaOrder = hargaOrder;
        this.jumlahOrder = jumlahOrder;
    }
}

public class Main
{
    private int choice;
    Scanner input = new Scanner(System.in);

    public static ArrayList<Makanan> dataMakanan = new ArrayList<Makanan>();
    public static ArrayList<Minuman> dataMinuman = new ArrayList<Minuman>();
    public static ArrayList<Order>   dataOrder = new ArrayList<Order>();


    public int getMenus(){
        System.out.println("\n*****Menu Rumah Makan Bahari*****");
        System.out.println("1. Menu Makanan");
        System.out.println("2. Menu Minuman");
        System.out.println("3. Lihat Pesanan");
        System.out.println("4. Hapus Pesanan");
        System.out.println("5. Exit");
        System.out.print("Masukan Pilihan Menu : ");
        this.choice = input.nextInt();
        return this.choice;
    }

  public int getChoice(int choice) {
        switch(choice){
            case 1 : menuMakanan(); break;
            case 2 : menuMinuman(); break;
            case 3 : viewOrder(); break;
            case 4 : delOrder(); break;
            case 5 : System.out.println("****Terima kasih****"); break;
            default: 
                    System.out.println("Menu Tidak Tersedia \n");
                    input.nextLine();
                    getChoice(getMenus()); 
            break;
    }
    return choice;
}

public void menuMakanan(){
    char confirmSts;
	int pilih,jumlah;
    do{ 
        System.out.println("\nMenu Makanan");
	
        for(int i=0; i < dataMakanan.size(); i++) {
            System.out.println((i+1) +". "+ dataMakanan.get(i).namaMakanan + " " + dataMakanan.get(i).hargaMakanan);
        }

        System.out.print("Masukan Pilihan : ");
        pilih = input.nextInt();

        System.out.print("Jumlah          : ");
        jumlah = input.nextInt();

        System.out.print("\nApakah anda yakin dengan pesanan anda? [Y/N] ");
        confirmSts = input.next().charAt(0);
    
        //Confirm ststus
        if(Character.toUpperCase(confirmSts) == 'Y'){
            saveOrder('1',pilih,jumlah);
        } 
    } while (Character.toUpperCase(confirmSts) != 'Y');

    getChoice(getMenus());
}

public void menuMinuman(){
    char confirmSts;
	int pilih,jumlah;
    do{ 
        System.out.println("\nMenu Minuman");
	        
        for(int i=0; i < dataMinuman.size(); i++) {
          System.out.println((i+1) +". "+ dataMinuman.get(i).namaMinuman + " " + dataMinuman.get(i).hargaMinuman);
        }

        System.out.print("Masukan Pilihan : ");
        pilih = input.nextInt();

        System.out.print("Jumlah          : ");
        jumlah = input.nextInt();

        System.out.print("\nApakah anda yakin dengan pesanan anda? [Y/N] ");
        confirmSts = input.next().charAt(0);
    
        //Confirm ststus
        if(Character.toUpperCase(confirmSts) == 'Y'){
            saveOrder('2',pilih,jumlah);
        } 
  } while (Character.toUpperCase(confirmSts) != 'Y');

  getChoice(getMenus());
}

public void viewOrder(){
  char confirmSts;
  List<Character> opsi = Arrays.asList('T','H','U','C');

  do {
    System.out.println("Daftar Pesanan");
	
  for(int i=0; i < dataOrder.size(); i++) {
    System.out.println((i+1) +". "+ dataOrder.get(i).namaOrder + " " + dataOrder.get(i).hargaOrder + " " + dataOrder.get(i).jumlahOrder);
    }
  
    System.out.print("\nApa ingin Tambah[T]/Ubah[U]/Hapus[H]/Check Out[C]?");
    confirmSts = input.next().charAt(0);

    if(Character.toUpperCase(confirmSts) == 'C'){
      checkOut();
    } else if(Character.toUpperCase(confirmSts) == 'H'){
      delOrder();
    } else if(Character.toUpperCase(confirmSts) == 'T'){
      getChoice(getMenus());
    }else if(Character.toUpperCase(confirmSts) == 'U'){
      ubahOrder();
    }
    
  } while (!opsi.contains(Character.toUpperCase(confirmSts)));
  // while (Character.toUpperCase(confirmSts) != 'A');
}

public void delOrder(){
  char confirmSts;
  int pilih;

  System.out.println("\nHapus Pesanan");

  for(int i=0; i < dataOrder.size(); i++) {
    System.out.println((i+1) +". "+ dataOrder.get(i).namaOrder + " " + dataOrder.get(i).hargaOrder + " " + dataOrder.get(i).jumlahOrder);
  }
  System.out.print("Masukan Pilihan : ");
  pilih = input.nextInt();

  System.out.print("\nApakah Anda Yakin? [Y/N]");
  confirmSts = input.next().charAt(0);
  if(Character.toUpperCase(confirmSts) == 'Y'){
    saveOrder('3', pilih, 0);
    System.out.println("Pesanan Telah Dihapus");
  }

  getChoice(getMenus());

}
public void ubahOrder(){
  char confirmSts;
  int pilih;
  int jml;

  System.out.println("\nUbah Pesanan");

  for(int i=0; i < dataOrder.size(); i++) {
    System.out.println((i+1) +". "+ dataOrder.get(i).namaOrder + " " + dataOrder.get(i).hargaOrder + " " + dataOrder.get(i).jumlahOrder);
  }
  System.out.print("Masukan Pilihan : ");
  pilih = input.nextInt();
  System.out.print("Masukan Jumlah : ");
  jml = input.nextInt();

  System.out.print("\nApakah Anda Yakin? [Y/N]");
  confirmSts = input.next().charAt(0);
  if(Character.toUpperCase(confirmSts) == 'Y'){
    saveOrder('4', pilih, jml);
    System.out.println("Pesanan Telah Diubah");
  }

  getChoice(getMenus());

}
public void checkOut(){
  System.out.println("Halaman Check Out");
	int total = 0, bayar;

  for(int i=0; i < dataOrder.size(); i++) {
    System.out.println((i+1) +". "+ dataOrder.get(i).namaOrder + " " + dataOrder.get(i).hargaOrder + " " + dataOrder.get(i).jumlahOrder);
    total += dataOrder.get(i).hargaOrder * dataOrder.get(i).jumlahOrder;
  }

  System.out.println("Total Pesanan Anda "+total);
  
  do {
    System.out.print("Masukan Pembayaran Anda: ");
    bayar = input.nextInt();
    if(bayar < total){
      System.out.println("Pembayaran Anda Kurang");
    }
  } while( bayar < total );

  int kembalian = bayar - total;
  System.out.println("Kembalian Pembayaran Anda: "+kembalian);
  System.out.println("\n***Terima Kasih***");
}

	public static void main(String[] args) {
	    initMenu();
	    
      Main app = new Main();
      app.getChoice(app.getMenus());

	}
	
	public static void initMenu(){
	  dataMakanan.add(new Makanan("Nasi Goreng", 15000));
		dataMakanan.add(new Makanan("Pecel Ayam", 20000));
		dataMakanan.add(new Makanan("Soto Ayam", 18000));

		dataMinuman.add(new Minuman("Es Teh Manis", 7000));
		dataMinuman.add(new Minuman("Teh Manis Hangat", 5000));
		dataMinuman.add(new Minuman("Es Kopi", 10000));
	}
	
	public static void saveOrder(char menuId,int pilih,int jumlah){
    String namaOrder;
    int hargaOrder;
    int jumlahOrder;
    int i = pilih - 1;

    switch (menuId) {
      case '1':
        namaOrder = dataMakanan.get(i).namaMakanan;
        hargaOrder = dataMakanan.get(i).hargaMakanan;
        dataOrder.add(new Order(namaOrder, hargaOrder, jumlah));
        break;
      case '2':
        namaOrder = dataMinuman.get(i).namaMinuman;
        hargaOrder = dataMinuman.get(i).hargaMinuman;
        dataOrder.add(new Order(namaOrder, hargaOrder, jumlah));
        break;
      case '3':
        dataOrder.remove(i);
        break;
      case '4':
        namaOrder = dataOrder.get(i).namaOrder;
        hargaOrder = dataOrder.get(i).hargaOrder;
        jumlahOrder = dataOrder.get(i).jumlahOrder;
        dataOrder.get(i).jumlahOrder = jumlah;
        break;
      default:
        break;
    }
	}
}
