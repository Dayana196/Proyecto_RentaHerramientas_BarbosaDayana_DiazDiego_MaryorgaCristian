package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.toolsx.projectspringboot.application.dto.ProveedorCreateRequest;
import com.toolsx.projectspringboot.application.dto.ProveedorResponse;
import com.toolsx.projectspringboot.application.dto.ProveedorUpdateRequest;
import com.toolsx.projectspringboot.infrastructure.services.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<ProveedorResponse> crearProveedor(
            @Valid @RequestBody ProveedorCreateRequest request) {

        return ResponseEntity.ok(proveedorService.crearProveedor(request));
    }

    // ✅ READ ALL
    @GetMapping
    public ResponseEntity<List<ProveedorResponse>> listar() {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

    // ✅ READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorService.obtenerProveedor(id));
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProveedorUpdateRequest request) {

        return ResponseEntity.ok(
                proveedorService.actualizarProveedor(id, request)
        );
    }
}