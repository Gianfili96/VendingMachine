package org.example;

import java.util.ArrayList;
import java.util.List;

public class Machine {

      //Ho creato una lista che contiene gli oggetti di tipo Prodotto
      private final List<Prodotto> prodotti = new ArrayList<>();
      //La variabile saldo creata mi serve per dare la possibilità all'utente di inserire il denaro
      private double saldo = 0;

      //Creo il metodo per aggiungere il prodotto
      //Passo il parametro della classe Prodotto che mi servirà nel main per aggiungere i prodotti per la machine
      public void aggiungiProdotto(Prodotto p) {

          prodotti.add(p);
      }

      //Creo il metodoo per mostrare i prodotti nella lista
      public void mostraProdotti() {
          System.out.println("\n--- LISTA SNACK BIBITE ---");
          for(int i=0; i < prodotti.size(); i++) {
              Prodotto p = prodotti.get(i);
              System.out.print(i + ")" + p);
              //Ho avuto problemi nella stampa a schermo perché non avevo inserito nella classe Prodotto il toString
              //In pratica stampavo il prodotto, ma non il suo indice e di conseguenza il prodotto nella lista appariva
              //org.example.Prodotto@5197848c)Caffè - €0.9 - Quantità: 1

          }
        }

      //Creo il metodo per inserire il denaro
      public void inserisciDenaro(Double importo) {
          saldo += importo;
          System.out.println("Saldo attuale: " + saldo);
      }


      public void ricaricaProdotto(int indice, int quantita) {
          if(!indiceValido(indice)) {
              System.out.println("Errore: il prodotto non esiste!");
              return;
          }

          prodotti.get(indice).ricarica(quantita);
          System.out.println("Prodotto ricaricato correttamente!");
      }

      //In questo metoodo gestisco la logica per l'acquisto di un prodotto
      //Domanda: Posso gestire meglio i controlli?
      public void acquista(int indice) {
            if(!indiceValido(indice)) {
                System.out.println("Errore: il prodotto non esiste!");
                return;
            }

            Prodotto p = prodotti.get(indice);

            //Controllo se la quantità del prodotto è insufficiente
            if(p.getQuantita() == 0) {
                System.out.println("La quantità del prodotto è esaurita");
                return;
            }

            //Controllo se il saldo inserito è insufficiente per l'acquisto del prodotto
            if(saldo < p.getPrezzo()) {
                System.out.println("Il credito inserito è insufficiente!");
                return;
            }

            p.decrementaQuantita();
            saldo -= p.getPrezzo();

            System.out.println("Hai acquistato il prodotto: " + p.getNome());
            System.out.println("Saldo residuo: " + String.format("%.2f", saldo));
            //Ho dovuto aggiungere questo specificatore di stringhe per arrotondare i numeri decimali.
            //Senza di esso il saldo mi usciva così: 2.5999999.


      }

      //Sto simulando il fatto che la macchina restituisce il resto e il credito torna a 0
      public Double resto() {
          double resto = saldo;
          saldo = 0;
          return resto;
      }

      //Questo metodo controlla che l'indice sia tra 0 e l'ultimo indice valido
      //Protegge la logica da input sbagliati esempio: scelta inserita -1 quindi negativa
      private boolean indiceValido(int indice) {
          //Controllo che l'indice inserito dell'utente punti realmente a una lista esistente
          return indice >= 0 && indice < prodotti.size();
      }

}
