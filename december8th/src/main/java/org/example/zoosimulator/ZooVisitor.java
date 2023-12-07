package org.example.zoosimulator;

public class ZooVisitor implements ZooObserver {
    private String name;

    public ZooVisitor(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + " reçoit un evenement: " + event);
    }
}