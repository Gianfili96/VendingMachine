package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine();

        machine.aggiungiProdotto(new Prodotto("Caffè", 0.90, 1));
        machine.aggiungiProdotto(new Prodotto("Acqua naturale", 0.60, 1));
        machine.aggiungiProdotto(new Prodotto("Coca Cola", 1.50, 1));
        machine.aggiungiProdotto(new Prodotto("Kinder bueno", 1.20, 1));
        machine.aggiungiProdotto(new Prodotto("Kinder cereali", 1.00, 1));
        machine.aggiungiProdotto(new Prodotto("Mars", 1.30, 1));

        boolean running = true;

        while(running) {

            System.out.println("\n--- MENU VENDING MACHINE ---");
            System.out.println("1) Inserisci denaro");
            System.out.println("2) Acquista prodotto");
            System.out.println("3) Ricarica prodotto");
            System.out.println("4) Richiedi resto");
            System.out.println("5) Esci");
            System.out.println("Scelta: ");

            int scelta = scanner.nextInt();

            switch(scelta) {
                case 1:
                    System.out.println("Inserisci l'importo: ");
                    machine.inserisciDenaro(scanner.nextDouble());
                    break;

                case 2:
                    machine.mostraProdotti();
                    System.out.println("Seleziona il prodotto: ");
                    machine.acquista(scanner.nextInt());
                    break;

                case 3:
                    machine.mostraProdotti();
                    System.out.println("Seleziona il prodotto da ricaricare: ");
                    int indice = scanner.nextInt();
                    System.out.println("Quantità da aggiungere: ");
                    int qta = scanner.nextInt();
                    machine.ricaricaProdotto(indice, qta);
                    break;

                case 4:
                    System.out.println("Totale resto restituito: " + machine.resto());
                    break;

                case 5:
                    System.out.println("Chiusura programma");
                    running = false;
                    break;

                default:
                    System.out.println("Scelta non valida, riprova!");


            }

        }

        scanner.close();
    }
}