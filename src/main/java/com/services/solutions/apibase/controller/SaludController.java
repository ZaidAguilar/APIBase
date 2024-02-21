package com.services.solutions.apibase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.solutions.apibase.service.DatabaseService;
import com.services.solutions.apibase.util.Response;

import java.time.LocalDateTime;

@RestController
public class SaludController {

    private final DatabaseService databaseService;

    @Autowired
    public SaludController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/estatus")
    public Response getEstatus() {
        return new Response(HttpStatus.OK.value(), "¡El proyecto funciona!. Fecha y hora: " + LocalDateTime.now());
    }

    @GetMapping("/inicio")
    public Response getInicio() {
        return new Response(HttpStatus.OK.value(), "Artifact: API Base, Versión: 1.0.0");
    }

    @GetMapping("/getEstatusBD")
    public Response getEstatusBD() {
        boolean isConnected = databaseService.isDatabaseConnected();
        String mensaje = isConnected ? "Conectado a la base de datos" : "No conectado a la base de datos";
        int codigo = isConnected ? HttpStatus.OK.value() : HttpStatus.BAD_REQUEST.value();
        return new Response(codigo, mensaje);
    }
}