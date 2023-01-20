package Estacionamiento;

/*
La clase principal es la clase que se encarga de ejecutar el programa
Esta clase crea una instancia de EstacionamientoServicio y le pasa una instancia de Estacionamiento como parametro en su constructor
Agrega un arreglo de Coches (Sedan y Camioneta) y llama al metodo estacionar de EstacionamientoServicio para cada uno de los vehiculos en el arreglo

Los coches se inyectan en la clase EstacionamientoServicio y se pasan como parametro en el metodo estacionar de la clase Estacionamiento


@author: Asael Marcial Grajales
@version: 1.0
@date: 19/01/2023
 */
public class Principal{
    public static void main(String[] args) {
        Estacionamiento elMofles = Estacionamiento.getInstance();
        EstacionamientoServicio estacionamientoServicio = new EstacionamientoServicio(elMofles);
        Coche[] coches = new Coche[]{
                new Sedan("VCS-1", "Rojo"),
                new Sedan("VCS-2", "Azul"),
                new Sedan("VCS-3", "Verde"),
                new Sedan("VCS-4", "Amarillo"),
                new Camioneta("VCC-1", "Rojo"),
                new Camioneta("VCC-2", "Azul"),
                new Camioneta("VCC-3", "Verde"),
                new Camioneta("VCC-4", "Amarillo"),
        };

        for (Coche c: coches) {
            if(estacionamientoServicio.estacionar(c)){
                System.out.println("Vehiculo " + c.getColor() + " con matriculas " + c.getMatricula() + " ha entrado");
            }else{
                System.out.println("No hay espacio");
                break;
            }
        }
        estacionamientoServicio.salir(coches[0]);
        estacionamientoServicio.estacionar(coches[1]);
        estacionamientoServicio.salir(coches[2]);
        estacionamientoServicio.estacionar(coches[0]);
        estacionamientoServicio.salir(coches[2]);
    }
}