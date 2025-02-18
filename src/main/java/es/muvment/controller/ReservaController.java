package es.muvment.controller;

import es.muvment.model.dto.ReservaRequestDTO;
import es.muvment.model.dto.ReservaResponseDTO;
import es.muvment.model.dto.ResumenDTO;
import es.muvment.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
     @Autowired
    ReservaService service;

     @PostMapping("/nuevaReserva")
     public ResponseEntity<String> nuevaReserva(@RequestBody ReservaRequestDTO nuevaReserva){
         try{
             service.nuevaReserva(nuevaReserva);
             return new ResponseEntity<>("Reserva registrada con éxito", HttpStatus.CREATED);
         } catch (Exception e) {
             return new ResponseEntity<>("ERROR: No se ha podido registrar la reserva", HttpStatus.BAD_REQUEST);
         }
     }

     @DeleteMapping("/eliminarReservas/{emailCliente}")
     public ResponseEntity<String> eliminarTodasReservas(@PathVariable String emailCliente){
         try{
             service.eliminarTodasReservas(emailCliente);
             return new ResponseEntity<>("Reseras eliminadas con éxito.", HttpStatus.NO_CONTENT);
         } catch (Exception e) {
             return new ResponseEntity<>("El cliente no existe", HttpStatus.NOT_FOUND);
         }
     }

     @GetMapping("/obtenerFacturacion")
     public ResponseEntity<Integer> obtenerFacturacion(@RequestParam String emailCliente){
         try{
             return new ResponseEntity<>(service.facturacionTotalCliente(emailCliente), HttpStatus.OK);
         } catch (Exception e) {
             return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
         }
     }
     @GetMapping("/listarActivas")
     public ResponseEntity<List<ReservaResponseDTO>> listarReservasActivas(@RequestParam LocalDate fechaEntrada){
         return new ResponseEntity<>(service.reservasConfirmadas(fechaEntrada), HttpStatus.OK);
     }
    @GetMapping("/totalReservas")
     public ResponseEntity<ResumenDTO> totalReservas(){
         return new ResponseEntity<>(service.contarReservas(), HttpStatus.OK);
     }

}
