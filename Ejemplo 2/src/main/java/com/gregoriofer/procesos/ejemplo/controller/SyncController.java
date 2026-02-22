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

    @GetMapping("/suma")
    public Integer suma(final Integer operador1, final Integer operador2) {
        return syncService.suma(operador1, operador2);
    }
}
