package com.services.solutions.apibase.util;

import java.util.UUID;
import lombok.Data;

@Data
public class Response {
    private int codigo;
    private UUID folio;
    private String mensaje;

    public Response(int codigo, String mensaje) {
        this.codigo = codigo;
        this.folio = UUID.randomUUID();
        this.mensaje = mensaje;
    }

}