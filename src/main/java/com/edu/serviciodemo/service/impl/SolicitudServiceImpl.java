package com.edu.serviciodemo.service.impl;

import com.edu.serviciodemo.model.Solicitud;
import com.edu.serviciodemo.repo.ISolicitudRepo;
import com.edu.serviciodemo.service.ISolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements ISolicitudService {

    //instancia de repo
    private final ISolicitudRepo repo;

    @Override
    public List<Solicitud> listarTodo() throws Exception {
        return repo.findAll();
    }

    @Override
    public Solicitud buscarPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Solicitud salvar(Solicitud solicitud) throws Exception {
        return repo.save(solicitud);
    }

    @Override
    public void excluir(Integer id) throws Exception {
        repo.deleteById(id);
    }

    @Override
    public Solicitud alterar(Solicitud solicitud) throws Exception {
        //repo.findById(id).orElse(null);
        return repo.save(solicitud);
    }
}
