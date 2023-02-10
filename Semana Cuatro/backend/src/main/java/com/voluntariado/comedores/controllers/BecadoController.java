package com.voluntariado.comedores.controllers;

import com.voluntariado.comedores.dto.BecadoDTO;
import com.voluntariado.comedores.services.BecadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/becados")
public class BecadoController {

    @Autowired
    private BecadoService becadoService;

    @PostMapping
    public ResponseEntity<BecadoDTO> guardarBecado(@RequestBody BecadoDTO becadoDTO){
        return new ResponseEntity<>(becadoService.crearBecado(becadoDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public List<BecadoDTO> listarBecados(){
        return becadoService.listarBecados();
    }


}
