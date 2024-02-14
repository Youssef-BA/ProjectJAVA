package esi.oncf.data;
import java.time.LocalDate;
import java.time.LocalTime;

public class Voyage {
    private int idVoyage;
    private String gareDepart;
    private String gareArrivee;
    private LocalDate date;
    private LocalTime heureDepart;
    private LocalTime heureArrivee;

    public Voyage() {
    }

    public Voyage(int idVoyage, String gareDepart, String gareArrivee, LocalDate date, LocalTime heureDepart, LocalTime heureArrivee) {
        this.idVoyage = idVoyage;
        this.gareDepart = gareDepart;
        this.gareArrivee = gareArrivee;
        this.date = date;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    
    public int getIdVoyage() {
        return idVoyage;
    }

    public String getGareDepart() {
        return gareDepart;
    }

    public String getGareArrivee() {
        return gareArrivee;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    
    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public void setGareDepart(String gareDepart) {
        this.gareDepart = gareDepart;
    }

    public void setGareArrivee(String gareArrivee) {
        this.gareArrivee = gareArrivee;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }
}

