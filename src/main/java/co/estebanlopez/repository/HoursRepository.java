package co.estebanlopez.repository;

import co.estebanlopez.domain.Hours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "hours")
public interface HoursRepository extends CrudRepository<Hours,Long> {
}
