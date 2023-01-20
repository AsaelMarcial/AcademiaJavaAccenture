package Estacionamiento;

/*
La clase EstacionamientoServicio utiliza inyección de dependencias para poder utilizar el estacionamiento
Esta clase proporciona una instancia de estacionamiento en su constructor en lugar de crear una instancia de estacionamiento dentro de la clase

La inyección de dependencias nos permite crear una clase que no depende de la implementación de otra clase,
en este caso Estacionamiento Servicio no depende de la implementación de Estacionamiento, esto nos ayuda a desacoplar las clases
y a hacer que el código sea más mantenible y flexible
 */
public class EstacionamientoServicio {
    private Estacionamiento estacionamiento;

    public EstacionamientoServicio(Estacionamiento estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public boolean estacionar(Vehiculo vehiculo){
        return estacionamiento.estacionar(vehiculo);
    }

    public void salir(Vehiculo vehiculo){
        estacionamiento.salir(vehiculo);
    }
}
