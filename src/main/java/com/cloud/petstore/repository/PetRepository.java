package com.cloud.petstore.repository;

import com.cloud.petstore.data.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
