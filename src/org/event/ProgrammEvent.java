package org.event;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class ProgrammEvent {
    private String titolo;
    private List<Evento> eventi;
    public ProgrammEvent(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }
    public List<Evento> eventiInData(LocalDate data) {
        return eventi.stream()
                .filter(evento -> evento.getData().isEqual(data))
                .collect(Collectors.toList());
    }
    public int numeroEventi() {
        return eventi.size();
    }

    public void svuotaEventi() {
        eventi.clear();
    }

}
