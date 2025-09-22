package com.gregoriofer.procesos.ejemplo.hilos.runnable;

public class Test4HilosRunnable {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas) {

        final int filaFinal1 = numeroFilas / 4;
        final int filaFinal2 = numeroFilas / 2;
        final int filaFinal3 = 3 * numeroFilas / 4;

        long iniTime = System.currentTimeMillis();

        final HiloRunnable runnable1 = new HiloRunnable(0, filaFinal1, numeroColumnas, matriz1, matriz2,
                matrizSuma);
        final Thread hilo1 = new Thread(runnable1);
        final HiloRunnable runnable2 = new HiloRunnable(filaFinal1 + 1, filaFinal2, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Thread hilo2 = new Thread(runnable2);
        final HiloRunnable runnable3 = new HiloRunnable(filaFinal2 + 1, filaFinal3, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Thread hilo3 = new Thread(runnable3);
        final HiloRunnable runnable4 = new HiloRunnable(filaFinal3 + 1, numeroFilas, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Thread hilo4 = new Thread(runnable4);

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

        System.out.println("Tiempo con 4 hilos (runnable): " + (finTime - iniTime));

    }
}
