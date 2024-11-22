package com.edu.serviciodemo.service.impl;

import com.edu.serviciodemo.model.Cita;
import com.edu.serviciodemo.repo.ICitaRepo;
import com.edu.serviciodemo.service.ICitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements ICitaService {

    //instancia de repo
    private final ICitaRepo repo;

    @Override
    public List<Cita> listarTodo() throws Exception {
        return repo.findAll();
    }

    @Override
    public Cita buscarPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Cita salvar(Cita cita) throws Exception {
        return repo.save(cita);
    }

    @Override
    public void excluir(Integer id) throws Exception {
        repo.deleteById(id);
    }

    @Override
    public Cita alterar(Cita cita) throws Exception {
        //repo.findById(id).orElse(null);
        return repo.save(cita);
    }
}
