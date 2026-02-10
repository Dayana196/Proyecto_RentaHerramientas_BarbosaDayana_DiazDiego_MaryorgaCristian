package com.toolsx.projectspringboot.infrastructure.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toolsx.projectspringboot.application.dto.PagoCreateRequest;
import com.toolsx.projectspringboot.application.dto.PagoResponse;
import com.toolsx.projectspringboot.domain.exception.NotFoundException;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.PagoEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.ReservaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.PagoRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.ReservasRepository;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;
    private final ReservasRepository reservasRepository;

    public PagoService(PagoRepository pagoRepository, ReservasRepository reservasRepository) {
        this.pagoRepository = pagoRepository;
        this.reservasRepository = reservasRepository;
    }

    public PagoResponse crear(PagoCreateRequest request) {
        ReservaEntity reserva = reservasRepository.findById(request.getReservaId())
                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));

        PagoEntity entity = new PagoEntity();
        entity.setReserva(reserva);
        entity.setMonto(request.getMonto());
        entity.setMetodo(request.getMetodo());
        entity.setEstado(request.getEstado());
        entity.setFechaPago(LocalDateTime.now());

        entity = pagoRepository.save(entity);
        return toResponse(entity);
    }

    public List<PagoResponse> listar() {
        return pagoRepository.findAll().stream().map(this::toResponse).toList();
    }

    public PagoResponse obtener(Long id) {
        PagoEntity entity = pagoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pago no encontrado"));
        return toResponse(entity);
    }

    public void eliminar(Long id) {
        if (!pagoRepository.existsById(id)) {
            throw new NotFoundException("Pago no encontrado");
        }
        pagoRepository.deleteById(id);
    }

    private PagoResponse toResponse(PagoEntity entity) {
        return new PagoResponse(
                entity.getId(),
                entity.getReserva().getId(),
                entity.getMonto(),
                entity.getMetodo(),
                entity.getEstado(),
                entity.getFechaPago()
        );
    }
}
