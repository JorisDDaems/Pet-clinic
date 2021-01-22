package be.intecbrussel.petclinic.repositories;

import be.intecbrussel.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
