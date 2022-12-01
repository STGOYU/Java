package MiniBank;

import java.util.*;

public  class GirisEkrani extends Menu  {
    public static int musteriSayisi = 1;

    public static void giris() {

        List<Integer> hesapNolar = new ArrayList<>();
        hesapNolar.add(87785656);
        hesapNolar.add(66669999);
        hesapNolar.add(33336565);

        List<Integer> sifreler = new ArrayList<>();
        sifreler.add(1111);
        sifreler.add(2222);
        sifreler.add(3333);

        int sifre = 0;
        int hesapNo=0;
        double checkingBalance = 0;
        double savingBalance = 0;

        for (int i = 0; i < hesapNolar.size() ; i++) {
            hesapNo=hesapNolar.get(i);
            sifre=sifreler.get(i);
            HesapYonetimi yeniMusteri = new HesapYonetimi(hesapNo,checkingBalance,savingBalance,musteriSayisi);
            numbers.put(sifre,yeniMusteri);
            musteriSayisi++;
        }
        int a =4;
        boolean durum = true;
        do {
            System.out.println("1-YENI HESAP OLUSTUR\n" +
                    "2-ZATEN HESABIM VAR\n" +
                    "3-EXIT");
            System.out.print("Lutfen isleminizi seciniz : ");

            int kullanici = input.nextInt();

            switch (kullanici) {

                case 1:
                    yeniHesapOlustur();
                    break;
                case 2:
                    zatenHesabimVar();
                    break;
                default:
                    System.out.println("lutfen tekrar deneyiniz..");
                    if (sayacKontrol(a)==0 || kullanici==3) {
                        System.out.println("Isleminiz iptal edildi hoscakalin !");
                        durum=false;
                    }
                    break;
            }
            a--;
        }while(durum);
        cikis();
    }
    public static int yeniHesapNo() {
        int sayi = 0;
        Random rnd = new Random();
         sayi =10000000+ rnd.nextInt(90000000);

        return sayi;
    }

    public static void yeniHesapOlustur() {
        int a = 4;
        int sifre = 0;
        double checkingBalance =0;
        double savingBalance = 0;

        while(sayacKontrol(a)!=0) {

            System.out.println("lutfen 4 haneli bir sifre olusturunuz.");
            String al = input.next();
            try {
                sifre = Integer.valueOf(al);

            } catch (IllegalArgumentException e) {
                System.out.println("lutfen sifrenizi sadece rakam olmali..");
            }
            boolean uzunluk = sifre > 1000 && sifre < 10000;
            if (!uzunluk) {
                System.out.println("sifreniz 4 haneli olmalidir..");
            } else {
                System.out.println("Hosgeldiniz....");
                int hesapNo = yeniHesapNo();

                HesapYonetimi yeniMusteri = new HesapYonetimi(hesapNo, checkingBalance, savingBalance, musteriSayisi);
                numbers.put(sifre, yeniMusteri);
                System.out.println("Sifreniz kaydedildi ve musteri numaraniz olusturuldu");
                System.out.println("musteri numaraniz : " + hesapNo);
                System.out.println("sifreniz : " + sifre);
                musteriSayisi++;
                menum();
                break;
            }
            a--;

        }
        System.out.println("Hatali islem yaptiniz !");
    }

    public static void cikis() {
        System.out.println("Sistemden  çıkıs yaptınız. Gule gule...");
    }

    public GirisEkrani(){

    }


    public static Map<Integer, HesapYonetimi> getNumbers() {
        return numbers;
    }
}