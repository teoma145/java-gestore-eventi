package org.event;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nome evento:");
        String nome = scan.nextLine();
        LocalDate data = null;
        boolean dataValida = false;
        while (!dataValida) {
            try {
                System.out.print("Data evento (formato: YYYY-MM-DD): ");
                String dataString = scan.nextLine();
                data = LocalDate.parse(dataString);
                if (data.isBefore(LocalDate.now())) {
                    throw new IllegalArgumentException("La data dell'evento deve essere successiva alla data odierna.");
                }
                dataValida = true;

            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        System.out.print("Posti totali:");
        int postiTotali = scan.nextInt();
        scan.nextLine();
        Evento evento = new Evento(nome,data,postiTotali);
        boolean Prenotazione = true;
        while (Prenotazione){
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Prenota posti");
            System.out.println("2. Esci");
            System.out.println("Numero di posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            int sceltaPrenota = scan.nextInt();
            scan.nextLine();
            switch (sceltaPrenota) {
                case 1:
                    try {
                        System.out.print("Quanti posti vuoi prenotare? ");
                        int numPosti = scan.nextInt();
                        scan.nextLine(); // Consuma il newline dopo il nextInt()
                        evento.prenota(numPosti);
                        System.out.println("Prenotazione effettuata con successo!");
                        System.out.println("Numero di posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Arrivederci!");
                    Prenotazione = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        boolean Disdetti = true;
        while (Disdetti){
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Disdici posti");
            System.out.println("2. Esci");
            System.out.println("Posti prenotati"+evento.getPostiPrenotati());
            int sceltaDisdire = scan.nextInt();
            scan.nextLine();
            switch (sceltaDisdire){
                case 1:
                    try{
                        System.out.print("Quanti posti vuoi disdire? ");
                        int numPosti = scan.nextInt();
                        scan.nextLine();
                        evento.disdici(numPosti);
                        System.out.println("Numero di posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                        System.out.println("posti prenotati: "+evento.getPostiPrenotati());
                    }catch (Exception e){
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Arrivederci!");
                    Disdetti = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }


        }
    }

}
