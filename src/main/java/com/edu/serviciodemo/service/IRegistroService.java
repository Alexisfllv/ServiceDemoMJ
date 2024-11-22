package com.edu.serviciodemo.service;

import com.edu.serviciodemo.model.Registro;

import java.util.List;

public interface IRegistroService {

    //metodos
    //lista
    List<Registro> listarTodo()throws Exception;
    Registro buscarPorId(Integer id)throws Exception;
    Registro salvar(Registro registro)throws Exception;
    void excluir(Integer id)throws Exception;
    Registro alterar(Registro registro)throws Exception;

}
