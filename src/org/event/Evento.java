package org.event;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) {
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }
    public void prenota(int numPosti) throws Exception {
        if (data.isBefore(LocalDate.now()) || data.equals(LocalDate.now())) {
            throw new Exception("Impossibile prenotare: l'evento è già passato.");
        }
        if (postiPrenotati + numPosti > postiTotali) {
            throw new Exception("Impossibile prenotare: non ci sono abbastanza posti disponibili.");
        }
        postiPrenotati += numPosti;
    }
    public void disdici(int numPosti) throws Exception {
        if (postiPrenotati < numPosti) {
            throw new Exception("Impossibile disdire: non ci sono abbastanza prenotazioni.");
        }
        postiPrenotati -= numPosti;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
}

