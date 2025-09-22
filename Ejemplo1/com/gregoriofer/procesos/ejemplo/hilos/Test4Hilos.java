package com.gregoriofer.procesos.ejemplo.hilos;

public class Test4Hilos {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas) {

        final int filaFinal1 = numeroFilas / 4;
        final int filaFinal2 = numeroFilas / 2;
        final int filaFinal3 = 3 * numeroFilas / 4;

        long iniTime = System.currentTimeMillis();

        final Hilo hilo1 = new Hilo(0, filaFinal1, numeroColumnas, matriz1, matriz2, matrizSuma);
        final Hilo hilo2 = new Hilo(filaFinal1 + 1, filaFinal2, numeroColumnas, matriz1, matriz2, matrizSuma);
        final Hilo hilo3 = new Hilo(filaFinal2 + 1, filaFinal3, numeroColumnas, matriz1, matriz2, matrizSuma);
        final Hilo hilo4 = new Hilo(filaFinal3 + 1, numeroFilas, numeroColumnas, matriz1, matriz2,
                matrizSuma);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final long finTime = System.currentTimeMillis();

        System.out.println("Tiempo con 4 hilos: " + (finTime - iniTime));

    }
}
