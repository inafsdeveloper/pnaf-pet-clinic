package guru.springframework.pnafspetclinic.repositories;

import guru.springframework.pnafspetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
