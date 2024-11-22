package com.edu.serviciodemo.model;

import com.edu.serviciodemo.util.CustomLocalDateDeserializer;
import com.edu.serviciodemo.util.CustomLocalDateSerializer;
import com.edu.serviciodemo.util.CustomLocalTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @Column(nullable = false , length = 40)
    private String nombre;

    @Column(nullable = false , length = 40)
    private String apellido;

    @Column(nullable = false , length = 9)
    private String telefono;

    @Column(nullable = false , length = 100)
    private String direccion;

    @Column(nullable = false , length = 40)
    private String tipoServicio;

    @Column(nullable = false , length = 200)
    private String descripcion;

    @Column(nullable = false , length = 40)
    private String nombreTecnico;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @Column(nullable = false )
    private LocalDate fechaCita;

    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    @JsonFormat(pattern = "HH:mm")
    @Column(nullable = false )
    private LocalTime horaCita;

    @Column(nullable = false , length = 40)
    private String estado;
}
