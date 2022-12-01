package Kitapci;

import java.util.Scanner;

public class Control extends Menu {
    public static int [] password  = {1111};
    static Scanner input = new Scanner(System.in);
    public Control(){

    }

    public void giris(){
        System.out.println();
        System.out.println("=========== *** KITAPCI *** ============");

        System.out.println( "1- KITAP MENUSU\n" +
                "2- SIFRE GUNCELLEME\n" +
                "3- ARAMA\n" +
                "0- CIKIS");

        System.out.print("Lutfen isleminizi seciniz : ");
        String kullanici = input.next();

        switch (kullanici){

            case "1":
                menum();
                break;
            case "2":
                sifreGuncelleme();
                break;
            case "0":
                cikis();
                break;
            default:
                System.out.println("Hatali giris yaptiniz, Tekrar deneyiniz");
                break;
        }
    }
    public void control(){
        boolean durum =true;
        int a =3;
        int no = 0;
        do {
            System.out.println("Lutfen giris sifrenizi yaziniz ..");
            String al = input.next();

            try {
                no = Integer.valueOf(al);

            } catch (IllegalArgumentException e) {
                System.out.println("sifreniz sadece rakam olmali..");
            }
            if (no == password[0] )  {
                System.out.println("Hosgeldiniz !!!");
                giris();
                durum=false;
            }
            if (sayacKontrol(a)==0) {
                System.out.println("3 kez hatali islem yaptiniz tekrar deneyin !");
                break;
            }
            a--;
        }while(durum);
    }

    public void sifreGuncelleme(){
        System.out.println("lutfen eski sifrenizi giriniz");
        int sifre = input.nextInt();

        if (sifre == password[0] )  {
            System.out.println("lutfen yeni sifrenizi giriniz .");
            int no=can.nextInt();
            if(no<10000 && no >999){
                password[0]=no;
                System.out.println("Sifreniz basari ile guncellendi !!!");
                giris();
            }else{
                System.out.println("lutfen 4 haneli bir sifre giriniz");
            }
        }else {
            System.out.println("sifreniz guncellenemedi !");
            giris();
        }
    }

    public void cikis(){
        System.out.println("Sistemden cikis yaptiniz, HOSCAKALIN.. ");
    }
}
