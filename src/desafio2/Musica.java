package desafio2;

import java.util.Comparator;
import java.util.Objects;

public class Musica {
    private String nome,letra;
    private double tempo;
    private int id;

    public Musica(int id,String nome, String letra, double tempo) {
        this.id = id;
        this.nome = nome;
        this.letra = letra;
        this.tempo = tempo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Musica musica)) return false;
        return getId() == musica.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    public String viewResumoMusica(){
        return "\nMusica ==" +
                " Nome= " + nome +
                ", letra= " + letra +
                ", tempo= " + tempo;
    }

    @Override
    public String toString() {
        return "\nMusica ==" +
                " Nome= " + nome +
                ", letra= " + letra +
                ", tempo= " + tempo;
    }

    public String getNome() {
        return nome;
    }

    public String getLetra() {
        return letra;
    }


    public double getTempo() {
        return tempo;
    }

    public int getId() {
        return id;
    }

}

