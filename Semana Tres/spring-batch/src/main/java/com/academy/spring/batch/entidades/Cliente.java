package com.academy.spring.batch.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "CORREO")
    private String email;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "FECHA")
    private String fecha;
    
}
