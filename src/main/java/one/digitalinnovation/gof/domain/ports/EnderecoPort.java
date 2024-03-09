package one.digitalinnovation.gof.domain.ports;

import one.digitalinnovation.gof.domain.models.Endereco;

import java.util.Optional;

public interface EnderecoPort {
     public Optional<Endereco> findById(String cep);

    public void save(Endereco novoEndereco);
}
