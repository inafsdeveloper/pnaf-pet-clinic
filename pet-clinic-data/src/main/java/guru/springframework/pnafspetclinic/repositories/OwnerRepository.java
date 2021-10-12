package guru.springframework.pnafspetclinic.repositories;

import guru.springframework.pnafspetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
