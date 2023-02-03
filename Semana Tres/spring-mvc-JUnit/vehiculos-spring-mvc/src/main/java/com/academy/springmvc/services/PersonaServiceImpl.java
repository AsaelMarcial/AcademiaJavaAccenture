package com.academy.springmvc.services;

import com.academy.springmvc.dao.PersonaDAO;
import com.academy.springmvc.entities.Personas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
   @Autowired
   private PersonaDAO personaDAO;

    @Override
    @Transactional
    public List<Personas> getPersonas() {
        return personaDAO.getPersonas();
    }

    @Override
    @Transactional
    public boolean savePersona(Personas persona) {
        return personaDAO.savePersona(persona);
    }

    @Override
    @Transactional
    public Personas getPersona(int id) {
        return personaDAO.getPersona(id);
    }

    @Override
    @Transactional
    public void deletePersona(int id) {
        personaDAO.deletePersona(id);
    }
}
