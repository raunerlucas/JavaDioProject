package desafio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        int cont = 0;
        do {
            try {
                pegadaDados();
                cont++;
            } catch (InputMismatchException e) {
                System.out.println("O segundo parâmetro deve ser maior que o primeiro");
                System.out.println("O parametros devem ser numeros inteiros");
                System.out.println();
            }
        }while (cont == 0);
    }

    public static void pegadaDados() {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite numeros Inteiros e o segundo deve ser maior!");
        System.out.print("Digite o primeiro parâmetro: ");
        int parametroUm = terminal.nextInt();
        System.out.print("Digite o segundo parâmetro: ");
        int parametroDois = terminal.nextInt();
        contar(parametroUm, parametroDois);
    }

    static void contar(int parametroUm, int parametroDois) throws InputMismatchException {
        if (parametroUm >= parametroDois) {
            throw new InputMismatchException();
        }

        for (int i = parametroUm; i <= parametroDois; i++) {
            System.out.println(i);
        }
    }
}