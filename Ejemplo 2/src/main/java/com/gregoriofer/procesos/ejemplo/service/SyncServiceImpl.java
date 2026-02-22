package com.gregoriofer.procesos.ejemplo.service;

import com.gregoriofer.procesos.ejemplo.repository.SyncRepository;
import org.springframework.stereotype.Service;

@Service
public class SyncServiceImpl implements SyncService {

    private final SyncRepository syncRepository;

    public SyncServiceImpl(final SyncRepository syncRepository) {
        this.syncRepository = syncRepository;
    }

    public Integer suma(final Integer operador1, final Integer operador2) {
        return syncRepository.suma(operador1, operador2);
    }
}
