package guru.springframework.pnafspetclinic.repositories;

import guru.springframework.pnafspetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
