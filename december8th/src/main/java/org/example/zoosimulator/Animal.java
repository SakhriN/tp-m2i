package org.example.zoosimulator;

public abstract class Animal implements AnimalObserver {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
    protected String getName() {
        return name;
    }
    @Override
    public void reactToEvent(String event) {
        System.out.println(name + " est dans l'évenement suivant : " + event);
    }
}