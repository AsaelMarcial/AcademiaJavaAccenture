package com.voluntariado.comedores.services;

import com.voluntariado.comedores.dto.BecadoDTO;

import java.util.List;

public interface BecadoService {

    public BecadoDTO crearBecado(BecadoDTO becadoDTO);

    public List<BecadoDTO> listarBecados();

}
