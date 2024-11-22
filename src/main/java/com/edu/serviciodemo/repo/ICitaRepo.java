package com.edu.serviciodemo.repo;

import com.edu.serviciodemo.model.Cita;
import com.edu.serviciodemo.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitaRepo extends JpaRepository<Cita, Integer> {
}
