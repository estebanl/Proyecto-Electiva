package co.estebanlopez.repository;

import co.estebanlopez.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "employee")
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
