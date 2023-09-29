package desafio2;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AparelhoTelefonico {

    private static List<Telefone> telefoneList = new LinkedList<>();
    private static Telefone ligacao = null;

    public static void addTelefone(String nome, long numero) {
        Telefone nTel = new Telefone(nome, numero);
        if (telefoneList.isEmpty() || !telefoneList.contains(nTel)) {
            telefoneList.add(nTel);
        } else {
            System.out.println("Telefone ja existe ná lista");
        }

    }

    public static void ligarPara(String nome) {
        if (!telefoneList.isEmpty()) {
            Optional<Telefone> telLigar = telefoneList.stream()
                    .filter(t -> t.getNome().equalsIgnoreCase(nome)).findFirst();
            if (telLigar.isPresent()) {
                ligacao = telLigar.get();
                System.out.println("Ligando para o " + ligacao);
            } else {
                System.out.println("Telefone não encontrado");
            }
        } else {
            System.out.println("A lista de telefone esta vazia! ");
        }
    }

    public static void desliagarLigacao() {
        if (ligacao != null) {
            System.out.println("Encerrando ligacão com "+ligacao);
            ligacao = null;
        } else {
            System.out.println("Não exite ligações acontencendo! ");
        }
    }

    public static void atender() {
        if (ligacao != null) {
            System.out.println("Voce esta falancom " + ligacao);
        } else {
            System.out.println("Não exite chamadas acontencendo!");
        }
    }

    private static boolean c = false;
    public static void finalizarCorreioVoz() {
        if (c){
            c = false;
            System.out.println("Correio de voz finalizado");
        }else {
            System.out.println("Correio de voz não está ativo");
        }
    }

    public static void iniciarCorreioVoz() {
        if (ligacao == null) {
            c = true;
            System.out.println("Correio de voz iniciado");
        } else {
            System.out.println("Voce não pode iniciar o correio de voz em quanto participa de uma ligaçao");
        }
    }

    public static void main(String[] args) {
        AparelhoTelefonico.addTelefone("ana", 32323232);
        AparelhoTelefonico.addTelefone("Bruna", 3999992);
        AparelhoTelefonico.addTelefone("Carlos", 34564532);
        AparelhoTelefonico.addTelefone("amanda", 329898985);

        AparelhoTelefonico.ligarPara("ana");
        AparelhoTelefonico.atender();
        AparelhoTelefonico.desliagarLigacao();
        AparelhoTelefonico.iniciarCorreioVoz();
        AparelhoTelefonico.finalizarCorreioVoz();


    }

}
