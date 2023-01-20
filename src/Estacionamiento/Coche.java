package Estacionamiento;

/*
Clase abstracta Coche que implementa Vehiculo
Contiene los atributos matricula y color
Inlcuye una implementacion basica de los metodos "entrada" y "salida" que se heredaran a las clases que hereden de Coche

Coche: vehiculo de cuatro ruedas, con motor y con capacidad para transportar a una o varias personas
 */
public abstract class Coche implements Vehiculo{
    private String matricula;
    private String color;

    public Coche(String matricula , String color){
        this.matricula = matricula;
        this.color = color;
    }

    public String getMatricula(){
        return matricula;
    }

    public String getColor(){
        return color;
    }
    @Override
    public void entrar() {
        System.out.println("Coche " + getColor() + "con matrícula " + getMatricula() + " ha entrado");
    }

    @Override
    public void salir() {

        System.out.println("Coche con matrícula " + getMatricula() + " ha salido");
    }

}
