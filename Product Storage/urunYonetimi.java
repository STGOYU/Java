package Depo;

public class urunYonetimi {

    private String urununIsmi;
    private String uretici;
    private String birim;
    private int urunMiktar;
    private String raf;


    public urunYonetimi(){


    }
    public urunYonetimi(String urununIsmi, String uretici, String birim, int urunMiktar, String raf){
        this.urununIsmi=urununIsmi;
        this.uretici=uretici;
        this.birim=birim;
        this.urunMiktar=urunMiktar;
        this.raf=raf;

    }

    public String getUrununIsmi() {
        return urununIsmi.toLowerCase();
    }

    public void setUrununIsmi(String urununIsmi) {
        this.urununIsmi = urununIsmi;
    }

    public String getUretici() {
        return uretici.toLowerCase();
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public String getBirim() {
        return birim.toLowerCase();
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public int getUrunMiktar() {
        return urunMiktar;
    }

    public int setUrunMiktar(int urunMiktar) {
        this.urunMiktar = urunMiktar;
        return urunMiktar;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "UrunYonetimi{" +
                "urununIsmi='" + urununIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", birim='" + birim + '\'' +
                ", urunMiktar=" + urunMiktar +
                ", raf='" + raf + '\'' +
                '}';
    }
}
