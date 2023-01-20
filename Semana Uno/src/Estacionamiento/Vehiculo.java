package Estacionamiento;

/*
Interface Vehiculo
define los metodos "entrada" y "salida", que se implementaran en las clases que implementen esta interfaz

El polimorfismo nos permite que un objeto de una clase padre o interfaz se comporte de difererentes maneras dependiendo
de la clase hija que lo implemente, en este caso un objeto de la clase Estacionamiento.Coche puede ser tratado como un objeto de la clase Estacionamiento.Vehiculo.
Tambien nos permite que el codigo sea mas felixble y escalable, ya que podemos agregar nuevas clases hijas que implementen la interfaz
y que hereden de la clase padre sin tener que modificar el codigo de la clase padre o de las clases que implementan la interfaz.

Vehiculo: medio de transporte de personas o cosas
 */
public interface Vehiculo {
    public void entrar();
    public void salir();

}
