package Kitapci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu extends Kitapci {
    static Scanner can = new Scanner(System.in);
    public static Map<Integer, Kitapci> kitapListesiMap = new HashMap<Integer, Kitapci>();

     public static   Set<Map.Entry<Integer, Kitapci>> kitaplar = kitapListesiMap.entrySet();

     static int siraNo=1;
     public Menu(){

    }
    public void menum(){
         boolean durum=true;
         int b = 3;
            do {
                System.out.println("=======KITAPCI YONETIMI============");

                System.out.println("1- TANIMLAMA\n" +
                        "2- LİSTELE\n" +
                        "3- EKLE\n" +
                        "4- RAFA KOY\n" +
                        "5- SATIS\n" +
                        "6- SILME\n" +
                        "7- ARAMA\n" +
                        "0- BACK");

                System.out.print("Lutfen isleminizi seciniz : ");
                String kullanici = can.next();

                switch (kullanici) {

                    case "1":
                        kitapTanimlama();
                        break;
                    case "2":
                        kitapListele();
                        menum();
                        break;
                    case "3":
                        kitapEkle();
                        break;
                    case "4":
                        rafaKoy();
                        break;
                    case "5":
                        kitapSatisi();
                        break;
                    case "6":
                        kitapSilme();
                        break;
                    case "7":
                        arama();
                        break;
                    default:
                        System.out.println("AUF WEIDERSEHEN");
                        if (sayacKontrol(b)==0 || kullanici.equals("0")) {
                            System.out.println("Ana menu YUKLENIYOR....");
                            durum=false;
                        }
                        break;
                }
                b--;
                kitapListele();

            }while(durum);
        Control a = new Control();
        a.giris();

    }
    public void arama(){
        Scanner scan = new Scanner(System.in);

        System.out.println("lutfen aramak istediginiz kitabin adini giriniz..");
        String suchen=scan.nextLine().toUpperCase();

        for(Map.Entry<Integer, Kitapci> w:kitaplar) {
          Integer key = w.getKey();
            if(kitapListesiMap.get(w.getKey()).getKitapAdi().equals(suchen)){
                System.out.println("kitabinizin fiyati : "+kitapListesiMap.get(key).getBrutFiyati());
                System.out.println("kitabinizin miktari : "+kitapListesiMap.get(key).getKitapMiktari());

            }else{
                System.out.println("IT WAS NOT FOUND !");
            }
        }

    }
    private void kitapSilme() {

        Scanner ap = new Scanner(System.in);
        System.out.println("silmek istediginiz stok un sira numarasini yaziniz :");
        int sira = ap.nextInt();

        if(kitapListesiMap.keySet().contains(sira)){
            kitapListesiMap.remove(sira);
        }else {
            System.out.println("aradiginiz sira yoktur. !");
        }

    }

    private void kitapSatisi() {
        Scanner ab = new Scanner(System.in);
        System.out.println("cikis yapmak istediginiz kitabin sirasini giriniz:");
        int sira = ab.nextInt();

        if(kitapListesiMap.keySet().contains(sira)){
            System.out.println("miktarini giriniz..");

            int guncelMiktar =ab.nextInt();

            kitapListesiMap.get(sira).setKitapMiktari(kitapListesiMap.get(sira).getKitapMiktari()-guncelMiktar);
        }else {
            System.out.println("aradiginiz urun yoktur. !");
        }
    }

    private void rafaKoy() {
        System.out.println("rafa yerlestirmek istediginiz urunun sirasini giriniz : ");
        int sira = can.nextInt();

        if(kitapListesiMap.keySet().contains(sira)){
            System.out.println("hangi rafa kaldiracaginizi yaziniz ..");
            String guncelraf = can.next().toUpperCase();
            kitapListesiMap.get(sira).setRaf(guncelraf);

        }else{
            System.out.println("lutfen sira numarasini dogru giriniz..");

        }


    }

    private void kitapEkle() {
        Scanner as= new Scanner(System.in);
        System.out.println("eklemek istediginiz kitabin sirasini giriniz:");
        int sira = as.nextInt();

        if(kitapListesiMap.keySet().contains(sira)){
            System.out.println("ekleyeceginiz miktari giriniz..");

            int guncelMiktar =as.nextInt();

            kitapListesiMap.get(sira).setKitapMiktari(guncelMiktar+kitapListesiMap.get(sira).getKitapMiktari());
        }else {
            System.out.println("aradiginiz urun yoktur. !");

        }

    }

    private void kitapListele() {

        System.out.println("-------------------------   LIST OF BOOKS   --------------------------------------\n");
        System.out.println("sira       seri         kitapAdi         yazar       fiyat      miktar        raf" +
                "\n------------------------------------------------------------------------------------");

        for(Map.Entry<Integer, Kitapci> w:kitaplar){
            Integer key = w.getKey();
            System.out.printf("%-8d %-15s %-15s %-12s %-12s %-11d %-8s\n", key, kitapListesiMap.get(key).getSeriNo(),
                    kitapListesiMap.get(key).getKitapAdi(), kitapListesiMap.get(key).getKitapYazari(),
                    kitapListesiMap.get(key).getBrutFiyati(),kitapListesiMap.get(key).getKitapMiktari(), kitapListesiMap.get(key).getRaf());
        }

    }

    public void kitapTanimlama(){
        Scanner scan =new Scanner(System.in);
        System.out.println("lutfen kitap ismini giriniz : ");
        String kitapAdi = scan.nextLine().toUpperCase();
        System.out.println("kitabin yazarini giriniz : ");
        String kitapYazari = scan.nextLine().toUpperCase();

        String yil="2023";
        String seriNo=siraNo+yil+kitapAdi.substring(0,2)+kitapYazari.substring(0,2);

        System.out.println("Brut fiyatini giriniz : ");
        double brutFiyati = scan.nextDouble();

        int kitapMiktar = 0 ;
        String raf = " - ";

        Kitapci urun = new Kitapci(seriNo,kitapAdi,kitapYazari,brutFiyati,kitapMiktar,raf);
        kitapListesiMap.put(siraNo,urun);

        System.out.println("kitabiniz tanimlandi seri Numarasi olusturuldu : "+seriNo);
        siraNo++;

    }
}
