package com.academy.springmvc.dao;

import com.academy.springmvc.entities.Personas;

import java.util.List;

public interface PersonaDAO {

    public List<Personas> getPersonas();
    public boolean savePersona(Personas persona);
    public Personas getPersona(int id);
    public void deletePersona(int id);

}
