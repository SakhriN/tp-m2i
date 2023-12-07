package org.example.zoosimulator;

import java.util.ArrayList;
import java.util.List;

public class ZooManager {
    private static ZooManager instance;
    private List<ZooObserver> zooObservers;

    private ZooManager() {
        this.zooObservers = new ArrayList<>();
        // Initialisation du gestionnaire du zoo
    }

    public static ZooManager getInstance() {
        if (instance == null) {
            instance = new ZooManager();
        }
        return instance;
    }

    public void addZooObserver(ZooObserver observer) {
        zooObservers.add(observer);
    }

    // Notifie tous les observateurs d'un événement
    public void notifyObservers(String event) {
        for (ZooObserver observer : zooObservers) {
            observer.update(event);
        }
    }

    // Autres méthodes et attributs spécifiques du gestionnaire du zoo
}
