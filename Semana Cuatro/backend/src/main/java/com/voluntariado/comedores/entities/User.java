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
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="firstName" , nullable = false)
    private String firstName;

    @Column(name="lastName" , nullable = false)
    private String lastName;

    @Column(name="email" , nullable = false)
    private String email;

    @Column(name="username" , nullable = false)
    private String username;

    @Column(name="rol" , nullable = false)
    private String rol;
}
