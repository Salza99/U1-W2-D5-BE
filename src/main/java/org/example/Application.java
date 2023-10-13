package org.example;

import entities.Enum.Generi;
import entities.Enum.Periodicita;
import entities.Exception.YearValidationException;
import entities.Libro;
import entities.Pubblicazioni;
import entities.Rivista;

import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

public class Application {
    public static List<Pubblicazioni> libreria = new ArrayList<>();
    public static void main(String[] args) {
        // creo una piccola libreria
        Libro storia = new Libro("Le grandi battaglie di Roma", 1997, 500, "Piero Angela", Generi.STORIA);
        Libro letteratura = new Libro("Sussidiario Italiano", 1957, 1346, "Accademia della Crusca", Generi.LETTERATURA);
        Libro horror = new Libro("Sono il Conte Draculaaaa", 2001, 245,"Aldo Baglio", Generi.HORROR);
        Libro fantasy = new Libro("Il trono di Spade", 1996, 840, "George Raymond Richard Martin", Generi.FANTASY);
        Libro biografia = new Libro("Elon Musk", 2023, 780, "Elon Musk", Generi.BIOGRAFIA);
        Rivista settimanale = new Rivista("Focus", 1992, 76, Periodicita.SETTIMANALE);
        Rivista mensile = new Rivista("Donna Moderna", 1988, 47, Periodicita.MENSILE);
        Rivista semestrale = new Rivista("Stato e Mercato", 1976, 62, Periodicita.SEMESTRALE);
        // aggiungo alla libreria
        libreria.add(storia);
        libreria.add(letteratura);
        libreria.add(horror);
        libreria.add(fantasy);
        libreria.add(biografia);
        libreria.add(semestrale);
        libreria.add(settimanale);
        libreria.add(mensile);

        Scanner input = new Scanner(System.in);
        boolean open = true;
        while (open) {
            mostraLibreria(libreria);
            System.out.println("premi 0 per uscire, 1 per aggiungere un elemento, 2 per rimuovere un elemento (ibsn Code), ");
            System.out.println("3 per cercare un elemento");
            String resp = input.nextLine();
            switch (resp){
                case "0":
                    input.close();
                    open = false;
                    System.out.println("Chiudo l'applicazione");
                    break;
                case "1":
                    aggiungiElemento();
                    break;
                case "2":
                    rimuoviPubblicazione();
                    break;
                case "3":
                    System.out.println("inserisci un isbn, un anno o un autore per iniziare la ricerca");
                    String ricerca = input.nextLine();
                    System.err.println("questo è il risultato della tua ricerca");
                    if (ricerca.matches("[-9]")) {
                        if (Long.parseLong(ricerca) > 99999999) {
                            cercaPublicazione(Long.parseLong(ricerca));
                        } else if (Integer.parseInt(ricerca) < 2024) {
                            cercaPublicazione(Integer.parseInt(ricerca));
                        }
                    }else{
                        cercaPublicazione(ricerca.toLowerCase());
                    }

                default: break;
            }
        }
    }
    public static void aggiungiElemento(){
        System.out.println("seleziona 0 per tornare indietro libro(1) o rivista(2)");
        Scanner input = new Scanner(System.in);
        String resp = input.nextLine();
        switch (resp){
            case "0":
                input.close();
                break;
            case "1":
                aggiungiPubblicazione(input, 1);
                break;
            case "2":
                aggiungiPubblicazione(input, 2);
                break;
        }
    }
    public static void aggiungiPubblicazione(Scanner input, Integer numeroDiCaso) {
        boolean open= true;
        while(open) {
            try {
                System.out.println("inserisci il titolo");
                String titolo = input.nextLine();
                System.out.println("inserisci l'anno di pubblicazione");
                Integer anno = Integer.parseInt(input.nextLine());
                if (anno >= 2023 || anno < 1000) {
                    throw new YearValidationException();
                }
                System.out.println("inserisci il numero di pagine");
                Integer numeroPagine = Integer.parseInt(input.nextLine());

                if (numeroDiCaso == 1) {
                    System.out.println("inserici l'autore");
                    String autore = input.nextLine();
                    System.out.println("scrivi un genere tra i seguenti: STORIA, LETTERATURA, HORROR, FANTASY, BIOGRAFIA");
                    String genere = input.nextLine().toUpperCase();
                    Libro a = new Libro(titolo, anno, numeroPagine, autore, Generi.valueOf(genere));
                    postLibreria(a);

                } else {
                    System.out.println("inserisci una peridicità tra le seguenti Settimanale, Mensile, Semestrale");
                    String peridicita = input.nextLine().toUpperCase();
                    Rivista a = new Rivista(titolo, anno, numeroPagine, Periodicita.valueOf(peridicita));
                    postLibreria(a);

                }
            } catch (NumberFormatException e) {
                System.err.println("devi inserire un numero valido");

            } catch (IllegalArgumentException e) {
                System.err.println("devi inserire un genere tra quelli proposti");

            } catch (YearValidationException e) {
                System.out.println("anno non valido");
            }
            open = false;
        }
    }
    public static void postLibreria(Pubblicazioni a) {
        try {
            libreria.add(a);
            System.out.println("pubblicazione aggiunta con successo alla tua libreria");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void mostraLibreria(List<Pubblicazioni> a){
        a.forEach(System.out::println);
    }
    public static void rimuoviPubblicazione(){
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci un isbn per eliminare l'elemento");
        try {
            Long isbn = Long.parseLong(input.nextLine());
            libreria.removeIf(pubblicazioni -> Objects.equals(pubblicazioni.getIsbn(), isbn));
            System.out.println("elemento " + isbn + " eliminato dalla libreria");
        }catch (NumberFormatException e) {
            System.err.println("numero isbn non valido");
        }


    }
    public static void cercaPublicazione(Long isbn){

        mostraLibreria(libreria.stream().filter(pubblicazioni -> pubblicazioni.getIsbn().equals(isbn)).toList());

        System.out.println("---------------------------------");
    }
    public static void cercaPublicazione(Integer anno){
        mostraLibreria(libreria.stream().filter(pubblicazioni -> pubblicazioni.getAnnoDiPubblicazione().equals(anno)).toList());
        System.out.println("---------------------------------");
    }
    public static void cercaPublicazione(String autore){
        mostraLibreria(libreria.stream().filter(pubblicazioni -> pubblicazioni.getClass().equals(Libro.class)).filter(pubblicazioni -> ((Libro) pubblicazioni).getAutore().toLowerCase().equals(autore)).toList());
        System.out.println("---------------------------------");
    }
}
