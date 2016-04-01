package co.estebanlopez.repository;

import co.estebanlopez.domain.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "manager")
public interface ManagerRepository extends CrudRepository<Manager,Long>{

    Manager findByEmailAndPassword(String email, String password);

    Manager findByEmail(String email);
}
