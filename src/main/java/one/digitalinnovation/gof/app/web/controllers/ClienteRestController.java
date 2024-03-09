package one.digitalinnovation.gof.app.web.controllers;

import one.digitalinnovation.gof.app.web.controllers.adapters.ClienteRequestAdapter;
import one.digitalinnovation.gof.app.web.controllers.adapters.ClienteResponseAdapter;
import one.digitalinnovation.gof.app.web.controllers.request.ClienteRequest;
import one.digitalinnovation.gof.app.web.controllers.response.ClienteResponse;
import one.digitalinnovation.gof.domain.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.resources.repositories.tables.ClienteTable;
import one.digitalinnovation.gof.domain.services.ClienteService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * @author falvojr
 * @author welyab
 */
@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<ClienteResponse>> buscarTodos() {
        return ResponseEntity.ok(
                ClienteResponseAdapter.clienteToClienteResponse(
                        clienteService.buscarTodos()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(
                ClienteResponseAdapter.clienteToClienteResponse(
                        clienteService.buscarPorId(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> inserir(@RequestBody ClienteRequest request) {
        Cliente cliente = clienteService.inserir(ClienteRequestAdapter.clienteRequestToCliente(request));
        return ResponseEntity.ok(
                ClienteResponseAdapter.clienteToClienteResponse(
                        cliente
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id, @RequestBody ClienteRequest request) {
        Cliente cliente = clienteService.atualizar(id, ClienteRequestAdapter.clienteRequestToCliente(request));
        return ResponseEntity.ok(ClienteResponseAdapter.clienteToClienteResponse(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
