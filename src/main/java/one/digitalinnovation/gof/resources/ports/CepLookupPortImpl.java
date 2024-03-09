package one.digitalinnovation.gof.resources.ports;

import one.digitalinnovation.gof.domain.models.Endereco;
import one.digitalinnovation.gof.domain.ports.CepLookupPort;
import one.digitalinnovation.gof.resources.httpclients.viacep.ViaCepAdapters;
import one.digitalinnovation.gof.resources.httpclients.viacep.ViaCepHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CepLookupPortImpl implements CepLookupPort {

    @Autowired
    private ViaCepHttpClient viaCepHttpClient;

    public Endereco consultarCep(String cep) {
        return ViaCepAdapters.converToEndereco(
                viaCepHttpClient.consultarCep(cep)
        );
    }
}
