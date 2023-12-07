package org.example.zoosimulator;

public class LionFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(String type) {
        // Logique de création d'un lion
        return new Lion();
    }
}