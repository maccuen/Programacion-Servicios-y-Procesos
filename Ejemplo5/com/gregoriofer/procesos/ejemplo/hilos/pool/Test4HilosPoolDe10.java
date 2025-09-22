package com.gregoriofer.procesos.ejemplo.hilos.pool;

import com.gregoriofer.procesos.ejemplo.hilos.runnable.HiloRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Test4HilosPoolDe10 {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas) {

        final int filaFinal1 = numeroFilas / 4;
        final int filaFinal2 = numeroFilas / 2;
        final int filaFinal3 = 3 * numeroFilas / 4;

        long iniTime = System.currentTimeMillis();

        final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        final HiloRunnable runnable1 = new HiloRunnable(0, filaFinal1, numeroColumnas, matriz1, matriz2,
                matrizSuma);
        final Future<?> f1 = executor.submit(runnable1);
        final HiloRunnable runnable2 = new HiloRunnable(filaFinal1 + 1, filaFinal2, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Future<?> f2 = executor.submit(runnable2);
        final HiloRunnable runnable3 = new HiloRunnable(filaFinal2 + 1, filaFinal3, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Future<?> f3 = executor.submit(runnable3);
        final HiloRunnable runnable4 = new HiloRunnable(filaFinal3 + 1, numeroFilas, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Future<?> f4 = executor.submit(runnable4);

        try {
            f1.get();
            f2.get();
            f3.get();
            f4.get();
        } catch (final InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        final long finTime = System.currentTimeMillis();
        executor.shutdown();

        System.out.println("Tiempo con 4 hilos (pool): " + (finTime - iniTime));

    }
}
