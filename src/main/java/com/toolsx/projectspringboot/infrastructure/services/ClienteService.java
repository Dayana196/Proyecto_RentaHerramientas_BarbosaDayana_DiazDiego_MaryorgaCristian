package com.toolsx.projectspringboot.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toolsx.projectspringboot.application.dto.ClienteCreateRequest;
import com.toolsx.projectspringboot.application.dto.ClienteResponse;
import com.toolsx.projectspringboot.application.dto.ClienteUpdateRequest;
import com.toolsx.projectspringboot.domain.exception.ConflictException;
import com.toolsx.projectspringboot.domain.exception.NotFoundException;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.ClienteEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.ClientesRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;

@Service
public class ClienteService {

    private final ClientesRepository clientesRepository;
    private final UsuarioJpaRepository usuarioRepository;

    public ClienteService(ClientesRepository clientesRepository, UsuarioJpaRepository usuarioRepository) {
        this.clientesRepository = clientesRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ClienteResponse crear(ClienteCreateRequest request) {
        UsuarioEntity usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new NotFoundException("Usuario no existe"));

        if (clientesRepository.findByUsuarioId(usuario.getId()).isPresent()) {
            throw new ConflictException("Cliente ya existe para este usuario");
        }

        ClienteEntity entity = new ClienteEntity();
        entity.setUsuario(usuario);
        entity.setNombreCompleto(request.getNombreCompleto());
        entity.setTelefono(request.getTelefono());

        entity = clientesRepository.save(entity);
        return toResponse(entity);
    }

    public List<ClienteResponse> listar() {
        return clientesRepository.findAll().stream().map(this::toResponse).toList();
    }

    public ClienteResponse obtener(Long id) {
        ClienteEntity entity = clientesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
        return toResponse(entity);
    }

    public ClienteResponse actualizar(Long id, ClienteUpdateRequest request) {
        ClienteEntity entity = clientesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
        entity.setNombreCompleto(request.getNombreCompleto());
        entity.setTelefono(request.getTelefono());
        entity = clientesRepository.save(entity);
        return toResponse(entity);
    }

    public void eliminar(Long id) {
        if (!clientesRepository.existsById(id)) {
            throw new NotFoundException("Cliente no encontrado");
        }
        clientesRepository.deleteById(id);
    }

    private ClienteResponse toResponse(ClienteEntity entity) {
        return new ClienteResponse(
                entity.getId(),
                entity.getUsuario().getId(),
                entity.getNombreCompleto(),
                entity.getTelefono()
        );
    }
}
