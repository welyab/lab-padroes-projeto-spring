package one.digitalinnovation.gof.domain.services.impl;

import java.util.Optional;

import one.digitalinnovation.gof.domain.models.Cliente;
import one.digitalinnovation.gof.domain.models.Endereco;
import one.digitalinnovation.gof.domain.ports.CepLookupPort;
import one.digitalinnovation.gof.domain.ports.ClientePort;
import one.digitalinnovation.gof.domain.ports.EnderecoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.domain.services.ClienteService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private EnderecoPort enderecoPort;

    @Autowired
    private ClientePort clientePort;

    @Autowired
    private CepLookupPort cepLookupPort;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os Clientes.
        return clientePort.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Cliente> cliente = clientePort.findById(id);
        return cliente.get();
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return salvarClienteComCep(cliente);
    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clientePort.findById(id);
        if (clienteBd.isPresent()) {
            return null;
        }
        return salvarClienteComCep(cliente);
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        clientePort.deleteById(id);
    }

    private Cliente salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoPort.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = cepLookupPort.consultarCep(cep);
            enderecoPort.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        return clientePort.save(cliente);
    }
}
