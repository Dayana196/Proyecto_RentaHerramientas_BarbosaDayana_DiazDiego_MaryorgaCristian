package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.toolsx.projectspringboot.application.dto.HerramientaCreateRequest;
import com.toolsx.projectspringboot.application.dto.HerramientaResponse;
import com.toolsx.projectspringboot.application.dto.HerramientaUpdateRequest;
import com.toolsx.projectspringboot.application.services.HerramientasService;
import com.toolsx.projectspringboot.domain.exception.NotFoundException;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.CategoriaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.HerramientaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.ProveedorEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.CategoriaRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.ProveedorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {
    private final HerramientasService service;
    private final ProveedorRepository proveedorRepository;
    private final CategoriaRepository categoriaRepository;

    public HerramientaController(HerramientasService service, ProveedorRepository proveedorRepository,
            CategoriaRepository categoriaRepository) {
        this.service = service;
        this.proveedorRepository = proveedorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public ResponseEntity<List<HerramientaResponse>> listar() {
        return ResponseEntity.ok(service.listarTodas().stream().map(this::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerramientaResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(toResponse(service.buscarPorId(id)));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<HerramientaResponse>> disponibles() {
        return ResponseEntity.ok(service.listarDisponibles().stream().map(this::toResponse).toList());
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<HerramientaResponse>> porCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(service.listarPorCategoria(categoriaId).stream().map(this::toResponse).toList());
    }

    @GetMapping("/proveedor/{proveedorId}")
    public ResponseEntity<List<HerramientaResponse>> porProveedor(@PathVariable Long proveedorId) {
        return ResponseEntity.ok(service.listarPorProveedor(proveedorId).stream().map(this::toResponse).toList());
    }

    @PostMapping
    public ResponseEntity<HerramientaResponse> crear(@Valid @RequestBody HerramientaCreateRequest request) {
        ProveedorEntity proveedor = proveedorRepository.findById(request.getProveedorId())
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));
        CategoriaEntity categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));

        HerramientaEntity entity = new HerramientaEntity();
        entity.setNombre(request.getNombre());
        entity.setDescripcion(request.getDescripcion());
        entity.setPrecioDiario(request.getPrecioDiario());
        entity.setActiva(request.getActiva());
        entity.setProveedor(proveedor);
        entity.setCategoria(categoria);

        return ResponseEntity.ok(toResponse(service.guardar(entity)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HerramientaResponse> actualizar(@PathVariable Long id, @Valid @RequestBody HerramientaUpdateRequest request) {
        HerramientaEntity entity = service.buscarPorId(id);
        CategoriaEntity categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));

        entity.setNombre(request.getNombre());
        entity.setDescripcion(request.getDescripcion());
        entity.setPrecioDiario(request.getPrecioDiario());
        entity.setActiva(request.getActiva());
        entity.setCategoria(categoria);

        return ResponseEntity.ok(toResponse(service.guardar(entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private HerramientaResponse toResponse(HerramientaEntity entity) {
        return new HerramientaResponse(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getPrecioDiario(),
                entity.getActiva(),
                entity.getProveedor() != null ? entity.getProveedor().getId() : null,
                entity.getCategoria() != null ? entity.getCategoria().getId() : null
        );
    }
}
