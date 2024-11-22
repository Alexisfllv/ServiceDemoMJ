package com.edu.serviciodemo.repo;

import com.edu.serviciodemo.model.Registro;
import com.edu.serviciodemo.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudRepo extends JpaRepository<Solicitud, Integer> {
}
