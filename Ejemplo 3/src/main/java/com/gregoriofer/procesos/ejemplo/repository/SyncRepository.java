package com.gregoriofer.procesos.ejemplo.repository;

import com.gregoriofer.procesos.ejemplo.dto.PeticionDeSumaSencilla;

import java.util.List;

public interface SyncRepository {

    Integer sumaSincrona(final Integer operador1, final Integer operador2);

    List<Integer> sumaSincronaMultiple(final List<PeticionDeSumaSencilla> operaciones) throws Exception;
    void sumaAsincrona(final Integer operador1, final Integer operador2);
}
