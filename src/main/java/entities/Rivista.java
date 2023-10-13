package entities;

import entities.Enum.Periodicita;

public class Rivista extends Pubblicazioni {
    private Periodicita periodicita;

    public Rivista(String titolo, Integer annoDiPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        String pubblicazioni = super.toString();
        return pubblicazioni + " Rivista{" +
                " periodicita=" + periodicita +
                '}';
    }
}
