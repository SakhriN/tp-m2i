package org.example.exo;
import java.util.Random;
import java.util.Scanner;

public class Exo {


    public static void Exo1() {
        int[] tableau = {1, 2, 3, 4, 5};
        System.out.println("La valeur de la troisième case du tableau est : " + tableau[2]);
    }

    public static void Exo2() {
        int[] tableau = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int pos = 0;
        for (int i = 0; i < tableau.length; i++) {
            pos = 1 + i;
            System.out.println("Élément à la position " + pos + " : " + tableau[i]);
        }
    }

    public static void Exo3() {
        int[] tableau = {10, 20, 30, 40, 50, 60, 70, 80};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un entier à rechercher dans le tableau : ");
        int nombre = scanner.nextInt();
        boolean present = false;

        for (int i : tableau) {
            if (i == nombre) {
                present = true;
                break;
            }
        }

        if (present) {
            System.out.println("L'entier est présent dans le tableau.");
        } else {
            System.out.println("L'entier n'est pas présent dans le tableau.");
        }
        scanner.close();
    }

    public static void Exo4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez les éléments du tableau (séparés par des espaces) : ");
        String[] input = scanner.nextLine().split(" ");
        boolean Parite = true;

        for (String str : input) {
            int element = Integer.parseInt(str);
            if (element % 2 != 0) {
                Parite = false;
                break;
            }
        }

        if (Parite) {
            System.out.println("Tous les éléments sont pairs.");
        } else {
            System.out.println("Au moins un élément est impair.");
        }
    }

    public static void Exo5() {
        int[] tab = new int[10];
        Random random = new Random();

        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(100) + 1;
        }

        System.out.println("Les éléments du tableau sont : ");
        for (int i : tab) {
            System.out.println(i);
        }
    }

    public static void Exo6() {
        int taille = 5;
        int[] tab1 = new int[taille];
        int[] tab2 = new int[taille];
        Random random = new Random();

        for (int i = 0; i < taille; i++) {
            tab1[i] = random.nextInt(100) + 1;
            tab2[i] = random.nextInt(100) + 1;
        }

        int somme = 0;
        for (int i = 0; i < taille; i++) {
            somme += tab1[i] + tab2[i];
        }

        System.out.println("La somme des éléments des deux tableaux est : " + somme);
    }

    public static void Exo7() {
        int[] tab = new int[10];
        Random random = new Random();

        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(100) + 1;
        }

        int max = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] > max) {
                max = tab[i];
            }
        }
        System.out.println("Le plus grand élément du tableau est : " + max);
    }

}
