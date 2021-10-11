package guru.springframework.pnafspetclinic.services.map;

import guru.springframework.pnafspetclinic.model.Speciality;
import guru.springframework.pnafspetclinic.model.Vet;
import guru.springframework.pnafspetclinic.services.SpecialityService;
import guru.springframework.pnafspetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(
                    speciality -> {
                        if(speciality.getId() == null) {
                            Speciality savedSpeciality =
                                 specialityService.save(speciality);
                            speciality.setId(savedSpeciality.getId());
                        }
                    }
            );
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
