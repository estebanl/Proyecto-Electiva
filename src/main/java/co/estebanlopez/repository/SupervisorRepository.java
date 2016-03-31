package co.estebanlopez.repository;

import co.estebanlopez.domain.Supervisor;
import org.springframework.data.repository.CrudRepository;

public interface SupervisorRepository extends CrudRepository<Supervisor,Long> {
    Supervisor findByEmailAndPassword(String email,String password);
}
