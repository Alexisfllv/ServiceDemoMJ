package com.edu.serviciodemo.controller;

import com.edu.serviciodemo.model.Registro;
import com.edu.serviciodemo.response.GenericResponse;
import com.edu.serviciodemo.service.impl.RegistroServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registros/")
@RequiredArgsConstructor
public class RegistroController {

    //ioc service impl
    private final RegistroServiceImpl service;

    @GetMapping("/listar")
    public ResponseEntity<List<Registro>> listar() throws Exception {
        List<Registro>  listado = service.listarTodo();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro> buscar(@PathVariable ("id") Integer id) throws Exception {
        Registro buscarPorId = service.buscarPorId(id);
        return new ResponseEntity<>(buscarPorId,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Registro> registrar(@RequestBody Registro registro) throws Exception {
        Registro add =  service.salvar(registro);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro> update(@PathVariable("id") Integer id, @RequestBody Registro registro) throws Exception {
        registro.setIdRegistro(id);
        Registro upd =  service.alterar(id,registro);
        return new ResponseEntity<>(upd, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
