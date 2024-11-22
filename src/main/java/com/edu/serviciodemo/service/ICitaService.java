package com.edu.serviciodemo.service;

import com.edu.serviciodemo.model.Cita;

import java.util.List;

public interface ICitaService {

    //metodos
    //lista
    List<Cita> listarTodo()throws Exception;
    Cita buscarPorId(Integer id)throws Exception;
    Cita salvar(Cita cita)throws Exception;
    void excluir(Integer id)throws Exception;
    Cita alterar(Cita cita)throws Exception;

}
