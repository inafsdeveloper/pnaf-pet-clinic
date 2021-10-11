package guru.springframework.pnafspetclinic.bootstrap;

import guru.springframework.pnafspetclinic.model.*;
import guru.springframework.pnafspetclinic.services.OwnerService;
import guru.springframework.pnafspetclinic.services.PetTypeService;
import guru.springframework.pnafspetclinic.services.SpecialityService;
import guru.springframework.pnafspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);


        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        System.out.println("Loaded Specialities...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jake");
        owner2.setLastName("Awesome");
        owner2.setAddress("456 BrickRail");
        owner2.setCity("Miami");
        owner2.setTelephone("4564564567");

        Pet jakesPet = new Pet();
        jakesPet.setName("Just Cat");
        jakesPet.setPetType(savedCatPetType);
        jakesPet.setBirthDate(LocalDate.now());
        jakesPet.setOwner(owner2);
        owner2.getPets().add(jakesPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(dentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

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
                    owner.getLastName() + ", " +
                    owner.getAddress() + ", " +
                    owner.getCity() + ", "  +
                    owner.getTelephone()
            );
            System.out.println("    List of Owners's Pets");
            owner.getPets().forEach(pet -> System.out.println("    " +
                    pet.getId() + "," +
                    "["+pet.getPetType().getId() +"-"+pet.getPetType().getName() + "]," +
                    pet.getName() + ", " +
                    pet.getBirthDate() + ", " +
                    pet.getOwner().getFirstName() + ", " +
                    pet.getOwner().getLastName()
            ));
        });

        System.out.println("List of Vets");
        vetService.findAll().forEach(vet -> {
            System.out.println(
                    vet.getId() + ", " +
                    vet.getFirstName() + ", " +
                    vet.getLastName()
            );
            System.out.println("    List of Vet's Specialities");
            vet.getSpecialities().forEach(
                    speciality ->
                            System.out.println("    " +
                                    speciality.getId() + ", " +
                                    speciality.getDescription())
            );
        });
    }
}
