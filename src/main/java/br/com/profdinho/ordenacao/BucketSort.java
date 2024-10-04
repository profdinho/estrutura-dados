package br.com.profdinho.ordenacao;

import java.util.*;

public class BucketSort {

    // Função principal que implementa o Bucket Sort
    public static void bucketSort(float[] array, int numBuckets) {
        // Cria os buckets vazios
        List<Float>[] buckets = new List[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // Coloca cada elemento do array no bucket correspondente
        for (float element : array) {
            int bucketIndex = (int) (element * numBuckets);  // Calcular o índice do bucket
            buckets[bucketIndex].add(element);
        }

        // Ordena cada bucket individualmente
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);  // Aqui usamos o método de ordenação padrão
        }

        // Concatenar os buckets em um único array
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float element : bucket) {
                array[index++] = element;
            }
        }
    }

    // Função auxiliar para imprimir o array
    public static void imprimirArray(float[] array) {
        for (float element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Método principal para testar o Bucket Sort
    public static void main(String[] args) {
        float[] array = { (float) 0.42, (float) 0.32, (float) 0.23, (float) 0.52, (float) 0.25, (float) 0.47, (float) 0.51 };

        System.out.println("Array original:");
        imprimirArray(array);

        bucketSort(array, 5);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
