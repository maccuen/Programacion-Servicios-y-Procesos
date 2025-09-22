package com.gregoriofer.procesos.ejemplo.hilos.data;

import com.gregoriofer.procesos.ejemplo.hilos.runnable.HiloRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Test4HilosCachedPoolData {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas) {

        final int filaFinal1 = numeroFilas / 4;
        final int filaFinal2 = numeroFilas / 2;
        final int filaFinal3 = 3 * numeroFilas / 4;

        long iniTime = System.currentTimeMillis();

        final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        final HiloData runnable1 = new HiloData(0, filaFinal1, numeroColumnas, matriz1, matriz2, matrizSuma);
        final Future<?> f1 = executor.submit(runnable1);
        final HiloData runnable2 = new HiloData(filaFinal1 + 1, filaFinal2, numeroColumnas, matriz1, matriz2,
                matrizSuma);
        final Future<?> f2 = executor.submit(runnable2);
        final HiloData runnable3 = new HiloData(filaFinal2 + 1, filaFinal3, numeroColumnas, matriz1, matriz2,
                matrizSuma);
        final Future<?> f3 = executor.submit(runnable3);
        final HiloData runnable4 = new HiloData(filaFinal3 + 1, numeroFilas, numeroColumnas, matriz1, matriz2,
                matrizSuma);
        final Future<?> f4 = executor.submit(runnable4);

        try {
            f1.get();
            f2.get();
            f3.get();
            f4.get();
        } catch (final InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //System.out.println(runnable1.haTerminado());
        //System.out.println(runnable2.haTerminado());
        //System.out.println(runnable3.haTerminado());
        //System.out.println(runnable4.haTerminado());

        final long finTime = System.currentTimeMillis();
        executor.shutdown();

        System.out.println("Tiempo con 4 hilos (cached pool data): " + (finTime - iniTime));

    }
}
