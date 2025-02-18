package es.muvment.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;


public class ReservaRequestDTO {

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    @Max(25)
    @Min(250)
    private int precioTotal;
    private String email;

    public ReservaRequestDTO(LocalDate fechaEntrada, LocalDate fechaSalida, int precioTotal, String email) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal=precioTotal;
        this.email = email;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
}
