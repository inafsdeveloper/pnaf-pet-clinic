package guru.springframework.pnafspetclinic.repositories;

import guru.springframework.pnafspetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
