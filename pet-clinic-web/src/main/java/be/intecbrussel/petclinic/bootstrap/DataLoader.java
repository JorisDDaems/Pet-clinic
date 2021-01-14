package be.intecbrussel.petclinic.bootstrap;

import be.intecbrussel.petclinic.model.Owner;
import be.intecbrussel.petclinic.model.Vet;
import be.intecbrussel.petclinic.services.OwnerService;
import be.intecbrussel.petclinic.services.VetService;
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
        owner1.setId(1L);
        owner1.setFirstName("jeffrey");
        owner1.setLastName("baetens");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Alexa");
        owner2.setLastName("O'toole");

        ownerService.save(owner2);

        System.out.println("loading owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("brico");
        vet1.setLastName("nocce");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("sulo");
        vet2.setLastName("finn");

        vetService.save(vet2);

        System.out.println("loading vets");

    }
}
