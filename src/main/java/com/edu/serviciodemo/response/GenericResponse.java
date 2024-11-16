package com.edu.serviciodemo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GenericResponse<T>(
        List<T> Registros

) {
}
