package com.gregoriofer.procesos.ejemplo.controller;

import com.gregoriofer.procesos.ejemplo.dto.PeticionDeSumaSencilla;
import com.gregoriofer.procesos.ejemplo.service.SyncService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sync")
public class SyncController {

    private SyncService syncService;

    public SyncController(final SyncService syncService) {
        this.syncService = syncService;
    }

    @GetMapping("/suma-sync")
    public Integer sumaSincrona(final Integer operador1, final Integer operador2) {
        return syncService.sumaSincrona(operador1, operador2);
    }

    @PostMapping("/suma-sync-multiple")
    public List<Integer> sumaSincronaMultiple(@RequestBody final List<PeticionDeSumaSencilla> operaciones) throws Exception {
        return syncService.sumaSincronaMultiple(operaciones);
    }

    @GetMapping("/suma-async")
    public void sumaAsincrona(final Integer operador1, final Integer operador2) {
        syncService.sumaAsincrona(operador1, operador2);
    }
}
