package one.digitalinnovation.gof.resources.repositories.adpaters;

import one.digitalinnovation.gof.domain.models.Cliente;
import one.digitalinnovation.gof.domain.models.Endereco;
import one.digitalinnovation.gof.resources.repositories.tables.ClienteTable;
import one.digitalinnovation.gof.resources.repositories.tables.EnderecoTable;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.stream.StreamSupport;

public class RepositoryAdapters {
    private RepositoryAdapters() {
    }

    public static Cliente convertToCliente(ClienteTable clienteTable) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteTable, cliente);
        return cliente;
    }

    public static Iterable<Cliente> convertToCliente(Iterable<ClienteTable> clientes) {
        return StreamSupport.stream(clientes.spliterator(), false).map(RepositoryAdapters::convertToCliente).toList();
    }

    public static ClienteTable convertToClienteTable(Cliente cliente) {
        ClienteTable clienteTable = new ClienteTable();
        BeanUtils.copyProperties(clienteTable, clienteTable);
        return clienteTable;
    }

    public static Endereco convertToEndereco(EnderecoTable enderecoTable) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoTable, endereco);
        return endereco;
    }

    public static EnderecoTable convertEnderecoTable(Endereco endereco) {
        EnderecoTable enderecoTable = new EnderecoTable();
        BeanUtils.copyProperties(endereco, enderecoTable);
        return enderecoTable;
    }
}
