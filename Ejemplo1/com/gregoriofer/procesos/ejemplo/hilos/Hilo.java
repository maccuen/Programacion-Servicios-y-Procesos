package com.gregoriofer.procesos.ejemplo.hilos;

import com.gregoriofer.procesos.ejemplo.utilidades.SumadorDeMatrices;

public class Hilo extends Thread {
    private int filaInicial;
    private int filaFinal;
    private int numeroDeColumnas;
    private int[][] matriz1;
    private int[][] matriz2;
    private int[][] matrizSuma;

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
