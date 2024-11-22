package com.edu.serviciodemo.controller;

import com.edu.serviciodemo.model.Solicitud;
import com.edu.serviciodemo.service.impl.SolicitudServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    //ioc service impl
    private final SolicitudServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() throws Exception {
        List<Solicitud>  listado = service.listarTodo();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> buscar(@PathVariable ("id") Integer id) throws Exception {
        Solicitud buscarPorId = service.buscarPorId(id);
        return new ResponseEntity<>(buscarPorId,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Solicitud solicitud) throws Exception {
        Solicitud add =  service.salvar(solicitud);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Solicitud> update( @RequestBody Solicitud solicitud) throws Exception {
        //solicitud.setIdSolicitud(id);
        Solicitud upd =  service.alterar(solicitud);
        return new ResponseEntity<>(upd, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
