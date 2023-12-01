import java.util.ArrayList;

public class Client {

    String name, lastname, email;

    ArrayList<Evenement> tickets;

public Client(){
}
    public Client(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Evenement> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Evenement> tickets) {
        this.tickets = tickets;
    }

    //Fait par ChatGPT
    public void acheterBillet(Evenement evenement) {
        if (evenement.verifierDisponibiliteBillet()) {
            Evenement billetAchete = new Evenement(evenement.getName(), evenement.getLieu(), evenement.getPrice(), evenement.getNbTicketsSold());
            this.tickets.add(billetAchete);
            evenement.vendreBillet();
            System.out.println("Billet acheté avec succès.");
        } else {
            System.out.println("Désolé, plus de billets disponibles pour cet événement.");
        }
    }

    public void annulerAchatBillet(Evenement evenement) {
        if (this.tickets.contains(evenement)) {
            this.tickets.remove(evenement);
            evenement.annulerVenteBillet();
            System.out.println("Annulation de l'achat de billet avec succès.");
        } else {
            System.out.println("Aucun billet de cet événement à annuler.");
        }
    }
    //Fin de ChatGPT
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
