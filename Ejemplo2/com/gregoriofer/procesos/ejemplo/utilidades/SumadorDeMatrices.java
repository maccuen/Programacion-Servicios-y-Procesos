package com.gregoriofer.procesos.ejemplo.utilidades;

public class SumadorDeMatrices {

    public static void sumar(final int numeroDeFilas, final int numeroDeColumnas, final int[][] matriz1,
                             final int[][] matriz2, final int[][] matrizSuma) {
        sumarParcial(0, numeroDeFilas, numeroDeColumnas, matriz1, matriz2, matrizSuma);
    }

    public static void sumarParcial(final int filaInicial, final int filaFinal, final int numeroDeColumnas,
                                    final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma) {

        for (int fila = filaInicial; fila < filaFinal; fila++) {
            for (int columna = 0; columna < numeroDeColumnas; columna++) {
                matrizSuma[fila][columna] = matriz1[fila][columna] + matriz2[fila][columna];
            }
        }
    }
}
