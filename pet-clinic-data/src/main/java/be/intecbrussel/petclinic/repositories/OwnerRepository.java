package be.intecbrussel.petclinic.repositories;

import be.intecbrussel.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
