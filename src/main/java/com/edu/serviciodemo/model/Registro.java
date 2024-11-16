package com.edu.serviciodemo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;

    @Column(nullable = false , length = 100)
    private String name;

    @Column(nullable = false , length = 100)
    private String apellido;

    @Column(nullable = false , length = 100)
    private String correo;

    @Column(nullable = false , length = 9)
    private String dni;

    @Column(nullable = false , length = 200)
    private String descripcion;

    @Column(nullable = false)
    private Date fechaRegistro;

    @Column
    private boolean enabled;



}
