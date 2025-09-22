package com.gregoriofer.procesos.ejemplo.hilos.pool;

import com.gregoriofer.procesos.ejemplo.hilos.runnable.HiloRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TestNHilosPoolDe10 {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas, final int numeroDeHilos) {

        long iniTime = System.currentTimeMillis();

        final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        final List<Future<?>> hilos = new ArrayList<>();
        for (int i = 0; i < numeroDeHilos; i++) {
            final int filaInicial = i * numeroFilas / numeroDeHilos + 1;
            final int filaFinal = (i + 1) * numeroFilas / numeroDeHilos;
            final HiloRunnable runnable = new HiloRunnable(filaInicial, filaFinal, numeroColumnas, matriz1, matriz2,
                    matrizSuma);
            final Future<?> f = executor.submit(runnable);
            hilos.add(f);
        }

        try {
            for (final Future<?> hilo : hilos) {
                hilo.get();
            }
        } catch (final InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        final long finTime = System.currentTimeMillis();
        executor.shutdown();

        System.out.println("Tiempo con " + numeroDeHilos + " hilos (pool): " + (finTime - iniTime));

    }
}
