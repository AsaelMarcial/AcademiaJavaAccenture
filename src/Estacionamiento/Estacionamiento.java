package Estacionamiento;

import java.util.ArrayList;
import java.util.List;

/*
Esta clase implementa el patron de diseño Singleton por lo que solo puede haber una instancia de esta clase y
proporciona un punto de acceso unico para todas las clases que la necesiten.
Esta clase tiene el atributo aforo que representa la cantidad de vehiculos que pueden estar en el estacionamiento y el atributo
ocupados que representa la cantidad de vehiculos que estan en el estacionamiento

No es necesario crear una instancia de vehiculo ya que es proporcionada por la clase principal
y se recibe como parametro en metodo estacionar de esta clase y en el metodo salir de esta clase

 */
public class Estacionamiento{
    private static Estacionamiento instance;
    private List<Vehiculo> vehiculosEstacionados;
    private int aforo;
    private int ocupados;

    private Estacionamiento(int aforo){
        this.aforo = aforo;
        this.ocupados = 0;
        this.vehiculosEstacionados = new ArrayList<Vehiculo>();
    }

    public static Estacionamiento getInstance(){
        if(instance == null){
            instance = new Estacionamiento(10);
        }
        return instance;
    }

    public boolean estacionar(Vehiculo vehiculo){
        if(ocupados < aforo && !vehiculosEstacionados.contains(vehiculo)){
            vehiculosEstacionados.add(vehiculo);
            ocupados++;
            vehiculo.entrar();
            return true;
        }else{
            if (vehiculosEstacionados.contains(vehiculo)){
                System.out.println("El vehiculo ya esta estacionado");
            }else{
                System.out.println("El estacionamiento esta lleno");
            }
            return false;
        }
    }

    public void salir(Vehiculo vehiculo){
        vehiculo.salir();
        ocupados--;
    }

}