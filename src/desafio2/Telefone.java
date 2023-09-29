package desafio2;

import java.util.Objects;

public class Telefone implements Comparable<Telefone>{

    private String nome;
    private long numero;

    public Telefone(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone {" + nome +" -- "+ numero +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone telefone)) return false;
        return getNumero() == telefone.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    @Override
    public int compareTo(Telefone o) {
        return this.getNome().compareTo(o.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
}
