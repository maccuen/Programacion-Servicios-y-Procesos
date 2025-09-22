package com.gregoriofer.procesos.ejemplo.hilos.data;

import com.gregoriofer.procesos.ejemplo.hilos.runnable.HiloRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TestNHilosCachedPoolData {

    public static void test(final int[][] matriz1, final int[][] matriz2, final int[][] matrizSuma,
                            final int numeroFilas, final int numeroColumnas, final int numeroDeHilos) {

        long iniTime = System.currentTimeMillis();

        final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        final List<HiloData> hilos = new ArrayList<>();
        final List<Future<?>> hilosFuture = new ArrayList<>();
        for (int i = 0; i < numeroDeHilos; i++) {
            final int filaInicial = i * numeroFilas / numeroDeHilos + 1;
            final int filaFinal = (i + 1) * numeroFilas / numeroDeHilos;
            final HiloData runnable = new HiloData(filaInicial, filaFinal, numeroColumnas, matriz1, matriz2, matrizSuma);
            hilos.add(runnable);
            final Future<?> f = executor.submit(runnable);
            hilosFuture.add(f);
        }

        try {
            for (final Future<?> hilo : hilosFuture) {
                hilo.get();
            }
        } catch (final InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        /*for (final HiloData hilo : hilos) {
            System.out.println(hilo.haTerminado());
        }*/

        final long finTime = System.currentTimeMillis();
        executor.shutdown();

        System.out.println("Tiempo con " + numeroDeHilos + " hilos (cached pool data): " + (finTime - iniTime));
    }
}
