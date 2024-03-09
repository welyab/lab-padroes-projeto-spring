package one.digitalinnovation.gof.resources.repositories;

import one.digitalinnovation.gof.resources.repositories.tables.ClienteTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteTable, Long> {

}