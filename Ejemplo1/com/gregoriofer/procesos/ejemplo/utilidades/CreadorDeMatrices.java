package com.gregoriofer.procesos.ejemplo.utilidades;

public class CreadorDeMatrices {

    public static int[][] crear(final int numeroDeFilas, final int numeroDeColumnas) {

        final int[][] matriz = new int[numeroDeFilas][numeroDeColumnas];

        for (int fila = 0; fila < numeroDeFilas; fila++) {
            for (int columna = 0; columna < numeroDeColumnas; columna++) {
                matriz[fila][columna] = fila + columna;
            }
        }

        return matriz;
    }
}
