package com.gregoriofer.procesos.ejemplo.hilos.pool.cached;

import com.gregoriofer.procesos.ejemplo.hilos.runnable.HiloRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Test2HilosCachedPool {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas) {

        long iniTime = System.currentTimeMillis();

        final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        final HiloRunnable runnable1 = new HiloRunnable(0, numeroFilas / 2, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Future<?> f1 = executor.submit(runnable1);
        final HiloRunnable runnable2 = new HiloRunnable(numeroFilas / 2 + 1, numeroFilas, numeroColumnas, matriz1,
                matriz2, matrizSuma);
        final Future<?> f2 = executor.submit(runnable2);

        try {
            f1.get();
            f2.get();
        } catch (final InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        final long finTime = System.currentTimeMillis();
        executor.shutdown();

        System.out.println("Tiempo con 2 hilos (cached pool): " + (finTime - iniTime));

    }
}
