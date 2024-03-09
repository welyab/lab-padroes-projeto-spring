package one.digitalinnovation.gof.app.web.controllers.adapters;

import one.digitalinnovation.gof.app.web.controllers.request.ClienteRequest;
import one.digitalinnovation.gof.domain.models.Cliente;
import org.springframework.beans.BeanUtils;

public class ClienteRequestAdapter {
    private ClienteRequestAdapter() {
    }

    public static Cliente clienteRequestToCliente(ClienteRequest request) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(request, cliente);
        return cliente;
    }
}
