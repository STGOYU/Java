package MiniBank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static MiniBank.GirisEkrani.giris;

public class Menu extends HesapYonetimi {
    public static Map<Integer, HesapYonetimi> numbers = new HashMap<>();

    public static Set<Map.Entry<Integer, HesapYonetimi>> musteriListesi = numbers.entrySet();

    public static void menum() {

        System.out.println("1- Checking Balance View \n2- Saving Balance View \n3- Checking Withdraw \n4- Checking Deposit \n5- Saving Withdraw \n6- Saving Deposit\n0-Back");

        System.out.print("Lutfen isleminizi seciniz : ");
        int kullanici = input.nextInt();

        switch (kullanici) {

            case 1:
                checkingView();
                break;
            case 2:
                savingView();
                break;
            case 3:
               getCheckingWithdraw();
                break;
            case 4:
                getCheckingDeposit();
                break;
            case 5:
                getSavingWithdraw();
                break;
            case 6:
                getSavingDeposit();
                break;
            case 0:
                giris();
                break;
            default:
                System.out.println("Hatali giris yaptiniz, Tekrar deneyiniz");
                giris();
                break;
        }

    }
    private static void savingView() {
        System.out.println("lutfen sifrenizi giriniz : ");
        int no = input.nextInt();

        if(numbers.keySet().contains(no)){
            System.out.println("your checking balance : "+moneyFormat.format(numbers.get(no).getSavingBalance()));
            menum();
        }else{
            System.out.println("Hatali tuslama yaptiniz ");
            giris();
        }
    }

    private static void checkingView() {

        System.out.println("lutfen sifrenizi giriniz : ");
        int no = input.nextInt();

        if(numbers.keySet().contains(no)){
            System.out.println("your checking balance : "+moneyFormat.format(numbers.get(no).getCheckingBalance()));
            menum();
        }else{
            System.out.println("Hatali tuslama yaptiniz ");
            giris();
        }
    }
    public static void zatenHesabimVar(){
        int a =3;
        int no=0;
        do {
            System.out.println("Lutfen sifrenizi giriniz ..");
            String al = input.next();

            try {
                no = Integer.valueOf(al);

            } catch (IllegalArgumentException e) {
                System.out.println("sifreniz sadece rakam olmali..");
            }

            for (Map.Entry<Integer, HesapYonetimi> w : musteriListesi) {
                Integer sifre = w.getKey();

                if (no == sifre) {
                    System.out.println("Hosgeldiniz !!!");
                    menum();
                }
            }
            if (sayacKontrol(a)==0) {
                System.out.println("3 kez hatali islem yaptiniz tekrar deneyin !");
                break;
            }
            a--;
        }while(true);

    }
}

