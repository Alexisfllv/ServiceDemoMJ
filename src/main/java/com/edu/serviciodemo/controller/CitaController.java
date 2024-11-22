package com.edu.serviciodemo.controller;

import com.edu.serviciodemo.model.Cita;
import com.edu.serviciodemo.service.impl.CitaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {

    //ioc service impl
    private final CitaServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Cita>> listar() throws Exception {
        List<Cita>  listado = service.listarTodo();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscar(@PathVariable ("id") Integer id) throws Exception {
        Cita buscarPorId = service.buscarPorId(id);
        return new ResponseEntity<>(buscarPorId,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Cita cita) throws Exception {
        Cita add =  service.salvar(cita);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cita> update( @RequestBody Cita cita) throws Exception {
        //cita.setIdCita(id);
        Cita upd =  service.alterar(cita);
        return new ResponseEntity<>(upd, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
