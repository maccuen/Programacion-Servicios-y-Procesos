package com.gregoriofer.procesos.ejemplo.hilos;

public class Test2Hilos {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas) {

        long iniTime = System.currentTimeMillis();
        final Hilo hilo1 = new Hilo(0, numeroFilas / 2, numeroColumnas, matriz1, matriz2, matrizSuma);
        final Hilo hilo2 = new Hilo(numeroFilas / 2 + 1, numeroFilas, numeroColumnas, matriz1, matriz2,
                matrizSuma);

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

        System.out.println("Tiempo con 2 hilos: " + (finTime - iniTime));

    }
}
