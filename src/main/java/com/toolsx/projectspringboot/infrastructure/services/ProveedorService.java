package com.toolsx.projectspringboot.infrastructure.services;

import com.toolsx.projectspringboot.application.dto.ProveedorCreateRequest;
import com.toolsx.projectspringboot.application.dto.ProveedorResponse;
import com.toolsx.projectspringboot.application.dto.ProveedorUpdateRequest;
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

    // ✅ CREATE
    public ProveedorResponse crearProveedor(ProveedorCreateRequest request) {

        UsuarioEntity usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        if (proveedorRepository.findByUsuarioId(usuario.getId()).isPresent()) {
            throw new RuntimeException("Proveedor ya existe para este usuario");
        }

        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setUsuario(usuario);
        proveedor.setNombreEmpresa(request.getNombreEmpresa());
        proveedor.setTelefonoContacto(request.getTelefonoContacto());

        ProveedorEntity guardado = proveedorRepository.save(proveedor);

        return mapToResponse(guardado);
    }

    // ✅ READ ALL
    public List<ProveedorResponse> listarProveedores() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ✅ READ ONE
    public ProveedorResponse obtenerProveedor(Long id) {
        ProveedorEntity proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        return mapToResponse(proveedor);
    }

    // ✅ UPDATE
    public ProveedorResponse actualizarProveedor(Long id, ProveedorUpdateRequest request) {
        ProveedorEntity proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setNombreEmpresa(request.getNombreEmpresa());
        proveedor.setTelefonoContacto(request.getTelefonoContacto());

        ProveedorEntity actualizado = proveedorRepository.save(proveedor);
        return mapToResponse(actualizado);
    }

    // 🔁 MAPPER
    private ProveedorResponse mapToResponse(ProveedorEntity proveedor) {
        return new ProveedorResponse(
                proveedor.getId(),
                proveedor.getNombreEmpresa(),
                proveedor.getTelefonoContacto(),
                proveedor.getUsuario().getId()
        );
    }
}