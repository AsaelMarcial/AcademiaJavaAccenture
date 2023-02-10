package com.voluntariado.comedores.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException{

        private static final long serialVersionUID = 1L;
        private String nombreRecurso;
        private String nombreCampo;
        private Object valorCampo;

        public ResourceNotFoundExeption(String nombreRecurso, String nombreCampo, Object valorCampo){
            super(String.format("%s No encontrado con : %s : '%s'", nombreRecurso, nombreCampo, valorCampo));
            this.nombreRecurso = nombreRecurso;
            this.nombreCampo = nombreCampo;
            this.valorCampo = valorCampo;
        }

}
