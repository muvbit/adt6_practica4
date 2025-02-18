package es.muvment.repository;

import es.muvment.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClienteByEmail(@NotNull @Email String email);
}
