package com.academy.spring.batch.configuraciones;

import com.academy.spring.batch.entidades.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ProcesadorClientes implements ItemProcessor<Cliente, Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        return cliente;
        
    }
}
