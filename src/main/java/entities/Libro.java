package entities;

import java.time.LocalDate;

public class Libro extends Pubblicazioni{
    private String autore;
    private Generi genere;

    public Libro(String titolo, LocalDate annoDiPubblicazione, Integer numeroPagine, String autore, Generi genere) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}
