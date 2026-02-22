package com.gregoriofer.procesos.ejemplo.controller;

import com.gregoriofer.procesos.ejemplo.service.SyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sync")
public class SyncController {

    private final SyncService syncService;

    public SyncController(final SyncService syncService) {
        this.syncService = syncService;
    }

    @GetMapping("/suma-sync")
    public Integer sumaSincrona(final Integer operador1, final Integer operador2) {
        return syncService.sumaSincrona(operador1, operador2);
    }

    @GetMapping("/suma-async")
    public void sumaAsincrona(final Integer operador1, final Integer operador2) {
        syncService.sumaAsincrona(operador1, operador2);
    }
}
