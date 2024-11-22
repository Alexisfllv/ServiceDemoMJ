package com.edu.serviciodemo.service;

import com.edu.serviciodemo.model.Solicitud;

import java.util.List;

public interface ISolicitudService {

    //metodos
    //lista
    List<Solicitud> listarTodo()throws Exception;
    Solicitud buscarPorId(Integer id)throws Exception;
    Solicitud salvar(Solicitud registro)throws Exception;
    void excluir(Integer id)throws Exception;
    Solicitud alterar(Solicitud registro)throws Exception;

}
