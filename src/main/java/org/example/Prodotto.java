package org.example;
import lombok.Getter;
//Domanda: posso inserire Lombok?
//Domanda: se inserisco Lombok posso fare a meno dei setter visto che in automatico me li genera con @Data?

@Getter
public class Prodotto {
    String nome;
    Double prezzo;
    int quantita;

    //Costruttore
    Prodotto(String nome, Double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }


    public void decrementaQuantita() {
        if(quantita > 0) {
            quantita--;
        }
    }

    public void ricarica(int qta) {
        if(qta > 0) {
            quantita += qta;
        }
    }

    @Override
    public String toString() {
        return nome + " -€" + prezzo + " - Quantità: " + quantita + "\n";
    }
}
