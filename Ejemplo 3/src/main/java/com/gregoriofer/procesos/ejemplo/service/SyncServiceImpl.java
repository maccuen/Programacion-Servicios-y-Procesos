package com.gregoriofer.procesos.ejemplo.service;

import com.gregoriofer.procesos.ejemplo.dto.PeticionDeSumaSencilla;
import com.gregoriofer.procesos.ejemplo.repository.SyncRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyncServiceImpl implements SyncService {

    private final SyncRepository syncRepository;

    public SyncServiceImpl(final SyncRepository syncRepository) {
        this.syncRepository = syncRepository;
    }

    public Integer sumaSincrona(final Integer operador1, final Integer operador2) {
        return syncRepository.sumaSincrona(operador1, operador2);
    }

    @Override
    public List<Integer> sumaSincronaMultiple(final List<PeticionDeSumaSencilla> operaciones) throws Exception {
        return syncRepository.sumaSincronaMultiple(operaciones);
    }

    public void sumaAsincrona(final Integer operador1, final Integer operador2) {
        syncRepository.sumaAsincrona(operador1, operador2);
    }
}
