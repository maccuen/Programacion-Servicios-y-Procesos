package com.gregoriofer.procesos.ejemplo.secuencial;

import com.gregoriofer.procesos.ejemplo.utilidades.SumadorDeMatrices;

public class TestSecuencial {

    public static void test(final int[][] matriz1, final int[][] matriz2,
                            final int[][] matrizSuma, final int numeroFilas, final int numeroColumnas) {

        final long iniTime = System.currentTimeMillis();
        SumadorDeMatrices.sumar(numeroFilas, numeroColumnas, matriz1, matriz2, matrizSuma);
        final long finTime = System.currentTimeMillis();

        System.out.println("Tiempo Secuencial: " + (finTime - iniTime));
    }
}
