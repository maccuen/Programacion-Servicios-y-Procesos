package com.gregoriofer.procesos.ejemplo.service;

import com.gregoriofer.procesos.ejemplo.repository.SyncRepository;
import org.springframework.stereotype.Service;

@Service
public class SyncServiceImpl implements SyncService {

    private final SyncRepository syncRepository;

    public SyncServiceImpl(final SyncRepository syncRepository) {
        this.syncRepository = syncRepository;
    }

    public Integer sumaSincrona(final Integer operador1, final Integer operador2) {
        return syncRepository.sumaSincrona(operador1, operador2);
    }

    public void sumaAsincrona(final Integer operador1, final Integer operador2) {
        syncRepository.sumaAsincrona(operador1, operador2);
    }
}
