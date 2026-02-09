package com.toolsx.projectspringboot.infrastructure.services;

import java.util.List;

import com.toolsx.projectspringboot.application.services.HerramientasService;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.HerramientaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.HerramientaRepository;

import org.springframework.stereotype.Service;

@Service
public class HerramientasServiceImpl implements HerramientasService {

    private final HerramientaRepository repository;

    public HerramientasServiceImpl(HerramientaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HerramientaEntity> listarTodas() {
        return repository.findAll();
    }

    @Override
    public List<HerramientaEntity> listarDisponibles() {
        return repository.findByActivaTrue();
    }

    @Override
    public HerramientaEntity guardar(HerramientaEntity herramienta) {
        return repository.save(herramienta);
    }

    @Override
    public HerramientaEntity buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Herramienta no encontrada"));
    }
}
