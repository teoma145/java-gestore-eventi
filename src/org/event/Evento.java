package org.event;
import java.time.LocalDate;
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
}

