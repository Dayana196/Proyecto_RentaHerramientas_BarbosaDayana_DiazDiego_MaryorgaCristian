package com.toolsx.projectspringboot.infrastructure.services;

import java.util.List;

import com.toolsx.projectspringboot.application.services.HerramientasService;
import com.toolsx.projectspringboot.domain.exception.NotFoundException;
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
    public List<HerramientaEntity> listarPorCategoria(Long categoriaId) {
        return repository.findByCategoria_Id(categoriaId);
    }

    @Override
    public List<HerramientaEntity> listarPorProveedor(Long proveedorId) {
        return repository.findByProveedor_Id(proveedorId);
    }

    @Override
    public HerramientaEntity guardar(HerramientaEntity herramienta) {
        return repository.save(herramienta);
    }

    @Override
    public HerramientaEntity buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Herramienta no encontrada"));
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Herramienta no encontrada");
        }
        repository.deleteById(id);
    }
}
