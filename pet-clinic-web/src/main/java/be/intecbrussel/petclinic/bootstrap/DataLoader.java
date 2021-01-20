package be.intecbrussel.petclinic.bootstrap;

import be.intecbrussel.petclinic.model.Owner;
import be.intecbrussel.petclinic.model.Pet;
import be.intecbrussel.petclinic.model.PetType;
import be.intecbrussel.petclinic.model.Vet;
import be.intecbrussel.petclinic.services.OwnerService;
import be.intecbrussel.petclinic.services.PetTypeService;
import be.intecbrussel.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedNewPetType = petTypeService.save(cat);



        Owner owner1 = new Owner();
        owner1.setFirstName("jeffrey");
        owner1.setLastName("baetens");
        owner1.setAddress("Molenhof");
        owner1.setCity("Beveren");
        owner1.setTelephone("12345987");

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

        System.out.println("loading owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("brico");
        vet1.setLastName("nocce");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("sulo");
        vet2.setLastName("finn");

        vetService.save(vet2);

        System.out.println("loading vets");

    }
}
