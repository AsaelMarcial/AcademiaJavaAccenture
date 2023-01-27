package com.vehiculos.vehiculos.models;

public class VehiculoList {
    private int id;
    private int idPersona;
    private String marca;
    private String color;
    private String matricula;
    private String nombre;

    public VehiculoList(int id, int idPersona, String marca, String color, String matricula, String nombre) {
        this.id = id;
        this.idPersona = idPersona;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "VehiculoList{" +
                "id=" + id +
                ", idPersona=" + idPersona +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
