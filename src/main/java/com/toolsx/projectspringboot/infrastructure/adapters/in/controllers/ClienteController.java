package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.toolsx.projectspringboot.application.dto.ClienteCreateRequest;
import com.toolsx.projectspringboot.application.dto.ClienteResponse;
import com.toolsx.projectspringboot.application.dto.ClienteUpdateRequest;
import com.toolsx.projectspringboot.infrastructure.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> crear(@Valid @RequestBody ClienteCreateRequest request) {
        return ResponseEntity.ok(clienteService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizar(@PathVariable Long id, @Valid @RequestBody ClienteUpdateRequest request) {
        return ResponseEntity.ok(clienteService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
