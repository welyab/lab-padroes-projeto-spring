package one.digitalinnovation.gof.domain.ports;

import one.digitalinnovation.gof.domain.models.Endereco;
import one.digitalinnovation.gof.resources.repositories.tables.EnderecoTable;

public interface CepLookupPort {
    Endereco consultarCep(String cep);
}
