package org.example.zoosimulator;

public class ElephantFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(String type) {
        // Logique de création d'un éléphant
        return new Elephant();
    }
}