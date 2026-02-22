package com.gregoriofer.procesos.ejemplo.utils;

import com.gregoriofer.procesos.ejemplo.dto.EmpleadoDto;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoUtils {

    private EmpleadoUtils() {

    }

    public static List<EmpleadoDto> generarEjemplos() {
        final List<EmpleadoDto> empleados = new ArrayList<>();

        empleados.add(new EmpleadoDto("E123", "Juan", "García", "983454545",
                "123456789Z", "Analista"));
        empleados.add(new EmpleadoDto("E124", "Pepe", "García", "983656585",
                "723489789Z", "Desarrollador"));

        return empleados;
    }
}
