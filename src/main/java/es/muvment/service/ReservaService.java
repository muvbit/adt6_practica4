package es.muvment.service;

import es.muvment.model.Cliente;
import es.muvment.model.Reserva;
import es.muvment.model.dto.ReservaRequestDTO;
import es.muvment.model.dto.ReservaResponseDTO;
import es.muvment.model.dto.ResumenDTO;
import es.muvment.repository.IClienteRepository;
import es.muvment.repository.IReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService implements IReservaService{
    @Autowired
    IReservaRepository repo;
    @Autowired
    IClienteRepository repoCliente;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void nuevaReserva(ReservaRequestDTO nuevaReserva) {
        Cliente cliente=repoCliente.findClienteByEmail(nuevaReserva.getEmail());
        if(nuevaReserva.getFechaSalida().isAfter(nuevaReserva.getFechaEntrada()) && cliente!=null){
            repo.save(modelMapper.map(nuevaReserva, Reserva.class));
        }
        else throw new RuntimeException();
    }

    @Override
    public void eliminarTodasReservas(String emailCliente) {
        Cliente cliente=repoCliente.findClienteByEmail(emailCliente);
        if(cliente!=null)   repo.deleteAllByCliente_Email(emailCliente);
        else throw new RuntimeException();
    }

    @Override
    public int facturacionTotalCliente(String emailCliente) {
        List<Reserva> reservasCliente=repo.findReservasByCliente_Email(emailCliente);
        Cliente cliente=repoCliente.findClienteByEmail(emailCliente);
        if(cliente!=null){
            int suma=reservasCliente.stream().mapToInt(Reserva::getPrecioTotal).sum();
            if(suma>0) return suma;
        }
        throw new RuntimeException();
    }

    @Override
    public List<ReservaResponseDTO> reservasConfirmadas(LocalDate fechaEntrada) {
        List<Reserva> reservas=repo.findReservasByFechaEntradaIsAfter(fechaEntrada);
        return reservas.stream().map(reserva -> modelMapper.map(reserva, ReservaResponseDTO.class)).toList();
    }

    @Override
    public ResumenDTO contarReservas() {
        return new ResumenDTO(repo.findAllByConfirmada(true).stream().count(),repo.findAllByConfirmada(false).stream().count());
    }
}
