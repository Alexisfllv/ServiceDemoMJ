package com.edu.serviciodemo.controller;

import com.edu.serviciodemo.model.Registro;
import com.edu.serviciodemo.response.GenericResponse;
import com.edu.serviciodemo.service.impl.RegistroServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("registros/")
@RequiredArgsConstructor
public class RegistroController {

    //ioc service impl
    private final RegistroServiceImpl service;

    @GetMapping("/listar")
    public ResponseEntity<GenericResponse<Registro>> listar() throws Exception {
        List<Registro>  listado = service.listarTodo();
        return new ResponseEntity<>(new GenericResponse<>(listado), HttpStatus.OK);
    }


}
