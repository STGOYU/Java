package Depo;

import java.util.*;

public class depoYonetimi {

    static Scanner scan = new Scanner(System.in);
    public static Map<Integer, urunYonetimi> urunListesiMap = new HashMap<Integer, urunYonetimi>();
    public static int urunId = 9000;


    public static void girisPaneli(){

        System.out.println("=======DEPO YONETIMI============");

        System.out.println( "1- BULUNDURULACAK URUN TANIMLAMA\n2- URUN LİSTELE\n3- DEPOYA URUN GİRİSİ\n4- URUNU RAFA KOY\n5- DEPODAN URUN CIKIŞI\n6- DEPO SİSTEMİNDEN CIKIS");
        System.out.print("Lutfen isleminizi seciniz : ");
        String kullanici = scan.next();

        switch (kullanici){

            case "1":
                urunTanimla();
                girisPaneli();
                break;
            case "2":
                urunListele();
                girisPaneli();
                break;
            case "3":
                urunListele();
                urunGirisi();
                girisPaneli();
                break;
            case "4":
                urunuRafaKoy();
                urunListele();
                girisPaneli();
                break;
            case "5":
                urunListele();
                urunCikisi();
                girisPaneli();
                break;
            case "6":
                cikis();
                break;
            default:
                System.out.println("Hatali giris yaptiniz, Tekrar deneyiniz");
                break;
        }
    }

    private static void urunTanimla() {

        System.out.println("lutfen urun ismini giriniz : ");
        scan.nextLine();
        String urunIsmi = scan.nextLine();

        System.out.println("uretici adi giriniz : ");
        String uretici = scan.nextLine();

        System.out.println("birimini giriniz : ");
        String birim = scan.nextLine();

        int urunMiktar = 0 ;
        String raf = " - ";

        urunYonetimi urun = new urunYonetimi(urunIsmi,uretici,birim,urunMiktar,raf);
        urunListesiMap.put(urunId,urun);
        System.out.println("urununuz tanimlandi ID'si verildi : "+urunId);
        urunId++;

    }

    private static void urunListele(){

        Set<Map.Entry<Integer, urunYonetimi>> urunListesi = urunListesiMap.entrySet();
        System.out.println("-------------------------LIST OF PRODUCTS---------------------------------\n");
        System.out.println("id       ismi         ureticisi       birim       miktar         raf" +
                "\n----------------------------------------------------------------------");

        for(Map.Entry<Integer, urunYonetimi> w:urunListesi){
            Integer key = w.getKey();
            System.out.printf("%-8d %-12s %-15s %-12s %-12d %-9s\n", key, urunListesiMap.get(key).getUrununIsmi(),
                    urunListesiMap.get(key).getUretici(), urunListesiMap.get(key).getBirim(),
                    urunListesiMap.get(key).getUrunMiktar(), urunListesiMap.get(key).getRaf());
        }
    }

    private static void urunGirisi(){

        System.out.println("eklemek istediginiz urun id si giriniz:");
        int sira = scan.nextInt();

        if(urunListesiMap.keySet().contains(sira)){
            System.out.println("ekleyeceginiz miktari giriniz..");

            int guncelMiktar = 0;
            boolean sayac = true;

            do{

                try {

                    guncelMiktar=scan.nextInt();


                }catch (InputMismatchException e){
                    System.out.println("lutfen gecerli miktar girisi yapiniz..");
                    sayac=false;
                }

            }while(sayac);

            urunListesiMap.get(sira).setUrunMiktar(guncelMiktar+urunListesiMap.get(sira).getUrunMiktar());
            System.out.println("urun miktarınız güncel hale getirildi\n depo durumu : " + urunListesiMap.get(sira).getUrunMiktar());
        }else {
            System.out.println("aradiginiz urun yoktur.!");
            urunGirisi();
        }

    }
    private static void urunuRafaKoy(){
        System.out.println("rafa yerlestirmek istediginiz urunun ID'sini giriniz : ");
        int sira = scan.nextInt();

        if(urunListesiMap.keySet().contains(sira)){
            System.out.println("hangi rafa kaldiracaginizi yaziniz ..");
            String guncelraf = scan.next();

            urunListesiMap.get(sira).setRaf(guncelraf);

        }else{
            System.out.println("lutfen sira numarasini dogru giriniz..");
            urunuRafaKoy();
        }
    }

    private static void urunCikisi(){
        System.out.println("cikisini yapmak istediginiz urunun ID'sini giriniz..");
        int sira = scan.nextInt();


        if (urunListesiMap.keySet().contains(sira)) {
            System.out.println("miktar giriniz");
            int guncelmiktar = 0;
            boolean durum = true;
            do {
                try {

                    guncelmiktar = scan.nextInt();


                } catch (InputMismatchException e) {
                    System.out.println("lütfen geçerli bir tamsayı giriniz");
                    durum = false;
                }
            } while (durum);

            if ( urunListesiMap.get(sira).getUrunMiktar() - guncelmiktar < 0) {
                System.out.println("deponuzda bu miktarda urun yoktur.\n bulunan miktar: " + urunListesiMap.get(sira).getUrunMiktar());
            } else {
                urunListesiMap.get(sira).setUrunMiktar( urunListesiMap.get(sira).getUrunMiktar() - guncelmiktar);
                System.out.println("urun miktarınız guncel hale getirildi\n guncel miktar: " + urunListesiMap.get(sira).getUrunMiktar());
            }

        } else {
            System.out.println("aradıgınız urun yoktur");
        }
    }


    private static void cikis() {
        System.out.println(" depo dan çıkıs yaptınız. Gule gule...");
    }
}
