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
@Table(name="ingreso")
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="concepto" , nullable = false)
    private String concepto;

    @Column(name="monto" , nullable = false)
    private double monto;

    @Column(name="referencia" , nullable = false)
    private String referencia;
}
