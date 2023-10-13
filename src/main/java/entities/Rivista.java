package entities;

import entities.Enum.Periodicita;

import java.time.LocalDate;

public class Rivista extends Pubblicazioni {
    private Periodicita periodicita;

    public Rivista(String titolo, Integer annoDiPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
