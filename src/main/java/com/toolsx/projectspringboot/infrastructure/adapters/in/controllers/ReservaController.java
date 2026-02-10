package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.toolsx.projectspringboot.application.dto.ReservaCreateRequest;
import com.toolsx.projectspringboot.application.dto.ReservaResponse;
import com.toolsx.projectspringboot.application.dto.ReservaUpdateRequest;
import com.toolsx.projectspringboot.infrastructure.services.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> crear(@Valid @RequestBody ReservaCreateRequest request) {
        return ResponseEntity.ok(reservaService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponse>> listar() {
        return ResponseEntity.ok(reservaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponse> actualizar(@PathVariable Long id, @Valid @RequestBody ReservaUpdateRequest request) {
        return ResponseEntity.ok(reservaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
