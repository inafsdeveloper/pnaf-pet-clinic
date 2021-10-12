package guru.springframework.pnafspetclinic.repositories;

import guru.springframework.pnafspetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
