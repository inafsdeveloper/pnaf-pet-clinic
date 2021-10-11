package guru.springframework.pnafspetclinic.bootstrap;

import guru.springframework.pnafspetclinic.model.Owner;
import guru.springframework.pnafspetclinic.model.PetType;
import guru.springframework.pnafspetclinic.model.Vet;
import guru.springframework.pnafspetclinic.services.OwnerService;
import guru.springframework.pnafspetclinic.services.PetTypeService;
import guru.springframework.pnafspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("Loaded Pet Types...");

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

        System.out.println("List of Pet Types");
        petTypeService.findAll().forEach(petType -> {
            System.out.println(
                    petType.getId() + ", " +
                    petType.getName()
            );
        });

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
