package com.toolsx.projectspringboot.infrastructure.services;

import java.time.LocalDate;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.toolsx.projectspringboot.application.dto.ReservaCreateRequest;
import com.toolsx.projectspringboot.application.dto.ReservaResponse;
import com.toolsx.projectspringboot.application.dto.ReservaUpdateRequest;
import com.toolsx.projectspringboot.domain.exception.NotFoundException;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.HerramientaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.ReservaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.HerramientaRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.ReservasRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;

@Service
public class ReservaService {

    private final ReservasRepository reservasRepository;
    private final UsuarioJpaRepository usuarioRepository;
    private final HerramientaRepository herramientaRepository;

    public ReservaService(ReservasRepository reservasRepository, UsuarioJpaRepository usuarioRepository,
            HerramientaRepository herramientaRepository) {
        this.reservasRepository = reservasRepository;
        this.usuarioRepository = usuarioRepository;
        this.herramientaRepository = herramientaRepository;
    }

    public ReservaResponse crear(ReservaCreateRequest request) {
        UsuarioEntity usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new NotFoundException("Usuario no existe"));
        HerramientaEntity herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new NotFoundException("Herramienta no encontrada"));

        ReservaEntity entity = new ReservaEntity();
        entity.setUsuario(usuario);
        entity.setHerramienta(herramienta);
        entity.setFechaReserva(request.getFechaReserva());

        entity = reservasRepository.save(entity);
        return toResponse(entity);
    }

    public List<ReservaResponse> listar() {
        return reservasRepository.findAll().stream().map(this::toResponse).toList();
    }

    public ReservaResponse obtener(Long id) {
        ReservaEntity entity = reservasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));
        return toResponse(entity);
    }

    
    public ReservaResponse aprobarReserva(Long id, ReservaUpdateRequest request){
        ReservaEntity entity = reservasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));

        HerramientaEntity herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new NotFoundException("Herramienta no disponible"));
        
        entity.setHerramienta(herramienta);
        entity.setEstado("APROVADO");
        entity.setFechaReserva(request.getFechaReserva());
        return toResponse(entity);
    }

    public ReservaResponse rechazarReserva(Long id, ReservaUpdateRequest request){
        ReservaEntity entity = reservasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));

        HerramientaEntity herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new NotFoundException("Herramienta no disponible"));
        
        entity.setHerramienta(herramienta);
        entity.setEstado("RECHAZADO");
        entity.setFechaReserva(request.getFechaReserva());
        return toResponse(entity);
    }
    

    public ReservaResponse actualizar(Long id, ReservaUpdateRequest request) {
        ReservaEntity entity = reservasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));

        HerramientaEntity herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new NotFoundException("Herramienta no encontrada"));

        entity.setHerramienta(herramienta);
        entity.setFechaReserva(request.getFechaReserva());
        entity = reservasRepository.save(entity);
        return toResponse(entity);
    }

    public void eliminar(Long id) {
        if (!reservasRepository.existsById(id)) {
            throw new NotFoundException("Reserva no encontrada");
        }
        reservasRepository.deleteById(id);
    }

    private ReservaResponse toResponse(ReservaEntity entity) {
        return new ReservaResponse(
                entity.getId(),
                entity.getUsuario().getId(),
                entity.getHerramienta().getId(),
                entity.getEstado(),
                entity.getFechaReserva()
        );
    }

    

}
