package Estacionamiento;

/*
Clase sendan que extiende de Coche
Contiene la implementacion especifica de los metodos "entrada" y "salida" los cuales se sobreescribieron
para que se imprimiera un mensaje diferente al de la clase padre

Sedan: coche de cuatro puertas, con motor y con capacidad para transportar a una o varias personas, es un tipo de coche
 */
public class Sedan extends Coche{

    public Sedan(String matricula, String color) {
        super(matricula, color);
    }

    @Override
    public void entrar() {
        System.out.println("Sedan " + getColor() + " con matrícula " + getMatricula() + " entrando...");
    }

    @Override
    public void salir() {
        System.out.println("Sedan con matrícula " + getMatricula() + " ha salido.");
    }
}