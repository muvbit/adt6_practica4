package es.muvment.repository;

import es.muvment.model.Reserva;
import es.muvment.model.dto.ReservaResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findReservasByCliente_Email(@NotNull @Email String clienteEmail);

    @Transactional
    @Modifying
    void deleteAllByCliente_Email(@NotNull @Email String clienteEmail);


    List<Reserva> findAllByConfirmada(boolean confirmada);

    List<Reserva> findReservasByFechaEntradaIsAfter(LocalDate fechaEntradaAfter);

}
