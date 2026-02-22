package com.gregoriofer.procesos.ejemplo.repository;

public interface SyncRepository {

    Integer sumaSincrona(final Integer operador1, final Integer operador2);

    void sumaAsincrona(final Integer operador1, final Integer operador2);
}
