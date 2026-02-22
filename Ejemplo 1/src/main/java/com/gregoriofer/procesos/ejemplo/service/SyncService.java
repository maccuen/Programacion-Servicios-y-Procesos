package com.gregoriofer.procesos.ejemplo.service;

public interface SyncService {

    Integer sumaSincrona(final Integer operador1, final Integer operador2);

    void sumaAsincrona(final Integer operador1, final Integer operador2);
}
