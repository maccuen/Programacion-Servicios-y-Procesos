package com.gregoriofer.procesos.ejemplo.hilos.data;

import com.gregoriofer.procesos.ejemplo.hilos.runnable.HiloRunnable;

public class HiloData extends HiloRunnable {

    private boolean haTerminado = false;

    public HiloData(final int filaInicial, final int filaFinal, final int numeroDeColumnas, final int[][] matriz1,
                    final int[][] matriz2, final int[][] matrizSuma) {
        super(filaInicial, filaFinal, numeroDeColumnas, matriz1, matriz2, matrizSuma);
    }

    public boolean haTerminado() {
        return haTerminado;
    }

    public void run() {
        super.run();
        haTerminado = true;
    }
}
