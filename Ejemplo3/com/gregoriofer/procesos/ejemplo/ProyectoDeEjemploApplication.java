package com.gregoriofer.procesos.ejemplo;

import com.gregoriofer.procesos.ejemplo.hilos.pool.Test2HilosPoolDe10;
import com.gregoriofer.procesos.ejemplo.hilos.pool.Test4HilosPoolDe10;
import com.gregoriofer.procesos.ejemplo.hilos.pool.TestNHilosPoolDe10;
import com.gregoriofer.procesos.ejemplo.hilos.runnable.Test2HilosRunnable;
import com.gregoriofer.procesos.ejemplo.hilos.runnable.Test4HilosRunnable;
import com.gregoriofer.procesos.ejemplo.hilos.runnable.TestNHilosRunnable;
import com.gregoriofer.procesos.ejemplo.hilos.thread.Test2Hilos;
import com.gregoriofer.procesos.ejemplo.hilos.thread.Test4Hilos;
import com.gregoriofer.procesos.ejemplo.hilos.thread.TestNHilos;
import com.gregoriofer.procesos.ejemplo.secuencial.TestSecuencial;
import com.gregoriofer.procesos.ejemplo.utilidades.CreadorDeMatrices;

public class ProyectoDeEjemploApplication {

    private final static Integer NUMERO_FILAS = 10000;
    private final static Integer NUMERO_COLUMNAS = 10000;

    private final static int[][] MATRIZ1 = CreadorDeMatrices.crear(NUMERO_FILAS, NUMERO_COLUMNAS);
    private final static int[][] MATRIZ2 = CreadorDeMatrices.crear(NUMERO_FILAS, NUMERO_COLUMNAS);

    public static void main(String[] args) {
        final int[][] matrizSuma = new int[NUMERO_FILAS][NUMERO_COLUMNAS];

        TestSecuencial.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS);
        Test2Hilos.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS);
        Test2HilosRunnable.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS);
        Test2HilosPoolDe10.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS);
        Test4Hilos.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS);
        Test4HilosRunnable.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS);
        Test4HilosPoolDe10.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS);
        TestNHilos.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS, 4);
        TestNHilosRunnable.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS, 4);
        TestNHilosPoolDe10.test(MATRIZ1, MATRIZ2, matrizSuma, NUMERO_FILAS, NUMERO_COLUMNAS, 4);
    }
}
