package entities;

import java.time.LocalDate;
import java.util.Random;

public abstract class Pubblicazioni {
    private Integer isbn;
    private String titolo;
    private Integer annoDiPubblicazione;
    private Integer numeroPagine;

    public Pubblicazioni(String titolo, Integer annoDiPubblicazione, Integer numeroPagine) {
        this.isbn = new Random().nextInt(100, 5000);
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
}
