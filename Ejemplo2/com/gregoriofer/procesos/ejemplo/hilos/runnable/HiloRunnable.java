package com.gregoriofer.procesos.ejemplo.hilos.runnable;

import com.gregoriofer.procesos.ejemplo.hilos.thread.Hilo;

public class HiloRunnable extends Hilo implements Runnable {

    public HiloRunnable(final int filaInicial, final int filaFinal, final int numeroDeColumnas, final int[][] matriz1,
                        final int[][] matriz2, final int[][] matrizSuma) {
        super(filaInicial, filaFinal, numeroDeColumnas, matriz1, matriz2, matrizSuma);
    }
}
