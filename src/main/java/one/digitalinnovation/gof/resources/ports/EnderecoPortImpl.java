package one.digitalinnovation.gof.resources.ports;

import one.digitalinnovation.gof.domain.models.Endereco;
import one.digitalinnovation.gof.domain.ports.EnderecoPort;
import one.digitalinnovation.gof.resources.repositories.EnderecoRepository;
import one.digitalinnovation.gof.resources.repositories.adpaters.RepositoryAdapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EnderecoPortImpl implements EnderecoPort {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Optional<Endereco> findById(String cep) {
        return enderecoRepository.findByCep(cep)
                .map(RepositoryAdapters::convertToEndereco);
    }

    public void save(Endereco novoEndereco) {
        enderecoRepository.save(
                RepositoryAdapters.convertEnderecoTable(novoEndereco)
        );
    }
}
