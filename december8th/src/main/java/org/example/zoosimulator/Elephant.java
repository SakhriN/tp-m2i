package org.example.zoosimulator;

public class Elephant extends Animal {
    public Elephant() {
        super("Dumbo");
    }

    public void avoirNom() {
        System.out.println("Le nom de l'éléphant est: " + getName());
    }
}