package com.toolsx.projectspringboot.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.HerramientaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.HerramientaRepository;

@Service
public class HerramientasService {
    private final HerramientaRepository repository;

    public HerramientasService(HerramientaRepository repository) {
        this.repository = repository;
    }

    public List<HerramientaEntity> listarTodas() {
        return repository.findAll();
    }

    public List<HerramientaEntity> listarDisponibles() {
        return repository.findByActivaTrue();
    }

    public HerramientaEntity guardar(HerramientaEntity herramienta) {
        return repository.save(herramienta);
    }

    public HerramientaEntity buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Herramienta no encontrada"));
    }
}
