package es.muvment.service;

import es.muvment.model.dto.ReservaRequestDTO;
import es.muvment.model.dto.ReservaResponseDTO;
import es.muvment.model.dto.ResumenDTO;


import java.time.LocalDate;
import java.util.List;

public interface IReservaService {
    void nuevaReserva(ReservaRequestDTO nuevaReserva);
    void eliminarTodasReservas(String emailCliente);
    int facturacionTotalCliente(String emailCliente);
    List<ReservaResponseDTO> reservasConfirmadas(LocalDate fechaEntrada);
    ResumenDTO contarReservas();
}
