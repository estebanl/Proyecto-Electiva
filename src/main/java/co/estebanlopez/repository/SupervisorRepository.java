package co.estebanlopez.repository;

import co.estebanlopez.domain.Supervisor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "supervisor")
public interface SupervisorRepository extends CrudRepository<Supervisor,Long> {
    Supervisor findByEmailAndPassword(String email,String password);
}
