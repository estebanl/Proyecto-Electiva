package co.estebanlopez.repository;

import co.estebanlopez.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
