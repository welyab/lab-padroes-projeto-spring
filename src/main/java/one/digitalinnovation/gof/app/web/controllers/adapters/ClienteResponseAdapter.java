package one.digitalinnovation.gof.app.web.controllers.adapters;

import one.digitalinnovation.gof.app.web.controllers.response.ClienteResponse;
import one.digitalinnovation.gof.domain.models.Cliente;
import org.springframework.beans.BeanUtils;

import java.util.stream.StreamSupport;

public class ClienteResponseAdapter {
    private ClienteResponseAdapter() {
    }

    public static ClienteResponse clienteToClienteResponse(Cliente cliente) {
        ClienteResponse response = new ClienteResponse();
        BeanUtils.copyProperties(cliente, response);
        return response;
    }

    public static Iterable<ClienteResponse> clienteToClienteResponse(Iterable<Cliente> clientes) {
        return StreamSupport
                .stream(clientes.spliterator(), false)
                .map(ClienteResponseAdapter::clienteToClienteResponse).toList();
    }


}
