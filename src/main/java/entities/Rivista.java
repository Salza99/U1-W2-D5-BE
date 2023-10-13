package entities;

import java.time.LocalDate;

public class Rivista extends Pubblicazioni{
    private Periodicita periodicita;

    public Rivista(String titolo, LocalDate annoDiPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
