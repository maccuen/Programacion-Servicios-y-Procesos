package com.gregoriofer.procesos.ejemplo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpleadoDto {

    private String codigo;

    private String nombre;

    private String apellidos;

    private String telefono;

    private String dni;

    private String puesto;
}
