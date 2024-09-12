package br.com.profdinho.recursividade;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        /*
        System.out.printf("Hello and welcome!\n");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
         */
        Scanner scanner = new Scanner(System.in);
        //Integer numero;
        System.out.printf("Digite uma palavra: ");
        //numero = scanner.nextInt();
        String palavra = scanner.nextLine();
        //Integer[] array = {9, 3, 7, 2};
        //System.out.println("A soma dos números é: " + somaIterativa(numero));
        //System.out.println("A soma dos números é: " + somaRecursiva(numero));
        //System.out.println("Fatorial do número é: " + fatorialIterativo(numero));
        //System.out.println("Fatorial do número é: " + fatorialRecursivo(numero));
        //System.out.println("Fibonacci do número é: " + fibonacciIterativo(numero));
        //System.out.println("Fibonacci do número é: " + fibonacciRecursivo(numero));
        //System.out.println("A soma dos elementos do array é: " + somaArrayRecursivo(array, array.length));
        System.out.println("A palavra invertida é: " + inverterStringRecursivo(palavra));
    }
    public static Integer somaIterativa(Integer numero) {
        Integer soma = 0;
        for (Integer i = 0; i <= numero; i++) {
            soma += i;
        }
        return soma;
    }
    public static Integer somaRecursiva(Integer numero) {
        if (numero == 0) {
            // Caso base: Resolução direta do problema
            return 0;
        } else {
            // Passo recursivo: Chama o próprio método com novos parâmetros
            return numero + somaRecursiva(numero - 1);
        }
    }
    public static Integer fatorialIterativo(Integer numero) {
        Integer resultado = 1;
        for (Integer i = numero; i > 0; i--) {
            resultado *= i;
        }
        return resultado;
    }
    public static Integer fatorialRecursivo(Integer numero) {
        if (numero == 0) {
            // Caso base: fatorial de 0 é 1
            return 1;
        } else {
            // Passo recursivo: numero * fatorialRecursivo(numero - 1)
            return numero * fatorialRecursivo(numero - 1);
        }
    }
    public static Integer fibonacciIterativo(Integer numero) {
        Integer a = 0, b = 1, c = 0, i;
        if (numero == 1) {
            return 0;
        }
        else if (numero == 2) {
            return 1;
        }
        else {
            for (i = 2; i < numero; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }
    public static Integer fibonacciRecursivo(Integer n) {
        if (n == 1) {
            return 0;
        }
        else {
            if (n == 2) {
                return 1;
            } else {
                return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
            }
        }
    }
    public static Integer somaArrayRecursivo(Integer[] array, Integer tamanho) {
        if (tamanho == 0) {
            return 0;
        } else {
            return array[tamanho - 1] + somaArrayRecursivo(array, tamanho - 1);
        }
    }
    public static Integer potenciaRecursivo(Integer x, Integer y) {
        if (y == 0) {
            return 1;
        } else {
            return x * potenciaRecursivo(x, y - 1);
        }
    }
    public static String inverterStringRecursivo(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return inverterStringRecursivo(str.substring(1)) + str.charAt(0);
        }
    }
    public static int pesquisaBinariaRecursiva(int[] array, int esquerda, int direita, int x) {
        if (direita >= esquerda) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (array[meio] == x) {
                return meio;
            }

            if (array[meio] > x) {
                return pesquisaBinariaRecursiva(array, esquerda, meio - 1, x);
            }

            return pesquisaBinariaRecursiva(array, meio + 1, direita, x);
        }

        return -1; // Elemento não encontrado
    }

}