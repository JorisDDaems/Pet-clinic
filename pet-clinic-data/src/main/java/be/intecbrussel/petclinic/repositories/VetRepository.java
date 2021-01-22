package be.intecbrussel.petclinic.repositories;

import be.intecbrussel.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
