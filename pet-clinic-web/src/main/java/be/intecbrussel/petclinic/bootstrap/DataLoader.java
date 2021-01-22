package be.intecbrussel.petclinic.bootstrap;

import be.intecbrussel.petclinic.model.*;
import be.intecbrussel.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedNewPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Making X-rays");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Making surgeries");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Fixing teeth");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("jeffrey");
        owner1.setLastName("baetens");
        owner1.setAddress("Molenhof");
        owner1.setCity("Beveren");
        owner1.setTelephone("12345987");

        Owner.builder().firstName("jef").city("beverly").build();

        Pet myPet = new Pet();
        myPet.setPetType(savedPetType);
        myPet.setOwner(owner1);
        myPet.setBirthDate(LocalDate.now());
        myPet.setName("Rosco");
        owner1.getPets().add(myPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alexa");
        owner2.setLastName("O'toole");
        owner2.setAddress("Dambruggestraat");
        owner2.setCity("Melsele");
        owner2.setTelephone("98745613221");

        Pet alexaPet = new Pet();
        alexaPet.setPetType(savedNewPetType);
        alexaPet.setOwner(owner2);
        alexaPet.setBirthDate(LocalDate.EPOCH);
        alexaPet.setName("Figaro");
        owner2.getPets().add(alexaPet);

        ownerService.save(owner2);

        Visit catvisit = new Visit();
        catvisit.setPet(alexaPet);
        catvisit.setDate(LocalDate.now());
        catvisit.setDescription("sneezing kitty");

        visitService.save(catvisit);

        System.out.println("loading owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("brico");
        vet1.setLastName("nocce");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("sulo");
        vet2.setLastName("finn");
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("loading vets");
    }
}
