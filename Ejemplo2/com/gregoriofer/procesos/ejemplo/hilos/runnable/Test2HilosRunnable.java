package com.gregoriofer.procesos.ejemplo.hilos.runnable;

public class Test2HilosRunnable {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas) {

        long iniTime = System.currentTimeMillis();

        final HiloRunnable runnable1 = new HiloRunnable(0, numeroFilas / 2, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Thread hilo1 = new Thread(runnable1);
        final HiloRunnable runnable2 = new HiloRunnable(numeroFilas / 2 + 1, numeroFilas, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Thread hilo2 = new Thread(runnable2);

        //Iniciamos los threads
        hilo1.start();
        hilo2.start();

        //Esperamos a que terminen de realizar las sumas
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final long finTime = System.currentTimeMillis();

        System.out.println("Tiempo con 2 hilos (runnable): " + (finTime - iniTime));

    }
}
