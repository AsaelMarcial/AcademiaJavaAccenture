package com.academy.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.springmvc.entities.Personas;

import java.util.List;



@Repository
public class PersonaDAOImpl implements PersonaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Personas> getPersonas() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("from Personas order by nombre", Personas.class);
        List<Personas> personas = query.getResultList();

        return personas;
    }

    @Override
    public boolean savePersona(Personas persona) {
        if (persona.getId() == 0) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.save(persona);
        } else {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.update(persona);
        }
        return true;
    }

    @Override
    public Personas getPersona(int id) {

        Session currentSession = sessionFactory.getCurrentSession();
        Personas persona = currentSession.get(Personas.class, id);
        return persona;
    }

    @Override
    public void deletePersona(int id) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Personas where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
