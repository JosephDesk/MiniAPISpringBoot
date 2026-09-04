package com.Prueba.MiniAPISpringBoot.intervalos;

import java.util.*;

public class IntervalosTiempo {

    public static List<int[]> fusionar(int[][] intervalos) {
        if (intervalos == null || intervalos.length == 0) {
            return new ArrayList<>();
        }
        // Valida que cada intervalo
        for (int[] intervalo : intervalos) {
            if (intervalo[0] > intervalo[1]) {
                throw new IllegalArgumentException(
                        "Intervalo inválido: (" + intervalo[0] + "," + intervalo[1] +
                                ") -> el inicio no puede ser mayor que el fin");
            }
        }

        // Ordena por inicio
        int[][] ordenados = intervalos.clone();
        Arrays.sort(ordenados, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> resultado = new ArrayList<>();
        int[] actual = ordenados[0].clone();

        for (int i = 1; i < ordenados.length; i++) {
            int[] siguiente = ordenados[i];
            // Se solapan
            if (siguiente[0] <= actual[1]) {
                System.out.printf("(%d,%d) y (%d,%d) SE SOLAPAN%n",
                        actual[0], actual[1], siguiente[0], siguiente[1]);
                actual[1] = Math.max(actual[1], siguiente[1]);
            } else { // No se solapan
                System.out.printf("(%d,%d) y (%d,%d) NO SE SOLAPAN%n",
                        actual[0], actual[1], siguiente[0], siguiente[1]);
                resultado.add(actual);
                actual = siguiente.clone();
            }
        }
        resultado.add(actual); // agrega el ultimo intervalo

        return resultado;
    }

    private static String aTexto(List<int[]> intervalos) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < intervalos.size(); i++) {
            int[] it = intervalos.get(i);
            sb.append("(").append(it[0]).append(",").append(it[1]).append(")");
            if (i < intervalos.size() - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }


    public static void main(String[] args) {
        int[][][] casos = {
                {{1,3},{2,6},{8,10},{15,18}},
                {{15,18},{2,6},{1,3},{8,10}},
                {{1,4},{4,5}},
                {{4,5},{1,4}},
                {{5,7},{1,2}},
                {{1,10},{2,3},{4,8}},
                {{4,8},{2,3},{1,10}},
                {{1,1}},
                {{4,4},{4,5}},
                {{4,5},{4,4}}
        };

        for (int i = 0; i < casos.length; i++) {
            System.out.println("--- Caso " + (i + 1) + " ---");
            try {
                List<int[]> resultado = fusionar(casos[i]);
                if (casos[i].length == 1) {
                    System.out.println("Solo hay un intervalo, no hay nada que comparar");
                }
                System.out.println("Resultado -> " + aTexto(resultado));
            } catch (IllegalArgumentException e) {
                System.out.println("Error -> " + e.getMessage());
            }
            System.out.println();
        }
    }
}