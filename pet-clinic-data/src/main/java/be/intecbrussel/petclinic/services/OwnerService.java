package be.intecbrussel.petclinic.services;

import be.intecbrussel.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);


}
