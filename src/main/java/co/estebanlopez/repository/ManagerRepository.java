package co.estebanlopez.repository;

import co.estebanlopez.domain.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager,Long>{

    Manager findByEmailAndPassword(String email, String password);

    Manager findByEmail(String email);
}
