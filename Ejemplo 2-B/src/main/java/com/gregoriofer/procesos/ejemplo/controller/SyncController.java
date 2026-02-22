package com.gregoriofer.procesos.ejemplo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/sync")
public class SyncController {

    @GetMapping("/suma")
    public Integer suma(final Integer operador1, final Integer operador2) {
        return operador1 + operador2;
    }
}
