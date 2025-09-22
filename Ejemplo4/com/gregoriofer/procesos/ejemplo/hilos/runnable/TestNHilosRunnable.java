package com.gregoriofer.procesos.ejemplo.hilos.runnable;

import java.util.ArrayList;
import java.util.List;

public class TestNHilosRunnable {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas, final int numeroDeHilos) {

        long iniTime = System.currentTimeMillis();

        final List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < numeroDeHilos; i++) {
            final int filaInicial = i * numeroFilas / numeroDeHilos + 1;
            final int filaFinal = (i + 1) * numeroFilas / numeroDeHilos;
            final HiloRunnable runnable = new HiloRunnable(filaInicial, filaFinal, numeroColumnas, matriz1, matriz2,
                    matrizSuma);
            final Thread hilo = new Thread(runnable);
            hilos.add(hilo);
        }

        try {
            for (final Thread hilo : hilos) {
                hilo.start();
            }
            for (final Thread hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final long finTime = System.currentTimeMillis();

        System.out.println("Tiempo con " + numeroDeHilos + " hilos (runnable): " + (finTime - iniTime));

    }
}
