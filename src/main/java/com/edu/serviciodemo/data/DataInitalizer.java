package com.edu.serviciodemo.data;


import com.edu.serviciodemo.model.Registro;
import com.edu.serviciodemo.service.impl.RegistroServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitalizer implements CommandLineRunner {

    //ioc
    private final RegistroServiceImpl registroService;


    @Override
    public void run(String... args) throws Exception {
        cargarRegistroJson();


    }


    private void cargarRegistroJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/registro.json")) {
            List<Registro> categories = objectMapper.readValue(inputStream, new TypeReference<List<Registro>>() {});
            for (Registro category : categories) {
                registroService.salvar(category); // Guarda cada categoría en la base de datos
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones: imprime el error si ocurre
        }
    }
}
