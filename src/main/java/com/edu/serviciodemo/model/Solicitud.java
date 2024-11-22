package com.edu.serviciodemo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @Column(nullable = false , length = 40)
    private String nombre;

    @Column(nullable = false , length = 40)
    private String apellido;

    @Column(nullable = false , length = 100)
    private String direccion;

    @Column(nullable = false , length = 9)
    private String telefono;

    @Column(nullable = false , length = 100)
    private String correo;

    @Column(nullable = false , length = 40)
    private String tipoServicio;

    @Column(nullable = false , length = 200)
    private String descripcion;

}
