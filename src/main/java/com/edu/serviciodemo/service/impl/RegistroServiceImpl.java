package com.edu.serviciodemo.service.impl;

import com.edu.serviciodemo.model.Registro;
import com.edu.serviciodemo.repo.IRegistroRepo;
import com.edu.serviciodemo.service.IRegistroService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroServiceImpl implements IRegistroService {

    //instancia de repo
    private final IRegistroRepo repo;

    @Override
    public List<Registro> listarTodo() throws Exception {
        return repo.findAll();
    }

    @Override
    public Registro buscarPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Registro salvar(Registro registro) throws Exception {
        return repo.save(registro);
    }

    @Override
    public void excluir(Integer id) throws Exception {
        repo.deleteById(id);
    }

    @Override
    public Registro alterar(Registro registro) throws Exception {
        //repo.findById(id).orElse(null);
        return repo.save(registro);
    }
}
