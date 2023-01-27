package com.vehiculos.vehiculos.models;

public class Vehiculo {
    private int id;
    private int idPersona;
    private String marca;
    private String color;
    private String matricula;

    public Vehiculo(int id, int idPersona, String marca, String color, String matricula) {
        this.id = id;
        this.idPersona = idPersona;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public Vehiculo(int idPersona, String marca, String color, String matricula) {
        this.idPersona = idPersona;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public Vehiculo(String marca, String color, String matricula) {
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
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

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", idPersona=" + idPersona +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
