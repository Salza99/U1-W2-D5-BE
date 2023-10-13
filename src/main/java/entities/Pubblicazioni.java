package entities;

import java.time.LocalDate;
import java.util.Random;

public abstract class Pubblicazioni {
    private Long isbn;
    private String titolo;
    private LocalDate annoDiPubblicazione;
    private Integer numeroPagine;

    public Pubblicazioni(String titolo, LocalDate annoDiPubblicazione, Integer numeroPagine) {
        this.isbn = new Random().nextLong(100, 5000);
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
}
