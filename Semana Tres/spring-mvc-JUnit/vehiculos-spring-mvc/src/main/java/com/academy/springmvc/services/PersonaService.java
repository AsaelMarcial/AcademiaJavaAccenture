package com.academy.springmvc.services;

import com.academy.springmvc.entities.Personas;

import java.util.List;

public interface PersonaService {
    List<Personas> getPersonas();
    boolean savePersona(Personas persona);
    Personas getPersona(int id);
    void deletePersona(int id);

}
