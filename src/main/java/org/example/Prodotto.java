package org.example;

//Domanda: posso inserire Lombok?
//Domanda: se inserisco Lombok posso fare a meno dei setter visto che in automatico me li genera con @Data?

public class Prodotto {
    String nome;
    Double prezzo;
    int quantita;

    Prodotto(String nome, Double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrezzo() {

        return prezzo;
    }

    public int getQuantita() {

        return quantita;
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
