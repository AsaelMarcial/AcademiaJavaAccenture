package com.academy.springmvc.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Vehiculos", schema = "vehiculos")
public class Vehiculos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idPersona" )
    private Integer idPersona;
    @Basic
    @Column(name = "marca")
    private String marca;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "matricula")
    private String matricula;
    @ManyToOne
    @JoinColumn(name = "idPersona", referencedColumnName = "id", insertable = false, updatable = false)
    private Personas personasByIdPersona;

    public Vehiculos(int idPersona, String marca, String color, String matricula) {
        this.idPersona = idPersona;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public Vehiculos(int id, int idPersona, String marca, String color, String matricula) {
        this.id = id;
        this.idPersona = idPersona;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public Vehiculos() {

    }
}
