package be.intecbrussel.petclinic.repositories;

import be.intecbrussel.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
