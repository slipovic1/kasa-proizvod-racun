package ba.unsa.etf.rpr;

import java.util.Objects;

public class Proizvod {
    private String barKod;
    private String naziv;
    private double cijena;

    public Proizvod() {
    }

    public Proizvod(String barKod, String naziv, double cijena) throws NeispravanFormatException {
        provjeriBarKod(barKod);
        this.barKod = barKod;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    private static void provjeriBarKod(String barKod) throws NeispravanFormatException {
        if (!(barKod.length() == 13)){
            throw new NeispravanFormatException("Bar kod treba imati 13 cifara");
        }

        for(char c: barKod.toCharArray()){
            if(!Character.isDigit(c)){
                throw new NeispravanFormatException("Bar kod treba imati 13 cifara");
            }
        }
    }

    public String getBarKod() {
        return barKod;
    }

    public void setBarKod(String barKod) throws NeispravanFormatException {
        provjeriBarKod(barKod);
        this.barKod = barKod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proizvod proizvod = (Proizvod) o;
        return Objects.equals(barKod, proizvod.barKod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barKod, naziv, cijena);
    }
}
