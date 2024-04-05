package org.example.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatriceLayout extends JPanel implements ActionListener {

    private JButton jButton0;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButtonpoint;
    private JButton jButtonegal;
    private JButton jButtonplus;
    private JButton jButtonmoins;
    private JButton jButtondivise;
    private JButton jButtonmultiplie;
    private JButton jButtonmodulo;
    private JButton jButtonC;
    private JButton jButtonspecial;

    private double number1 = 0;
    private double number2 = 0;
    private String operator = "";
    private boolean startNewInput = true;
    private JPanel jPanel;

    GridBagLayout gridBagLayout = new GridBagLayout();

    public CalculatriceLayout() {
        jPanel = new JPanel();
        jPanel.setLayout(gridBagLayout);
        setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBackground(Color.black);
        textField.setForeground(Color.white);// Alignement du texte à droite
        add(textField, BorderLayout.NORTH);

        jButton0 = new JButton("0");
        jButton0.addActionListener(this);

        jButton1 = new JButton("1");
        jButton1.addActionListener(this);

        jButton2 = new JButton("2");
        jButton2.addActionListener(this::actionPerformed);

        jButton3 = new JButton("3");
        jButton3.addActionListener(this::actionPerformed);

        jButton4 = new JButton("4");
        jButton4.addActionListener(this::actionPerformed);

        jButton5 = new JButton("5");
        jButton5.addActionListener(this::actionPerformed);

        jButton6 = new JButton("6");
        jButton6.addActionListener(this::actionPerformed);

        jButton7 = new JButton("7");
        jButton7.addActionListener(this::actionPerformed);

        jButton8 = new JButton("8");
        jButton8.addActionListener(this::actionPerformed);

        jButton9 = new JButton("9");
        jButton9.addActionListener(this::actionPerformed);

        jButtonpoint = new JButton(".");
        jButtonpoint.addActionListener(this::actionPerformed);

        jButtonegal = new JButton("=");
        jButtonegal.addActionListener(this::actionPerformed);

        jButtonplus = new JButton("+");
        jButtonplus.addActionListener(this::actionPerformed);

        jButtonmoins = new JButton("-");
        jButtonmoins.addActionListener(this::actionPerformed);

        jButtondivise = new JButton("/");
        jButtondivise.addActionListener(this::actionPerformed);

        jButtonmultiplie = new JButton("*");
        jButtonmultiplie.addActionListener(this::actionPerformed);

        jButtonmodulo = new JButton("%");
        jButtonmodulo.addActionListener(this::actionPerformed);

        jButtonC = new JButton("C");
        jButtonC.addActionListener(this::actionPerformed);

        jButtonspecial = new JButton("special");
        jButtonspecial.addActionListener(this::actionPerformed);

        jButton0.setBackground(Color.black);
        jButton1.setBackground(Color.black);
        jButton2.setBackground(Color.black);
        jButton3.setBackground(Color.black);
        jButton4.setBackground(Color.black);
        jButton5.setBackground(Color.black);
        jButton6.setBackground(Color.black);
        jButton7.setBackground(Color.black);
        jButton8.setBackground(Color.black);
        jButton9.setBackground(Color.black);
        jButtonpoint.setBackground(Color.black);

        jButtonC.setBackground(Color.gray);
        jButtonspecial.setBackground(Color.gray);
        jButtonmodulo.setBackground(Color.gray);

        jButtondivise.setBackground(Color.orange);
        jButtonmultiplie.setBackground(Color.orange);
        jButtonplus.setBackground(Color.orange);
        jButtonmoins.setBackground(Color.orange);
        jButtonegal.setBackground(Color.orange);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel.add(jButtonC, gbc);

        gbc.gridx = 1;
        jPanel.add(jButtonspecial, gbc);

        gbc.gridx = 2;
        jPanel.add(jButtonmodulo, gbc);

        gbc.gridx = 3;
        jPanel.add(jButtondivise, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel.add(jButton7, gbc);

        gbc.gridx = 1;
        jPanel.add(jButton8, gbc);

        gbc.gridx = 2;
        jPanel.add(jButton9, gbc);

        gbc.gridx = 3;
        jPanel.add(jButtonmultiplie, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        jPanel.add(jButton4, gbc);

        gbc.gridx = 1;
        jPanel.add(jButton5, gbc);

        gbc.gridx = 2;
        jPanel.add(jButton6, gbc);

        gbc.gridx = 3;
        jPanel.add(jButtonplus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        jPanel.add(jButton1, gbc);

        gbc.gridx = 1;
        jPanel.add(jButton2, gbc);

        gbc.gridx = 2;
        jPanel.add(jButton3, gbc);

        gbc.gridx = 3;
        jPanel.add(jButtonmoins, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        jPanel.add(jButton0, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        jPanel.add(jButtonpoint, gbc);

        gbc.gridx = 3;
        jPanel.add(jButtonegal, gbc);

        add(jPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonText = clickedButton.getText();
        switch(buttonText)
            case "0" -> number1 = number1 + 0 ;
            case "1" -> ;
            case "2" -> ;
            case "3" -> ;
            case "4" -> ;
            case "5" -> ;
            case "6" -> ;
            case "7" -> ;
            case "8" -> ;
            case "9" -> ;
            case "." -> ;
            case "+" -> ;
            case "-" -> ;
            case "/" -> ;
            case "*" -> ;
            case "%" -> ;
            case "special" -> ;
            case "=" -> ;
        System.out.println("Le bouton " + buttonText + " a été cliqué !");

    }
}