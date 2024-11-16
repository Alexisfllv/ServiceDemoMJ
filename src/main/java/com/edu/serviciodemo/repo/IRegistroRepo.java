package com.edu.serviciodemo.repo;

import com.edu.serviciodemo.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistroRepo extends JpaRepository<Registro, Integer> {
}
