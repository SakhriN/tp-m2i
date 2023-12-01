public class Billetterie {
    public static void main(String[] args) {

        Lieu lieu1 = new Lieu("Parc des Sports", "2 rue de la street, 59100 Roubaix", 20389);
        Lieu lieu2 = new Lieu("Vélodrome", "233 avenue de la réussite, 59100 Roubaix", 309420);
        Lieu lieu3 = new Lieu("CAF", "124 Boulevard Gambetta, 59100 Roubaix", 1029);

        Evenement event1 = new Evenement("Tour de France", lieu1, 29.93f, 12);
        Evenement event2 = new Evenement("Concert Magic System", lieu2, 0, 1290);
        Evenement event3 = new Evenement("Conférence avec Eddy Malou", lieu3, 0, 1);

        Client client1 = new Client("Jean", "Lassalle", "jean.lassalle@gmail.com");
        Client client2 = new Client("Nassim", "Sakhri", "sakhrin4@gmail.com");
        Client client3 = new Client("Eric", "Zemmour", "lessingesdehors@expulsion.fr");

        System.out.println(lieu1+" " + event1);
        System.out.println(client2);
        System.out.println(client3);



    }
}
