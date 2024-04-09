package org.event;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;
    public Concerto(String titolo, LocalDate data, int postiTotali,LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
    public String getDataFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getData().format(formatter);
    }
    public String getOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(formatter);
    }
    public String getPrezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    @Override
    public String toString() {
        return getDataFormattata() + " " + getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}
