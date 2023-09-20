package candidatura;

import java.util.Arrays;
import java.util.Random;

public class ProcessoSeletivo {

    public static String analizaSalario(double salarioPretendido) {
        String txt = "";
        if (salarioPretendido < 2000D) {
            txt = "LIGAR PARA O CANDIDATO";
        } else if (salarioPretendido == 2000D) {
            txt = "LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA";
        } else {
            txt = "AGUARDANDO RESULTADO DEMAIS CANDIDATOS";
        }
        return txt;
    }

    public static String[] cadidatosSelec() {
        Random rd = new Random();
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO"
                , "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"}, aprovados = new String[5];

        int candSelec = 0, candAtual = 0;
        while (candSelec < 5 && candAtual < candidatos.length){
            String candidato = candidatos[candAtual];
            double salarioPre = rd.nextDouble(1800.2D,2200.2D);
            if (salarioPre <= 2000D) {
                aprovados[candSelec] = candidato;
                candSelec++;
            }
            candAtual++;
        }
        return aprovados;
    }
    static boolean ligar() {
        return new Random().nextInt(3)==1;
    }


    public static void realizaLigacao(String[] candidatos){
        for (String c: candidatos) {
            int cont = 0;
            if (c != null) {
                for (int i = 0; i < 3; i++) {
                    if (ligar()) {
                        System.out.println("CONSEGUIMOS CONTATO COM " + c + " APÓS " + (i + 1) + " TENTATIVA(S)");
                        break;
                    } else {
                        cont++;
                    }
                }
                if (cont == 3) {
                    System.out.println("NÃO CONSEGUIMOS CONTATO COM O(A) _" + c + "_");
                }
            }else {
                System.out.println("NULL não é candidato");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("PROCESSO SELETIVO!\n");

        System.out.println(analizaSalario(1900D));
        System.out.println(analizaSalario(2200D));
        System.out.println(analizaSalario(2000D));

        System.out.println();
        String[] selec = cadidatosSelec();
        System.out.println("\nCandidatos selecionados: "+Arrays.toString(selec));

        realizaLigacao(selec);
    }

}