package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolsx.projectspringboot.application.services.HerramientasService;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.HerramientaEntity;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {
    private final HerramientasService service;

    public HerramientaController(HerramientasService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<HerramientaEntity> listar() {
        return service.listarTodas();
    }

    @GetMapping("/disponibles")
    public List<HerramientaEntity> disponibles() {
        return service.listarDisponibles();
    }
}