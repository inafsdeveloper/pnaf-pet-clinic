package guru.springframework.pnafspetclinic.repositories;

import guru.springframework.pnafspetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
