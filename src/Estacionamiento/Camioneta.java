package Estacionamiento;

/*
Clase camioneta que extiende de Coche
Contiene la implementacion especifica de los metodos "entrada" y "salida" los cuales se sobreescribieron
para que se imprimiera un mensaje diferente al de la clase padre

Camioneta: Coche de cuatro ruedas, con motor y con capacidad para transportar a una o varias personas, es un tipo de coche
 */
public class Camioneta extends Coche{
    public Camioneta(String matricula, String color) {
        super(matricula, color);
    }

    @Override
    public void entrar() {
        System.out.println("Camioneta " + getColor() + " con matrícula " + getMatricula() + " entrando...");
    }
    @Override
    public void salir() {
        System.out.println("Camioneta " + getColor() + " con matrícula " + getMatricula() + " ha salido.");
    }
}

