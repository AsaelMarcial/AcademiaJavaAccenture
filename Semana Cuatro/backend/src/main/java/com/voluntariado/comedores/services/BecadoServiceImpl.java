package com.voluntariado.comedores.services;

import com.voluntariado.comedores.dto.BecadoDTO;
import com.voluntariado.comedores.entities.Becado;
import com.voluntariado.comedores.repositories.BecadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BecadoServiceImpl implements BecadoService {

    @Autowired
    private BecadoRepository becadoRepository;

    @Override
    public BecadoDTO crearBecado(BecadoDTO becadoDTO) {
        Becado becado = mapBecado.apply(becadoDTO);
        Becado becadoGuardado = becadoRepository.save(becado);
        return mapBecadoDTO.apply(becadoGuardado);
    }


    @Override
    public List<BecadoDTO> listarBecados() {
        List<Becado> becados = becadoRepository.findAll();
        return becados.stream().map(becado -> mapBecadoDTO.apply(becado)).collect(Collectors.toList());
    }

    //Metodo para mapear DTO a Entity
    Function<Becado, BecadoDTO> mapBecadoDTO = becado -> {
        BecadoDTO becadoDTO = new BecadoDTO();
        becadoDTO.setId(becado.getId());
        becadoDTO.setFirstName(becado.getFirstName());
        becadoDTO.setLastName(becado.getLastName());
        becadoDTO.setCarrera(becado.getCarrera());
        becadoDTO.setCredito(becado.getCredito());
        becadoDTO.setFechaInicio(becado.getFechaInicio());
        becadoDTO.setFechaFin(becado.getFechaFin());
        return becadoDTO;
    };

    //Metodo para mapear Entity a DTO
    Function<BecadoDTO, Becado> mapBecado = becadoDTO -> {
        Becado becado = new Becado();
        becado.setFirstName(becadoDTO.getFirstName());
        becado.setLastName(becadoDTO.getLastName());
        becado.setCarrera(becadoDTO.getCarrera());
        becado.setCredito(becadoDTO.getCredito());
        becado.setFechaInicio(becadoDTO.getFechaInicio());
        becado.setFechaFin(becadoDTO.getFechaFin());
        return becado;
    };

}
