package entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public abstract class Pubblicazioni {
    private Long isbn;
    private String titolo;
    private Integer annoDiPubblicazione;
    private Integer numeroPagine;

    public Pubblicazioni(String titolo, Integer annoDiPubblicazione, Integer numeroPagine) {
        this.isbn = new Random().nextLong(100000000, 999999999);
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    //getter

    public Long getIsbn() {
        return isbn;
    }

    //to String
    @Override
    public String toString() {
        return
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pubblicazioni that = (Pubblicazioni) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(annoDiPubblicazione, that.annoDiPubblicazione);
    }


}
