package org.example;

import java.util.Scanner;

/*
Ho basato il progetto interamente sulla programmazione a oggetti
Classi: ho creato le classi più distinte Main, Prodotto e Machine.
Oggetti: Ogni Prodotto è un oggetto della classe Prodotto mentre la Machine contiene una collezione di oggetti Prodotto
Incapsulamento: Ho utilizzato l'incapsulamento Private per proteggere lo stato interno degli oggetti
e per potervi accedere ho utilizzato metodi pubblici getNome(), getPrezzo(), getQuantita().
Collezioni: Ho utilizzato la collezione ArrayList per gestire una lista dinamica
Cicli e iterazioni: mi è servito un ciclo for per far scorrere la lista dei prodotti, stampando ogni prodotto con il suo
indice.
Metodi: ho definito diversi metodi nelle classi Prodotto e Machine
Gestione dello stato: La machine mantiene uno stato interno e ogni operazione modifica lo stato in modo controllato
es: saldo ---> denaro inserito, prodotti ---> lista dei prodotti disponibili
Controlli e validazioni: ho inserito diversi controlli (if-while) e il controllo della validazione dell'indice indiceValido()
Scanner: ho inserito l'input da tastiera per permettere all'utente di interagire con il programma
Switch-case: Ho costruito un menu interattivo con switch-case creando un interfaccia utente testuale
Override: ho inserito @Override nel metodo toString per sovrascriverlo migliorando la leggibilità dell'output
 */

public class Main {
    public static void main(String[] args) {

        //Classe scanner input da tastiera per leggere le scelte dell'utente
        Scanner scanner = new Scanner(System.in);

        //Istanzio un oggetto creando un oggetto machine che contiene la lista dei prodotti, saldo e metodi
        //per acquisto, ricarica, resto
        Machine machine = new Machine();

        //Sto creando oggetti prodotto inserendoli nella lista interna della Machine
        machine.aggiungiProdotto(new Prodotto("Caffè", 0.90, 1));
        machine.aggiungiProdotto(new Prodotto("Acqua naturale", 0.60, 1));
        machine.aggiungiProdotto(new Prodotto("Coca Cola", 1.50, 1));
        machine.aggiungiProdotto(new Prodotto("Kinder bueno", 1.20, 1));
        machine.aggiungiProdotto(new Prodotto("Kinder cereali", 1.00, 1));
        machine.aggiungiProdotto(new Prodotto("Mars", 1.30, 1));

        //Ciclo principale del programma
        //Concetti usati: ciclo while, condizione booleana, Loop infinito controllato dall'utente
        //il programma continua finchè l'utente non esce dal programma
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

            //Ho utilizzato lo switch per gestire le operazioni
            switch(scelta) {
                case 1:
                    System.out.println("Inserisci l'importo: ");
                    //Qui richiamo un metodo inserisciDenaro modificando lo stato interno dell'oggetto
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