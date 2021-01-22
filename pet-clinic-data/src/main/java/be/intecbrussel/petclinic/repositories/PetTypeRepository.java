package be.intecbrussel.petclinic.repositories;

import be.intecbrussel.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
