package desafio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class NavegadorInternet {

    private static String site = "";
    private static List<String> abas = new ArrayList<>();


    private static void exibirPagina(String url) {
        site = url;
        System.out.println("Você está na acesando o site: " + site);
    }

    private static void adicionarNovaAba() {
        System.out.println("Você em uma nova aba");
        abas.add(site);
        site = "";
    }

    private static void atualizarPagina() {
        if (site.isBlank()) {
            System.out.println("Vc não esta em nenhum site no momento");
        } else {
            System.out.println("Atualizando...");
            try {
                Thread.sleep(2000);
                System.out.println("O site "+site+" foi atualizado");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        NavegadorInternet.exibirPagina("Page do Jose");
        NavegadorInternet.adicionarNovaAba();
        NavegadorInternet.exibirPagina("Page da Ana");
        NavegadorInternet.atualizarPagina();

    }

}
