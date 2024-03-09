package one.digitalinnovation.gof.resources.ports;

import one.digitalinnovation.gof.app.web.controllers.adapters.ClienteResponseAdapter;
import one.digitalinnovation.gof.domain.models.Cliente;
import one.digitalinnovation.gof.domain.ports.ClientePort;
import one.digitalinnovation.gof.resources.repositories.ClienteRepository;
import one.digitalinnovation.gof.resources.repositories.adpaters.RepositoryAdapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientePortImpl implements ClientePort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<Cliente> findAll() {
        return RepositoryAdapters.convertToCliente(clienteRepository.findAll());
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository
                .findById(id)
                .map(RepositoryAdapters::convertToCliente);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return RepositoryAdapters.convertToCliente(
                clienteRepository.save(
                        RepositoryAdapters.convertToClienteTable(cliente)
                )
        );
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
