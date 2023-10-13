package entities;

import entities.Enum.Generi;

import java.time.LocalDate;

public class Libro extends Pubblicazioni {
    private String autore;
    private Generi genere;

    public Libro(String titolo, Integer annoDiPubblicazione, Integer numeroPagine, String autore, Generi genere) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }


    @Override
    public String toString() {
        String pubblicazioni = super.toString();
        return pubblicazioni + " Libro{" +
                " autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
