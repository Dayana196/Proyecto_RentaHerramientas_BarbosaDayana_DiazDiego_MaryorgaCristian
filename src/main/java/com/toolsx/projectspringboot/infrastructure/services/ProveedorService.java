package com.toolsx.projectspringboot.infrastructure.services;

import com.toolsx.projectspringboot.application.dto.ProveedorCreateRequest;
import com.toolsx.projectspringboot.application.dto.ProveedorResponse;
import com.toolsx.projectspringboot.application.dto.ProveedorUpdateRequest;
import com.toolsx.projectspringboot.domain.exception.ConflictException;
import com.toolsx.projectspringboot.domain.exception.NotFoundException;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.ProveedorEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.ProveedorRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final UsuarioJpaRepository usuarioRepository;

    public ProveedorService(ProveedorRepository proveedorRepository,
                            UsuarioJpaRepository usuarioRepository) {
        this.proveedorRepository = proveedorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ProveedorResponse crearProveedor(ProveedorCreateRequest request) {
        UsuarioEntity usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new NotFoundException("Usuario no existe"));

        if (proveedorRepository.findByUsuarioId(usuario.getId()).isPresent()) {
            throw new ConflictException("Proveedor ya existe para este usuario");
        }

        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setUsuario(usuario);
        proveedor.setNombreEmpresa(request.getNombreEmpresa());
        proveedor.setTelefonoContacto(request.getTelefonoContacto());

        ProveedorEntity guardado = proveedorRepository.save(proveedor);

        return mapToResponse(guardado);
    }

    public List<ProveedorResponse> listarProveedores() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ProveedorResponse obtenerProveedor(Long id) {
        ProveedorEntity proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));

        return mapToResponse(proveedor);
    }

    public ProveedorResponse actualizarProveedor(Long id, ProveedorUpdateRequest request) {
        ProveedorEntity proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));

        proveedor.setNombreEmpresa(request.getNombreEmpresa());
        proveedor.setTelefonoContacto(request.getTelefonoContacto());

        ProveedorEntity actualizado = proveedorRepository.save(proveedor);
        return mapToResponse(actualizado);
    }

    public void eliminarProveedor(Long id) {
        if (!proveedorRepository.existsById(id)) {
            throw new NotFoundException("Proveedor no encontrado");
        }
        proveedorRepository.deleteById(id);
    }

    private ProveedorResponse mapToResponse(ProveedorEntity proveedor) {
        return new ProveedorResponse(
                proveedor.getId(),
                proveedor.getNombreEmpresa(),
                proveedor.getTelefonoContacto(),
                proveedor.getUsuario().getId()
        );
    }
}
