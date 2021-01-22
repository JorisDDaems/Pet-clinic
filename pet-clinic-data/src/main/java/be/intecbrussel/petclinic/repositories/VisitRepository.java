package be.intecbrussel.petclinic.repositories;

import be.intecbrussel.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
