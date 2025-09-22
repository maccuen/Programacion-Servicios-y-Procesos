package com.gregoriofer.procesos.ejemplo.hilos.thread;

import com.gregoriofer.procesos.ejemplo.utilidades.SumadorDeMatrices;

public class Hilo extends Thread {
    protected int filaInicial;
    protected int filaFinal;
    protected int numeroDeColumnas;
    protected int[][] matriz1;
    protected int[][] matriz2;
    protected int[][] matrizSuma;

    public Hilo(final int filaInicial, final int filaFinal, final int numeroDeColumnas, final int[][] matriz1,
                final int[][] matriz2, final int[][] matrizSuma) {
        this.filaInicial = filaInicial;
        this.filaFinal = filaFinal;
        this.numeroDeColumnas = numeroDeColumnas;
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matrizSuma = matrizSuma;
    }

    public void run() {
        SumadorDeMatrices.sumarParcial(filaInicial, filaFinal, numeroDeColumnas, matriz1, matriz2, matrizSuma);
    }
}
