package org.example;

import org.example.layout.CalculatriceLayout;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Demo Layout");
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new CalculatriceLayout());
        jFrame.pack();
        jFrame.setVisible(true);
        System.out.printf("Hello and welcome!");
    }
}