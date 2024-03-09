package one.digitalinnovation.gof.domain.ports;

import one.digitalinnovation.gof.domain.models.Cliente;

import java.util.Optional;

public interface ClientePort {
    Iterable<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    void deleteById(Long id);
}
