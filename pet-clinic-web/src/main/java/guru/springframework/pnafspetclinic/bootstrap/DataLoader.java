package guru.springframework.pnafspetclinic.bootstrap;

import guru.springframework.pnafspetclinic.model.Owner;
import guru.springframework.pnafspetclinic.model.Vet;
import guru.springframework.pnafspetclinic.services.OwnerService;
import guru.springframework.pnafspetclinic.services.VetService;
import guru.springframework.pnafspetclinic.services.map.OwnerMapService;
import guru.springframework.pnafspetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jake");
        owner2.setLastName("Awesome");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

        System.out.println("List of Owners");
        ownerService.findAll().forEach(owner -> {
            System.out.println(
                    owner.getId() + ", " +
                    owner.getFirstName() + ", " +
                    owner.getLastName()
            );
        });

        System.out.println("List of Vets");
        vetService.findAll().forEach(vet -> {
            System.out.println(
                    vet.getId() + ", " +
                    vet.getFirstName() + ", " +
                    vet.getLastName()
            );
        });
    }
}
