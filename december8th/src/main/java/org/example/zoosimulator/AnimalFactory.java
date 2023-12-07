package org.example.zoosimulator;

// Abstract Factory pour créer différents types d'animaux
public abstract class AnimalFactory {
    public abstract Animal createAnimal(String type);
}

