import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Horraires {
    private String routeId; // Identifiant unique de la route
    private LocalTime depart; // Heure de départ
    private LocalTime arrivee; // Heure d'arrivée
    private List<LocalTime> horaires; // Liste des horaires de départ pour cette route

    public Horraires(String routeId, LocalTime depart, LocalTime arrivee) {
        this.routeId = routeId;
        this.depart = depart;
        this.arrivee = arrivee;
        this.horaires = new ArrayList<>();
        // Initialisez la liste des horaires ici si nécessaire
    }

    public void ajouterHoraire(LocalTime heure) {
        horaires.add(heure);
    }

    public void supprimerHoraire(LocalTime heure) {
        horaires.remove(heure);
    }

    // Getters et setters pour routeId, depart, arrivee, et horaires

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public LocalTime getDepart() {
        return depart;
    }

    public void setDepart(LocalTime depart) {
        this.depart = depart;
    }

    public LocalTime getArrivee() {
        return arrivee;
    }

    public void setArrivee(LocalTime arrivee) {
        this.arrivee = arrivee;
    }

    public List<LocalTime> getHoraires() {
        return horaires;
    }

    public void setHoraires(List<LocalTime> horaires) {
        this.horaires = horaires;
    }

    // Méthode pour afficher les informations de l'horaire
    public void afficherHoraires() {
        System.out.println("Route: " + routeId + ", Départ: " + depart + ", Arrivée: " + arrivee);
        System.out.println("Horaires de départ:");
        for (LocalTime heure : horaires) {
            System.out.println(heure);
        }
    }
}
