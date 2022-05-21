package superball;

public class Donto {
    private String sorszam;
    private String datum;
    private String gyoztes;
    private String eredmeny;
    private String vesztes;
    private String helyszin;
    private String varosAllam;
    private int nezoszam;

    public Donto() {
    }

    public Donto(String csvSor) {
        String[] adatok = csvSor.split(";");
        this.sorszam = adatok[0];
        this.datum = adatok[1];
        this.gyoztes = adatok[2];
        this.eredmeny = adatok[3];
        this.vesztes = adatok[4];
        this.helyszin = adatok[5];
        this.varosAllam = adatok[6];
        this.nezoszam = Integer.parseInt(adatok[7]);
    }

    public String getSorszam() {
        return sorszam;
    }

    public void setSorszam(String sorszam) {
        this.sorszam = sorszam;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getGyoztes() {
        return gyoztes;
    }

    public void setGyoztes(String gyoztes) {
        this.gyoztes = gyoztes;
    }

    public String getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(String eredmeny) {
        this.eredmeny = eredmeny;
    }

    public int getSzerzett() {
        // szebb megoldás lett volna kapásból a konstruktorban így eltárolni
        return Integer.parseInt(eredmeny.split("-")[0]);
    }

    public int getKapott() {
        // szebb megoldás lett volna kapásból a konstruktorban így eltárolni
        return Integer.parseInt(eredmeny.split("-")[1]);
    }

    public String getVesztes() {
        return vesztes;
    }

    public void setVesztes(String vesztes) {
        this.vesztes = vesztes;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public String getVarosAllam() {
        return varosAllam;
    }

    public void setVarosAllam(String varosAllam) {
        this.varosAllam = varosAllam;
    }

    public int getNezoszam() {
        return nezoszam;
    }

    public void setNezoszam(int nezoszam) {
        this.nezoszam = nezoszam;
    }
}
