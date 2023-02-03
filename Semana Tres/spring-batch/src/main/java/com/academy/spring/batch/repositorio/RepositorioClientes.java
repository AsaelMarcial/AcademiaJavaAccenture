package com.academy.spring.batch.repositorio;

import com.academy.spring.batch.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioClientes extends JpaRepository<Cliente,Integer> {
}
