package guru.springframework.pnafspetclinic.services;

import guru.springframework.pnafspetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
