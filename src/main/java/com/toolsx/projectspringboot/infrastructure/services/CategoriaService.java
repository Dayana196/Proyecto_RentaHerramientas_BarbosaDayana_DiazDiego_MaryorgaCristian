package com.toolsx.projectspringboot.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toolsx.projectspringboot.application.dto.CategoriaCreateRequest;
import com.toolsx.projectspringboot.application.dto.CategoriaResponse;
import com.toolsx.projectspringboot.domain.exception.ConflictException;
import com.toolsx.projectspringboot.domain.exception.NotFoundException;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.CategoriaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponse crear(CategoriaCreateRequest request) {
        if (categoriaRepository.findByNombre(request.getNombre()).isPresent()) {
            throw new ConflictException("Categoria ya existe");
        }
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNombre(request.getNombre());
        entity = categoriaRepository.save(entity);
        return toResponse(entity);
    }

    public List<CategoriaResponse> listar() {
        return categoriaRepository.findAll().stream().map(this::toResponse).toList();
    }

    public CategoriaResponse obtener(Long id) {
        CategoriaEntity entity = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
        return toResponse(entity);
    }

    public CategoriaResponse actualizar(Long id, CategoriaCreateRequest request) {
        CategoriaEntity entity = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
        entity.setNombre(request.getNombre());
        entity = categoriaRepository.save(entity);
        return toResponse(entity);
    }

    public void eliminar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new NotFoundException("Categoria no encontrada");
        }
        categoriaRepository.deleteById(id);
    }

    private CategoriaResponse toResponse(CategoriaEntity entity) {
        return new CategoriaResponse(entity.getId(), entity.getNombre());
    }
}
