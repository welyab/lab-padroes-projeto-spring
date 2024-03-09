package one.digitalinnovation.gof.resources.repositories;

import one.digitalinnovation.gof.resources.repositories.tables.EnderecoTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoTable, Long> {
    public Optional<EnderecoTable> findByCep(String cep);
}
