package com.voluntariado.comedores.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="egreso")
public class Egreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="proveedor" , nullable = false)
    private String proveedor;

    @Column(name="descripcion" , nullable = false)
    private String descripcion;

    @Column(name="partida" , nullable = false)
    private String partida;

    @Column(name="total" , nullable = false)
    private double total;

    @Column(name="factura" , nullable = false)
    private String factura;
}
