package org.example.zoosimulator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ZooManager zooManager = ZooManager.getInstance();

        // Création d'observateurs (visiteurs du zoo)
        ZooVisitor visitor1 = new ZooVisitor("Jean-Eude");
        ZooVisitor visitor2 = new ZooVisitor("Didier");

        zooManager.addZooObserver(visitor1);
        zooManager.addZooObserver(visitor2);

        AnimalFactory lionFactory = new LionFactory();
        AnimalFactory elephantFactory = new ElephantFactory();

        Lion lion = (Lion) lionFactory.createAnimal("Lion");
        Elephant elephant = (Elephant) elephantFactory.createAnimal("Elephant");

        lion.avoirNom();
        elephant.avoirNom();

        zooManager.notifyObservers("Un animal arrive: " + lion.name);
        lion.reactToEvent("Rugissement du lion!");

        zooManager.notifyObservers("Un animal arrive: " + elephant.name);
        elephant.reactToEvent("Coup de trompe d'elephant!");


    }
}
