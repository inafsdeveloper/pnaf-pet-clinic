package guru.springframework.pnafspetclinic.controllers;

import guru.springframework.pnafspetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
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
        return "vets/index";
    }
}
