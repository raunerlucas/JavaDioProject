package desafio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepodutorMusicial {

    private static List<Musica> musicaList = new ArrayList<>();
    private static Musica tocando = null;

    public static void tocarMusica() {
        if (tocando == null && !musicaList.isEmpty()) {
            tocando = musicaList.get(0);
            System.out.println("Tocando: " + tocando.viewResumoMusica());
        } else {
            System.out.println("Nenhuma música tocando ou lista vazia.");
        }


    }

    public static void proximaMusica() {
        if (tocando != null && !musicaList.isEmpty()) {
            int indiceAtual = musicaList.indexOf(tocando);
            Musica primeiraMusica = musicaList.get(0);
            if (indiceAtual >= 0 && indiceAtual < musicaList.size() - 1) {
                tocando = musicaList.get(indiceAtual + 1);
                System.out.println("Tocando: " + tocando.viewResumoMusica());
            } else {
                tocando = primeiraMusica;
                System.out.println("Tocando: " + tocando.viewResumoMusica());
            }
        } else {
            System.out.println("Nenhuma música tocando ou lista vazia.");
        }
    }


    public static void anteriorMusica() {
        if (tocando != null && !musicaList.isEmpty()) {
            tocando = musicaList.indexOf(tocando) != 0 ? musicaList.get(musicaList.indexOf(tocando) - 1) : musicaList.get(musicaList.size() - 1);
            System.out.println("Tocando: " + tocando.viewResumoMusica());
        } else {
            System.out.println("Nenhuma música tocando ou lista vazia.");
        }
    }

    public static void pausarMusica() {
        if (tocando != null) {
            System.out.println("Musica pausada");
        } else {
            System.out.println("Nenhuma musica tocando");
        }
    }

    public static void SelecionarMusica(String nome) {
        if (!musicaList.isEmpty()) {
            for (Musica m: musicaList) {
                if (m.getNome().equalsIgnoreCase(nome)){
                    tocando = m;
                    System.out.println("Tocando buscada: " + tocando.viewResumoMusica());
                }
            }
            if (tocando == null)
                System.out.println("Musica não encontrada");
        } else {
            System.out.println("lista vazia.");
        }
    }

    public static void addMusica(int id, String nome, String letra, double tempo) {
        var newM = new Musica(id, nome, letra, tempo);
        if (musicaList.isEmpty() || !musicaList.contains(newM)) {
            musicaList.add(newM);
            System.out.println(nome + " adicionada com sucesso!");
        } else {
            System.out.println("Musica Já existente na lista");
        }
    }

    public static void removeMusica(int id, String nome) {
        var newM = new Musica(id, nome, "null", 0d);
        if (!musicaList.isEmpty() && musicaList.contains(newM)) {
            musicaList.remove(newM);
            System.out.println(nome + " removida com sucesso!");
        } else {
            System.out.println("Musica Já existente na lista");
        }
    }

    public static void viewMusicas(){
        musicaList.forEach(System.out::print);
        System.out.println();
    }
    public static void main(String[] args) {
        RepodutorMusicial.addMusica(1, "jose", "Blala", 0);
        RepodutorMusicial.addMusica(2, "maria", "Blala", 0);
        RepodutorMusicial.addMusica(3, "fernando", "Blala", 0);
        RepodutorMusicial.addMusica(4, "hugo", "Blala", 0);

        RepodutorMusicial.tocarMusica();
        RepodutorMusicial.pausarMusica();
        RepodutorMusicial.tocarMusica();

        RepodutorMusicial.SelecionarMusica("fernando");

        RepodutorMusicial.proximaMusica();
        RepodutorMusicial.anteriorMusica();

        RepodutorMusicial.removeMusica(1,"jose");

        RepodutorMusicial.viewMusicas();
    }

}
