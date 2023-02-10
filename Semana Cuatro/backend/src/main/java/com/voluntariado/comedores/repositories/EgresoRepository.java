package com.voluntariado.comedores.repositories;


import com.voluntariado.comedores.entities.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
public interface EgresoRepository extends JpaRepository<Egreso, Long> {
}
