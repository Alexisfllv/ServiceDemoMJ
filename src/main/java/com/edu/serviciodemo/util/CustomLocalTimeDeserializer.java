package com.edu.serviciodemo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class CustomLocalTimeDeserializer extends JsonDeserializer<LocalTime> {

    // Formatos que aceptaremos
    private static final DateTimeFormatter FORMAT_24_HOURS = DateTimeFormatter.ofPattern("HH:mm");  // 24-hour format
    private static final DateTimeFormatter FORMAT_12_HOURS = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);  // 12-hour format with AM/PM

    @Override
    public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String time = p.getText().trim();

        // Primero intentamos parsear con el formato de 24 horas
        try {
            if (time.length() == 4) {
                time = "0" + time;  // Asegura que las horas de un solo dígito tengan el cero a la izquierda
            }
            return LocalTime.parse(time, FORMAT_24_HOURS);
        } catch (DateTimeParseException e) {
            // Si el formato de 24 horas falla, intentamos con el formato de 12 horas
            try {
                return LocalTime.parse(time, FORMAT_12_HOURS);
            } catch (DateTimeParseException ex) {
                throw new IOException("Unable to parse time: " + time, ex);
            }
        }
    }
}
