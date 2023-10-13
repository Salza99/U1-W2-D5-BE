package org.example;

import entities.Enum.Generi;
import entities.Enum.Periodicita;
import entities.Exception.YearValidationException;
import entities.Libro;
import entities.Pubblicazioni;
import entities.Rivista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("premi 0 per uscire, 1 per aggiungere un elemento");
            String resp = input.nextLine();
            switch (resp){
                case "0":
                    input.close();
                    open = false;
                    System.out.println("Chiudo l'applicazione");
                    break;
                case "1":
                    aggiungiElemento();
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
            case "2":
                aggiungiPubblicazione(input, 2);

        }
    }
    public static void aggiungiPubblicazione(Scanner input, Integer numeroDiCaso) {
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

            if (numeroDiCaso == 1){
                System.out.println("inserici l'autore");
                String autore = input.nextLine();
                System.out.println("scrivi un genere tra i seguenti: STORIA, LETTERATURA, HORROR, FANTASY, BIOGRAFIA");
                String genere = input.nextLine().toUpperCase();
                Libro a = new Libro(titolo, anno,numeroPagine,autore,Generi.valueOf(genere));
                postLibreria(a);
            }else {
                System.out.println("inserisci una peridicità tra le seguenti Settimanale, Mensile, Semestrale");
                String peridicita = input.nextLine().toUpperCase();
                Rivista a = new Rivista(titolo, anno, numeroPagine, Periodicita.valueOf(peridicita));
                postLibreria(a);
            }
        }catch (NumberFormatException e) {
            System.err.println("devi inserire un numero valido");
            aggiungiPubblicazione(input, numeroDiCaso);
        }catch (IllegalArgumentException e) {
            System.err.println("devi inserire un genere tra quelli proposti");
            aggiungiPubblicazione(input, numeroDiCaso);
        } catch (YearValidationException e) {
            System.out.println("anno non valido");
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
    public static void mostraLibreria(){

    }
    public static void rimuoviPubblicazione(Long isbn){

    }
    public static void cercaPublicazione(Long isbn){

    }
    public static void cercaPublicazione(Integer anno){

    }
    public static void cercaPublicazione(String autore){

    }
}
