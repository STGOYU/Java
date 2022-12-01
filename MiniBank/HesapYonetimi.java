package MiniBank;

import java.text.DecimalFormat;
import java.util.Scanner;

import static MiniBank.Menu.menum;

public class HesapYonetimi {

    private int accountNumber;
    private int pinNumber;
    private static double checkingBalance; //vadesiz
    private static double savingBalance;  //vadeli
    static DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public static Scanner input = new Scanner(System.in);

    public HesapYonetimi(){

    }

    public HesapYonetimi(int pinNumber){
        this.pinNumber=pinNumber;

    }

    public HesapYonetimi(int accountNumber,double checkingBalance, double savingBalance,int musteriSayisi){
        this.accountNumber=accountNumber;
        this.checkingBalance=checkingBalance;
        this.savingBalance=savingBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    private static double calculateCheckingBalanceWithdraw(double amount){

        checkingBalance -= amount;

        return checkingBalance;
    }

    private static double calculateCheckingBalanceAfterDeposit(double amount){

        checkingBalance +=amount;

        return checkingBalance;

    }

    private static double calculateSavingBalanceAfterWithdraw(double amount){

        savingBalance-=amount;

        return savingBalance;
    }

    private static double calculateSavingBalanceAfterDeposit(double amount){

        savingBalance += amount;

        return savingBalance;
    }
    public static int sayacKontrol(int sayac){
        sayac=sayac-1;

        return sayac;
    }

    public static void getCheckingWithdraw() {
        int a =3;
        do {
            System.out.print("cekmek istediginiz miktari giriniz : ");
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("sifir veya eksi bakiyeler gecersizdir !");

            } else if (amount <= checkingBalance) {
                calculateCheckingBalanceWithdraw(amount);
                displayCurrentAmount(checkingBalance);

            } else if (sayacKontrol(a)==0) {
                System.out.println();
                break;
            } else {
                System.out.println("Yetersiz Bakiye");
            }
            a--;
        }while(true);

    }

    public static void getCheckingDeposit() {
        int a = 3;
        do {
            System.out.print("Yatirmak istediginiz miktari giriniz : ");
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("sifir veya eksi bakiyeler gecersizdir !");
            } else if (sayacKontrol(a)==0) {
                System.out.println();
                break;
            } else {
                calculateCheckingBalanceAfterDeposit(amount);
                System.out.println();
                displayCurrentAmount(checkingBalance);
            }
            a--;
        }while(true);

    }
    public static void getSavingWithdraw() {
        int a = 3;
        do {
            System.out.print("cekmek istediginiz miktari giriniz : ");
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("sifir veya eksi bakiyeler gecersizdir !");

            } else if (amount <= savingBalance) {
                calculateSavingBalanceAfterWithdraw(amount);
                displayCurrentAmount(savingBalance);
            } else if (sayacKontrol(a)==0) {
                System.out.println();
                break;
            } else {
                System.out.println("Yetersiz Bakiye");
            }
            a--;
        }while(true);

    }
    public static void getSavingDeposit() {
        int a = 3;
        do {
            System.out.print("Yatirmak istediginiz miktari giriniz : ");
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("sifir veya eksi bakiyeler gecersizdir !");
            } else if (sayacKontrol(a)==0) {
                System.out.println();
                break;
            } else {
                calculateSavingBalanceAfterDeposit(amount);
                System.out.println();
                displayCurrentAmount(savingBalance);
            }
            a--;
        }while(true);

    }
    public static void displayCurrentAmount(double balance){

        System.out.println("Hesabinizda bulunan guncel bakiye : "+moneyFormat.format(balance));
        menum();

    }

}
