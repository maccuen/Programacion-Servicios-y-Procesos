package com.gregoriofer.procesos.ejemplo.controller;

import com.gregoriofer.procesos.ejemplo.dto.EmpleadoDto;
import com.gregoriofer.procesos.ejemplo.utils.EmpleadoUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class HEController {

    @GetMapping("/listar")
    public List<EmpleadoDto> listar() {
        final List<EmpleadoDto> empleados = EmpleadoUtils.generarEjemplos();
        return empleados;
    }
}
