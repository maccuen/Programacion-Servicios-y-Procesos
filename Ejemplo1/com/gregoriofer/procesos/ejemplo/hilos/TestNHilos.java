package com.gregoriofer.procesos.ejemplo.hilos;

import java.util.ArrayList;
import java.util.List;

public class TestNHilos {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas, final int numeroDeHilos) {

        long iniTime = System.currentTimeMillis();

        final List<Hilo> hilos = new ArrayList<>();
        for (int i = 0; i < numeroDeHilos; i++) {
            final int filaInicial = i * numeroFilas / numeroDeHilos + 1;
            final int filaFinal = (i + 1) * numeroFilas / numeroDeHilos;
            final Hilo hilo = new Hilo(filaInicial, filaFinal, numeroColumnas, matriz1, matriz2, matrizSuma);
            hilos.add(hilo);
        }

        try {
            for (final Hilo hilo : hilos) {
                hilo.start();
            }
            for (final Hilo hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final long finTime = System.currentTimeMillis();

        System.out.println("Tiempo con " + numeroDeHilos + " hilos: " + (finTime - iniTime));

    }
}
