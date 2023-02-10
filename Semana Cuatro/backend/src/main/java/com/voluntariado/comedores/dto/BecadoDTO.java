package com.voluntariado.comedores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BecadoDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String carrera;
    private String credito;
    private String fechaInicio;
    private String fechaFin;
}
