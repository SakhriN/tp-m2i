package org.example.zoosimulator;

public class Lion extends Animal {
    public Lion() {
        super("Simba");
    }

    public void avoirNom() {
        System.out.println("Le nom du lion est: " + getName());
    }
}
