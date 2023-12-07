package org.example.zoosimulator;

import java.util.ArrayList;
import java.util.List;

public class ZooManager {
    private static ZooManager instance;
    private List<ZooObserver> zooObservers;

    private ZooManager() {
        this.zooObservers = new ArrayList<>();
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

    public void notifyObservers(String event) {
        for (ZooObserver observer : zooObservers) {
            observer.update(event);
        }
    }
}
