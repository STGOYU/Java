package Kitapci;

import java.text.DecimalFormat;

public class Kitapci {

    private String kitapAdi;
    private String kitapYazari;
    private double brutFiyati;
    private String seriNo;

    private int kitapMiktari;
    private String raf;

    public static DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private int sifre ;

    public Kitapci(int sifre){
        this.sifre=sifre;
    }

    public Kitapci(){

    }

    public Kitapci(String seriNo, String kitapAdi, String kitapYazari, double brutFiyati, int kitapMiktari, String raf){
        this.seriNo=seriNo;
        this.kitapAdi=kitapAdi;
        this.kitapYazari=kitapYazari;
        this.brutFiyati=brutFiyati;
        this.kitapMiktari=kitapMiktari;
        this.raf=raf;
    }
    public static int sayacKontrol(int sayac){
        sayac=sayac-1;

        return sayac;
    }

    public String getBrutFiyati() {
        return moneyFormat.format(brutFiyati);
    }

    public void setBrutFiyati(double brutFiyati) {
        this.brutFiyati = brutFiyati;
    }

    public void setKitapMiktari(int kitapMiktari) {
        this.kitapMiktari = kitapMiktari;
    }

    public int getKitapMiktari() {
        return kitapMiktari;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public void setSifre(int sifre) {
        this.sifre = sifre;
    }

    public int getSifre() {
        return sifre;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi.toLowerCase();
    }

    public String getKitapYazari() {
        return kitapYazari;
    }

    public void setKitapYazari(String kitapYazari) {
        this.kitapYazari = kitapYazari.toLowerCase();
    }


    public void setFiyati(double fiyati) {
        this.brutFiyati = fiyati;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    @Override
    public String toString() {
        return  " kitapAdi : " + kitapAdi + '\'' +
                " kitapYazari : " + kitapYazari + '\'' +
                " fiyati : " + brutFiyati +
                " seriNo : " + seriNo ;
    }
}
