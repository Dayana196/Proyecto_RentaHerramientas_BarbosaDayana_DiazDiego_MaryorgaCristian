package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.toolsx.projectspringboot.application.dto.PagoCreateRequest;
import com.toolsx.projectspringboot.application.dto.PagoResponse;
import com.toolsx.projectspringboot.infrastructure.services.PagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<PagoResponse> crear(@Valid @RequestBody PagoCreateRequest request) {
        return ResponseEntity.ok(pagoService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<PagoResponse>> listar() {
        return ResponseEntity.ok(pagoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtener(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
